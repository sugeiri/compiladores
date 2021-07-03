package com.code.mycode;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;

import com.code.mycode.entities.Entity.AnalysisContext;
import com.code.mycode.entities.Program;
import com.code.mycode.syntax.Parser;
import com.code.translators.MyCodeToJavaScriptTranslator;
import com.code.util.Log;

/**
 * A MyCode compiler, with a main() method to enable running as a standalone application, and
 * utility methods to compile from a stream for invocation by other applications (like testers,
 * debuggers, IDEs, etc).
 */
public class Compiler {

    /**
     *  A custom logger that writes errors and messages from a property file of base name MyCode.
     */
    private Log log = new Log("MyCode", new PrintWriter(System.err, true));

    /**
     * Processes command line arguments and runs the compiler based on the arguments. The command
     * line syntax for running the compiler as an application is:
     * <pre>
     * java MyCode [option] &lt;basefilename&gt;
     * </pre>
     * where &lt;basefilename&gt; is the name of the MyCode source file without the mandatory
     * <code>.carlos</code> extension. Option is:
     * <pre>
     *   -syn: check syntax only, writes to stdout.
     *   -sem: check static semantics only, writes semantic graph to stdout.
     *   -opt: stop after optimizing the semantic graph, writes to stdout.
     *   -js: (the default) translate to JavaScript, writes to .js file.
     * </pre>
     */

    /**
     * Checks the syntax of a MyCode program from a reader.
     */
    public Program checkSyntax(Reader reader) throws IOException {
        log.clearErrors();
        Parser parser = new Parser(reader);
        try {
            log.message("checking_syntax");
            return parser.parse(reader, log);
        } finally {
            reader.close();
        }
    }

    /**
     * Checks the syntax and static semantics given MyCode source code from a reader.
     */
    public Program checkSemantics(Reader reader) throws IOException {
        Program program = checkSyntax(reader);
        if (log.getErrorCount() > 0) {
            return null;
        }
        return checkSemantics(program);
    }

    /**
     * Checks the semantics of a program object.
     */
    public Program checkSemantics(Program program) throws IOException {
        log.message("checking_semantics");
        program.analyze(AnalysisContext.makeGlobalContext(log));
        return program;
    }

    /**
     * Does the whole front end given MyCode source code from a reader.
     */
    public Program produceOptimizedSemanticGraph(Reader reader) throws IOException {
        Program program = checkSemantics(reader);
        if (log.getErrorCount() > 0) {
            return null;
        }
        log.message("optimizing");
        program.optimize();
        return program;
    }

    /**
     * Compiles a MyCode program from a reader and writes the JavaScript to a writer.
     */
    public void generateJavaScript(Reader reader, PrintWriter writer) throws IOException {
        Program program = produceOptimizedSemanticGraph(reader);
        if (log.getErrorCount() > 0) {
            return;
        }
        log.message("writing");
        new MyCodeToJavaScriptTranslator().translateProgram(program, writer);
        writer.close();
    }

    /**
     * Returns the number of errors logged so far.
     */
    public int getErrorCount() {
        return log.getErrorCount();
    }

    /**
     * Tells the compiler whether or not it should suppress log messages.
     */
    public void setQuiet(boolean quiet) {
        log.setQuiet(quiet);
    }
}
