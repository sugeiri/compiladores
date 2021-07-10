using System;
using System.ComponentModel;
using System.Drawing;
using System.IO;
using System.Text.RegularExpressions;
using System.Threading;
using System.Windows.Forms;

namespace Compilador
{
    public partial class Compilador : Form
    {

        public int xClick = 0, yClick = 0;
        public Compilador()
        {
            InitializeComponent();
        }

        private void PictureBox1_Click(object sender, EventArgs e)
        {
            this.Close();
        }

        string palabraanteriorsemantica = "";


        string si1 = "";
        string si2 = "";
        string si3 = "";

        void AgregarFila_Lexico(string token,string lexema)
        {
            var index = DG_Lexico.Rows.Add();
            DG_Lexico.Rows[index].Cells[0].Value = token;
            DG_Lexico.Rows[index].Cells[1].Value = lexema;
            
        }
        void semantica(string palabra, string tipo)
        {
            if (tipo == "variable") { }
            if (tipo == "valor numerico") { }
            if (palabra == "+") { }




        }

        int cont = 0;
        Boolean comentario = false;
        string concatenaComentario = "";

        //void traslate(string palabra, string ) { }
        int asignarcadena = 0;
        private void analiLex()
        {
            palabraanteriorRe = "";
            si = false;
            palabraanteriorsi = "";
            richSi.Text = "";
            si1 = "";
            si2 = "";
            si3 = "";
            CCCode.Text = "";

            asignarcadena = 0;
            
            varecha = false;
            cont = 0;
            comentario = false;
            concatenaComentario = "";
            puntos = 0;

            valoresenteros = 0;
            declaradorentero = 0;
            asignaciones = 0;
            comparaciones = 0;
            sumas = 0;
            restas = 0;
            divisiones = 0;
            valornumericos = 0;
            separador = 0;


            incremento = 0;
            fin = 0;
            declaracioncadenas = 0;
            cierretextoliterales = 0;

            repsn = false;

            aperturatextoliterales = 0;
            cierreoperaciones = 0;
            hacer = 0;
            variables = 0;
            palabraanterior = "";
            tipoanterior = "";
            VamoAlMambo = 1;
            cierreVamoAlMambo = false;

            pr = false;

            vr = false;

            igr = false;

            vnr = false;

            sr = false;

            vr2 = false;

            compr = false;

            vanu = false;

            sp2r = false;

            vafr = false;

            incr = false;
            repetir = false;
            dospuntos = 2;
            variablesrep = 5;
            numeros = 2;

            aesperadefin = 0;

            hayVamoAlMambo = 0;
            exsi = 0;
            esperandocadena = 0;
            variablestring = "";
            concatenacadena = "";
            esperandovalor = 0;
            esperavarconsint = false;
            esperavarint = false;
            e = 0;




            s = false;

            aperturaComparacion = false;

            ComparacionCerrada = false;


            amoc = false;
            vae = false;
            vaes = false;
            vaest = false;
            concate = "";

            ifon = false;

            paif = false;


            cierresi = 0;
            esperandovalor = 0;
           
            richsemantica.Text = "";
            System.IO.File.Delete("variablesINT.txt");
            System.IO.File.Delete("variableString.txt");


            int llavesnecesarias = 0;
            int parentesisnecesarios = 0;
            int llavesnecesariasSi = 0;
            //int parentesisnecesariossi = 0;
            //int variablesnecesariassi = 0;
            //int operadoresnecesarios = 0;
            valoresenteros = 0;
            declaradorentero = 0;
            asignaciones = 0;
            comparaciones = 0;
            sumas = 0;
            restas = 0;
            divisiones = 0;
            valornumericos = 0;
            separador = 0;
            //asignador = 0;
            incremento = 0;
            fin = 0;
            declaracioncadenas = 0;
            cierretextoliterales = 0;
            repsn = false;
            aperturatextoliterales = 0;
            cierreoperaciones = 0;
            hacer = 0;
            variables = 0;
            palabraanterior = "";
            tipoanterior = "";
            VamoAlMambo = 1;
            cierreVamoAlMambo = false;
            pr = false;
            vr = false;
            igr = false;
            vnr = false;
            sr = false;
            vr2 = false;
            compr = false;
            vanu = false;
            sp2r = false;
            vafr = false;
            incr = false;
            repetir = false;
            dospuntos = 2;
            variablesrep = 5;
            numeros = 2;
            aesperadefin = 0;
            hayVamoAlMambo =




               valoresenteros = 0;
            declaradorentero = 0;
            asignaciones = 0;
            comparaciones = 0;
            sumas = 0;
            restas = 0;
            repsn = false;
            cont = 0;
            divisiones = 0;
            valornumericos = 0;
            declaracioncadenas = 0;
            cierretextoliterales = 0;
            aperturatextoliterales = 0;
            cierreoperaciones = 0;
            hacer = 0;
            variables = 0;
            palabraanterior = "";
            VamoAlMambo = 1;
            cierreVamoAlMambo = false;
            hayVamoAlMambo = 0;
            comentario = false;
            exsi = 0;

            char[] delimitadoresChar = { ' ', '\n' };
            char[] delimitadoresCharR = { ',' };

            string concatenatext = "";

            string[] words = CodigoMeedCompyTxt.Text.Split(delimitadoresChar);
            int numero = 0;
            string plabrasR = System.IO.File.ReadAllText("palabras reservadas.txt");
            String[] palabrasReservadas = plabrasR.Split(delimitadoresCharR);

            foreach (string word in words)
            {


                string tipo = "";
                System.Console.WriteLine($"<{word}>");


                if (word == "//") { comentario = true; }

                if (comentario == false)
                {
                    concatenatext += " " + word;


                    if (word == "VamoAlMambo" |

                      word == "si" |
                      word == "escribir" |


                      word == "fin" |
                      word == "" |

                      word == "repetir")

                    {







                        if (word != "")
                        {
                            //se jodio
                            escribir(word, tipo);
                            MandarPalabraReservada(word);
                            tipo = "palabra reservada"; AnalalisisSintactico(word, tipo); traducir(word, tipo); Repetir(word, tipo);
                            semantica(word, tipo);
                            sintactica(word, tipo);
                            cierres(word, tipo);
                        }





                    }
                    else if (word.ToLower() == "sino")
                    {
                        tipo = "sino"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo);

                    }
                    else if (word == "=" |
                      word == "==" |
                       word == "<" |
                        word == ">" |
                      word == "fin" |
                      word == "+" |
                      word == "," |
                      word == ":" |
                      word == "++" |
                      word == "-" |
                      word == "|" |
                      word == "/" |
                       word == ";" |
                        word == "?" |
                        word == "<<" |
                        word == ">>" |
                        word == "hacer" |
                         word == "@" |
                      word == "entero" |
                      word == "flotante" 

                     )
                    {

                        MandarSigno(word);
                        if (word == "=") { tipo = "asignacion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == ",") { tipo = "separador"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "|") { tipo = "separ"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }

                        if (word == "<") { tipo = "comparacion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == ">") { tipo = "comparacion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }


                        if (word == "==") { tipo = "comparacion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "+") { tipo = "suma"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "++") { tipo = "incremento"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "-") { tipo = "resta"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "/") { tipo = "divicion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == ";") { tipo = "cierre operacion"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "entero") { tipo = "declaracion entero"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "flotante") { tipo = "declaracion flotante"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "@") { tipo = "declaracion cadena"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == ":") { tipo = "dosdot"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "<<") { tipo = "apertura textoliteral"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == ">>") { tipo = "cierre textoliteral"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "hacer") { tipo = "hacer"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "fin") { cierrefin += 1; tipo = "fin"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }
                        if (word == "?") { tipo = "cierresi"; AnalalisisSintactico(word, tipo); traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo); }


                    }



                    else if (word == "//")
                    {
                        comentario = true;



                        AgregarFila_Lexico("comando de comentario: ",word);
                        //RIchTxLexico.Text = RIchTxLexico.Text + "comando de comentario: " + word + "\n";


                    }
                    else if (word == "(" | word == ")" | word == "{" | word == "}" | word == "};")
                    {


                        if (word != "};")
                        {
                            AgregarFila_Lexico("Signo de agrupación",word);
                            //RIchTxLexico.Text = RIchTxLexico.Text + "Signo de agrupación: " + word + "\n";

                            if (word == "(")
                            {

                                tipo = "apertura parentesis";
                                AnalalisisSintactico(word, tipo);
                                traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo);
                                escribir(word, tipo);

                            }
                            else if (word == ")")
                            {

                                tipo = "cierre de parentesis";
                                AnalalisisSintactico(word, tipo);
                                traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo);


                            }
                            else if (word == "{")
                            {

                                tipo = "apertura de llave";
                                AnalalisisSintactico(word, tipo);
                                traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo);


                            }
                            else if (word == "}")
                            {

                                tipo = "cierre de llave";
                                AnalalisisSintactico(word, tipo);
                                traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo);


                            }


                        }
                        else
                        {


                            AgregarFila_Lexico("cierre de VamoAlMambo", word);
                            //RIchTxLexico.Text = RIchTxLexico.Text + "cierre de agrupación principal VamoAlMambo: " + word + "\n";
                            tipo = "cierre VamoAlMambo";
                            AnalalisisSintactico(word, tipo);
                            traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo); escribir(word, tipo);

                        }


                    }
                    else
                    {
                        if (int.TryParse(word, out numero))
                        {

                            tipo = "valor numerico";

                            AgregarFila_Lexico("Valor constante", word);
                            //RIchTxLexico.Text = RIchTxLexico.Text + "Valor constante: " + word + "\n";
                            AnalalisisSintactico(word, tipo);
                            traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo);
                            escribir(word, tipo);


                        }
                        else if (word != null)
                        {
                            tipo = "variable";
                            // aqui es probable que en ejemplo se escriba de esta manera un if "  si(numero1==numero2)hacer  " lo reconocera
                            // de esta forma "Variable local: si(numero1==numero2)hacer"
                            // por lo que tendria que traer la cadena o la word que viene y analizar letra por letra en busca
                            //de palabras reservadas
                            //... dos opciones o busco la forma de que funcione el analizar el word y sepa cuando hay palabras reservadas
                            //o fin hago que el compy se trate de dejar los espacios

                            AgregarFila_Lexico("Variable local", word);
                            //RIchTxLexico.Text = RIchTxLexico.Text + "Variable local: " + word + "\n";
                            AnalalisisSintactico(word, tipo);
                            traducir(word, tipo); sintactica(word, tipo); cierres(word, tipo); Repetir(word, tipo);
                            escribir(word, tipo);



                        }
                    }

                }
                else
                {
                    // todo lo que aparezca aqui es comentario hasta que se encuentre un //
                    cont += 1;

                    concatenaComentario += " " + word;

                    if (word == "///")
                    {
                        //RIchTxLexico.Text += concatenaComentario + "\n";
                        AgregarFila_Lexico("Comentario", concatenaComentario);
                        // aqui termina el comentario
                        //RIchTxLexico.Text += "terninó el comentario\n";
                        comentario = false;

                        string ne = concatenaComentario + "";
                        concatenaComentario = "";


                    }



                    // int index = CodigoMeedCompyTxt.SelectionStart;
                    // int sta = (concatenaComentario.Length - concatenatext.Length)*-1;
                    //// MessageBox.Show("la resta de " + concatenaComentario.Length.ToString() + " Y " + concatenatext.Length.ToString() + " es: " + sta.ToString());

                    // CodigoMeedCompyTxt.Select(concatenatext.Length, concatenaComentario.Length + concatenatext.Length);
                    // CodigoMeedCompyTxt.SelectionColor = Color.Green;
                    // CodigoMeedCompyTxt.SelectionStart = index;
                    // CodigoMeedCompyTxt.Font = new Font(CodigoMeedCompyTxt.Font, FontStyle.Bold);

                    // CodigoMeedCompyTxt.SelectionColor = Color.White;
}

            }
          

            if (llavesnecesarias == 0)
            {
                if (cierreVamoAlMambo == false)
                { //richErroresSintac.Text += "Error se esperaba }; cierre de VamoAlMambo\n"; 
                }
                else { analisisSin.Text += "no se encontraron errores en las llaves usadas\n"; }
            }
            else
            { //richErroresSintac.Text += "verifica si usas las llaves correctamente\n"; 
            }
            if (VamoAlMambo == 1)
            {
                //richErroresSintac.Text += "No se encuentra la funcion principal VamoAlMambo\n";
            }
            if (llavesnecesariasSi == 0) { analisisSin.Text += "las llaves del si son correctas \n"; }

            if (parentesisnecesarios == 0)
            {
                analisisSin.Text += "no se encontraron errores en las parentesis usados\n";
            }
            else
            { //richErroresSintac.Text += "verifica si usas los parentesis correctamente\n"; 
            }
            if (variables == 0)
            {
                analisisSin.Text += "se han utilizado un numero correcto de variables \n";
            }
            else if (variables == 1)
            {
                if (valoresenteros == 0) { analisisSin.Text += "se han utilizado un numero correcto de variables y valores enteros\n"; }
            }
            else if (valoresenteros == 1)
            {


                analisisSin.Text += "se pude estar usando una estructura de repetir\n";
            }
            //else
            //{

            //    richErroresSintac.Text += "verifica si usas un expresion de (variable == variable) o (variable == constante)\n";

            //}
            //if (comparaciones == 0) { analisisSin.Text += "el numero de comparadores es correcto \n"; }
            //else { richErroresSintac.Text += "Error comparadores en <<si ( variable comparador variable_constante )>> puedes tener uno de más o puede que te falte uno \n"; }
            //if (hacer == 0) { analisisSin.Text += "el numero de palabras hacer coincide con el numero de si \n"; }
            //else
            //{
            //    richErroresSintac.Text += "Error falta o sobra un <<hacer>>\n";

            //}


            //pintar();
            pintarTraduccion();

            /////////////////////////////////////////////////////// aqui viene el analisis sintactico del SI //////////////////  
            //llavesnecesarias = 2;
            //parentesisnecesarios = 2;
            //variables = 2;
            //valoresenteros = 1;
            //comparaciones = 1;




            //parentesisnecesarios = 2;
            //separador = 3;
            //fin = 1;
            //asignaciones = 1;
            //variables = 5;
            //valornumericos = 3;
            //comparaciones = 1;
            //MessageBox.Show("el valor de richsi es: " + richSi.Text);
            //if (richSi.Text != "si ( variable == variable2 ) hacer { ") { richErroresSintac.Text += "Error se detectaron errores en la estructura de <<si>>"; }
            if (cierresi > 0)
            {
              //  richErroresSintac.Text += "se esperaba un <<?>> para el cierre de un <<si>>";

            }
            if (cierrefin > 0)
            {
                //richErroresSintac.Text += "se esperaba un <<fin>> para el cierre de un <<repetir>>";




            }





        }
        string palabraanteriorsi = "";
        int cierresi = 0;
        int cierrefin = 0;
        string palabraanteriorRe = "";


        void Repetir(string palabra, string tipo)
        {


            if (palabra == "repetir") { analisisSin.Text += "Se ha detectado un <<repetir>>"; richRepetir.Text += "repetir "; palabraanteriorRe = palabra; }
            else if (palabra == "(" && palabraanteriorRe == "repetir")
            {
                palabraanteriorRe = "(";
                richRepetir.Text += "( ";

            }

        }

        Boolean varecha = false;
        Boolean si = false;
        Boolean esperartexto = false;
        string conca = "";


        void escribir(string palabra, string tipo)
        {


            if (palabra == "escribir" | esperartexto == true)
            {

                esperartexto = true;
                if (tipo == "variable" | tipo == "valor numerico")
                {
                    conca += palabra + " ";



                }
                else if (palabra == "|")
                {

                    esperartexto = false;

                }
                palabraanterior = palabra;
            }




        }

        void pedir(string palabra, string tipo)
        {





        }



        void sintactica(string palabra, string tipo)
        {




            /// rehaciendo la sintactica, empezamos por el si //////
            /// 

            if (palabra == "si" /*&& richSi.Text != null */)
            {

                if (richSi.Text == null)
                {
                    analisisSin.Text += "Se ha detectado un <<si>>"; richSi.Text += "si "; palabraanteriorsi = palabra;


                }
                else
                {


                    if (richSi.Text == "si ( variable == variable2 ) hacer { ")
                    {


                        analisisSin.Text += "Se detecto un estructura correcta de <<si>> esperando <<?>>";
                        richSi.Text = "si ";
                    }
                    analisisSin.Text += "Se ha detectado un <<si>>"; richSi.Text += "si "; palabraanteriorsi = palabra;

                }
                richSi.Text = "si ";
                si = true;



            }

            if (si == true)
            {

                if (palabra == "(")
                {
                    if (richSi.Text == "si ")
                    {


                        richSi.Text += "( "; palabraanteriorsi = palabra;

                    }
                    //else
                    //{

                    //    richErroresSintac.Text += "se ha detectado un error en un <<si>> o <<repetir>> \n";
                    //}

                }
                else if (tipo == "variable")
                {

                    if (richSi.Text == "si ( ")
                    {

                        varecha = true;
                        richSi.Text += "variable "; palabraanteriorsi = palabra;
                    }
                    else if (varecha == false)
                    {

                       // richErroresSintac.Text += "se ha detectado un error en un deberia haber un <<(>> antes de una variable \n";


                    }


                }
                else if (richSi.Text == "si ( variable " && palabra == "==")
                {
                    richSi.Text += "== "; palabraanteriorsi = palabra;
                }
                else if (richSi.Text == "si ( variable == " && tipo == "variable")
                {
                    richSi.Text += "variable2 "; palabraanteriorsi = palabra;
                }
                else if (richSi.Text == "si ( variable == variable2 " && palabra == ")")
                {
                    richSi.Text += ") "; palabraanteriorsi = palabra;
                }
                else if (richSi.Text == "si ( variable == variable2 ) " && palabra == "hacer")
                {
                    if (palabraanteriorsi == ")")
                    {
                        richSi.Text += "hacer "; palabraanteriorsi = palabra; analisisSin.Text += "<<hacer colocado correctamente>>\n";
                    }
                    else
                    {
                       // richErroresSintac.Text += "ERROR en una estructura <<si>> fin puede haber un <<)>> antes de un hacer\n";
                        palabraanteriorsi = palabra;
                    }   ////////////////////// aqui validamos que si la palabra anterior es un parentesis el hacer es correcto
                }
                else if (richSi.Text == "si ( variable == variable2 ) hacer " && palabra == "{")
                {

                    cierresi += 1;
                    richSi.Text += "{ ";
                    palabraanteriorsi = palabra;
                    analisisSin.Text = "se ha completado un <<si>> correctamente";
                    si = false;
                }


            }



            if (tipo == "variable")
            {
                tipoanterior = tipo;
                variables += 1;
                if (palabraanterior == "entero" || palabraanterior == "flotante")
                {

                    variables -= 1;
                    using (StreamWriter agregar = new StreamWriter("variablesINT.txt", true))
                    {
                        agregar.Write(palabra);
                        //richenteras.Text += palabra + ","; agregar.Write(",");

                       

                        //varnumasig.Text += palabra;
                    }

                    analisisSin.Text = "se ha declarado como entero la variable: " + palabra + " \n";
                    palabraanterior = palabra;
                    esperandovalor += 1;

                }
                /////////////////////////
                else if (palabraanterior == "@")
                {
                    using (StreamWriter agregar = new StreamWriter("variableString.txt", true))
                    {

                       // agregar.Write(palabra); richcadenas.Text += palabra + ","; agregar.Write(",");
                        variablestring = palabra;
                    }
                    analisisSin.Text += "se ha declarado como candena la variable: " + palabra + " pero se espera su asignación\n";
                    asignarcadena += 1;


                }
                else
                {
                    Boolean cadena = false;
                    Boolean entero = false;
                    char[] delimitadoresCharR = { ',' };
                    //string[] wordscadenas = richcadenas.Text.Split(delimitadoresCharR);

                    //string[] wordsenteros = richenteras.Text.Split(delimitadoresCharR);
                    //foreach (string word in wordscadenas)
                    //{
                    //    if (word == palabra)
                    //    {
                    //        cadena = true;
                    //    }
                    //}
                    //foreach (string word in wordsenteros)
                    //{
                    //    if (word == palabra)
                    //    {
                    //        entero = true;
                    //    }
                    //}
                    if (cadena == true && entero == true)
                    {

                      //  richErroresSintac.Text += "Error, la variable " + palabra + " se repite como cadena y como numero";

                    }
                    else if (cadena == true && entero == false)
                    {

                        analisisSin.Text += "se encontro " + palabra + " como variable de tipo CADENA\n";

                    }
                    else if (cadena == false && entero == true)
                    {

                        analisisSin.Text += "se encontro " + palabra + " como variable de tipo ENTERO\n";

                    }
                    //else { richErroresSintac.Text += "Error la variable " + palabra + " no se ha declarado\n"; }
                }




                palabraanterior = "variable";


            }




        }

        void cierres(string palabra, string tipo)
        {

            if (palabra == "?")
            {
                cierresi -= 1;
                analisisSin.Text += "se ha cerrado la estructura de un if";

            }
            if (palabra == "fin")
            {
                cierrefin -= 1;
                analisisSin.Text += "se ha cerrado la estructura de un repetir";

            }


        }
        
        private void ThreadSafe(Action callback, Form form)
        {
            BackgroundWorker worker = new BackgroundWorker();
            worker.RunWorkerCompleted += (obj, e) =>
            {
                if (form.InvokeRequired)
                    form.Invoke(callback);
                else
                    callback();
            };
            worker.RunWorkerAsync();
        }



        void pintar()
        {

            ThreadSafe(() =>
            {
                string modelo = "";
                string[] palabras = { "si", "fin", "se", "repetir", "@", "entero","flotante", "VamoAlMambo", "hacer", "fin", "//", "MeedCompy" , "MeedMusic", "Meedot",
                "sino", "escribir", "Meed", "kevin del cid", "<<" , ">>","|","<",">"};

                foreach (var a in palabras)
                {
                    modelo += a + "|";
                }
                Regex r = new Regex(modelo);
                int index = CodigoMeedCompyTxt.SelectionStart;
                foreach (Match m in r.Matches(CodigoMeedCompyTxt.Text))
                {
                    CodigoMeedCompyTxt.Select(m.Index, m.Value.Length);
                    CodigoMeedCompyTxt.SelectionColor = Color.Orange;
                    CodigoMeedCompyTxt.SelectionStart = index;
                    CodigoMeedCompyTxt.Font = new Font(CodigoMeedCompyTxt.Font, FontStyle.Bold);
                }
                CodigoMeedCompyTxt.SelectionColor = Color.White;

            }, this);



        }
        void pintarTraduccion()
        {

            ThreadSafe(() =>
            {
                string modelo = "";
                string[] palabras = { "if", "for", "int","float", "VamoAlMambo","#","return","using","include","iostream", "//","else","<<" , ">>","|","<",">"};
                foreach (var a in palabras)
                {
                    modelo += a + "|";
                }
                Regex r = new Regex(modelo);
                int index = CCCode.SelectionStart;
                foreach (Match m in r.Matches(CCCode.Text))
                {
                    CCCode.Select(m.Index, m.Value.Length);
                    CCCode.SelectionColor = Color.Green;
                    CCCode.SelectionStart = index;
                    CCCode.Font = new Font(CCCode.Font, FontStyle.Bold);
                }
                CCCode.SelectionColor = Color.White;

            }, this);



        }
        void MandarPalabraReservada(string pReservada)
        {


            AgregarFila_Lexico("Palabra reservada", pReservada);
            //RIchTxLexico.Text = RIchTxLexico.Text + "Palabra reservada: " + pReservada + "\n";


        }
        void MandarSigno(string sReservada)
        {

            //RIchTxLexico.Text = RIchTxLexico.Text + "Signo operador o delimitador: " + sReservada + "\n";
            AgregarFila_Lexico("Operador o Delimitador", sReservada);


        }

       
        int llavesnecesarias = 0;
        int parentesisnecesarios = 0;

        int llavesnecesariasSi = 0;

        int valoresenteros = 0;
        int declaradorentero = 0;
        int asignaciones = 0;
        int comparaciones = 0;
        int sumas = 0;
        int restas = 0;
        int divisiones = 0;
        int valornumericos = 0;
        int separador = 0;


        int incremento = 0;
        int fin = 0;
        int declaracioncadenas = 0;
        int cierretextoliterales = 0;

        Boolean repsn = false;

        int aperturatextoliterales = 0;
        int cierreoperaciones = 0;
        int hacer = 0;
        int variables = 0;
        string palabraanterior = "";
        string tipoanterior = "";
        int VamoAlMambo = 1;
        Boolean cierreVamoAlMambo = false;

        Boolean pr = false;

        Boolean vr = false;

        Boolean igr = false;

        Boolean vnr = false;

        Boolean sr = false;

        Boolean vr2 = false;

        Boolean compr = false;

        Boolean vanu = false;

        Boolean sp2r = false;

        Boolean vafr = false;

        Boolean incr = false;
        Boolean repetir = false;
        int dospuntos = 2;
        int variablesrep = 5;
        int numeros = 2;

        int aesperadefin = 0;

        int hayVamoAlMambo = 0;
        int exsi = 0;
        int esperandocadena = 0;
        string variablestring = "";
        string concatenacadena = "";
        int esperandovalor = 0;
        Boolean esperavarconsint = false;
        Boolean esperavarint = false;
        int e = 0;
        void AnalalisisSintactico(string palabra, string tipo)
        {

            if (esperavarconsint == true)
            {
                // entrando aqui sabemos que tenemos una estrucctura de comparacion pero fin podemos comparar con un valor del mismo 
                // tipo 
                if (palabraanterior != "==")
                {


                    // richErroresSintac.Text += "no se encontró el dato esperado ERRROR\n";
                }
                else
                {
                    if (tipo == "variable")
                    {
                        // se detectó una estructura correcta realizando analisis semántico
                        // debo buscar lo que se encuentra en plabra en el richtextboxenteros 
                        // si existe esta variable alli saabremos que todo esta semantica y sintacticamente correcto
                      //  string cadenarnteras = varnumasig.Text;


                        char[] delimitadoresChar = { ' ', ',' };


                        string concatenatext = "";

                       // string[] words = varnumasig.Text.Split(delimitadoresChar);
                        int numero = 0;

                        Boolean siay = false;
                        //foreach (string word in words)
                        //{
                        //    if (word == palabra)
                        //    {
                        //        // aqui se que se encontró la variable de tipo entero

                        //        siay = true;
                        //        break;
                        //    }

                        //}
                        if (siay == true)
                        {
                            richsemantica.Text += "la expresioon coinside en tipos enteros\n";

                        }
                        else { //erroresSemanticos.Text += "error no se encontró la variable de tipoo entero verifique si la ha declarado anteriormente o que los valores son del mismo tipo\n";
                               }


                    }
                    else if (tipo == "valor numerico")
                    {

                        richsemantica.Text += "los valores coinciden en tipo\n";

                    }


                }


            }



            cierreVamoAlMambo = false;
            if (palabra == "};")
            {

                cierreVamoAlMambo = true;

            }
            if (asignarcadena > 0 && palabra != "<<")
            {

              //  richErroresSintac.Text += "no se esta asignando un valor a la variable @\n";


            }

            if (esperandocadena > 0)
            {

                if (palabra == ">>")
                {

                    esperandocadena -= 1;
                    
                    richsemantica.Text += "a la variable de tipo @ se le han asignado datos correctos\n";



                }
                else if (tipo == "variable" | e == 0)
                {

                    concatenacadena += " " + palabra;
                    tipo = "";
                    palabra = "";

                }




            }

            if (esperandovalor > 0)
            {
               
                if (tipo == "valor numerico")
                {

                   // varnumasig.Text += " " + palabra + ",";
                    esperandovalor -= 1;

                    variables += 1;
                   
                    richsemantica.Text += "el valor asignado a las variables # es correcto\n";

                }
                else
                {


                    //richErroresSintac.Text = "Error verifica si has asignado correctamente tu variable de tipo # entero\n";
                    //erroresSemanticos.Text += "Error verifica si has asignado correctamente tu variable de tipo # entero\n";
                }





            }

            if (tipo == "palabra reservada")
            {



                if (palabra == "VamoAlMambo")
                {
                    hayVamoAlMambo += 1;
                  

                    palabraanterior = palabra;
                    VamoAlMambo = 0;
                    llavesnecesarias = 1;

                }

                if (palabra == "si")
                {
                    if (exsi == 0)
                    {

                        palabraanterior = palabra;
                        llavesnecesarias = 2;
                        parentesisnecesarios = 2;
                        variables = 2;
                        valornumericos = 1;
                        comparaciones = 1;
                        hacer = 1;
                        exsi = 1;

                    }
                    else if (exsi == 1 && llavesnecesarias == 1)
                    {


                        palabraanterior = palabra;
                        llavesnecesarias = 2 + exsi;
                        parentesisnecesarios = 2;
                        variables = 2;
                        valornumericos = 1;
                        comparaciones = 1;
                        hacer = 1;
                        exsi += 1;


                    }
                    else
                  if (exsi > 0 && llavesnecesarias == 0)
                    {


                        palabraanterior = palabra;
                        llavesnecesarias = 2;
                        parentesisnecesarios = 2;
                        variables = 2;
                        valornumericos = 1;
                        comparaciones = 1;
                        hacer = 1;
                        exsi += 1;


                    }






                }
                else if (palabra == "si" && exsi != 0 && llavesnecesarias == 0)
                {
                    palabraanterior = palabra;
                    llavesnecesarias = 2;
                    parentesisnecesarios = 2;
                    variables = 2;
                    valornumericos = 1;
                    comparaciones = 1;
                    hacer = 1;
                    exsi += 1;
                }
                else
                {
               }
                if (palabra == "hacer")
                {
                    palabraanterior = palabra;
                }
                if (palabra == "fin")
                {
                    fin--;
                    palabraanterior = palabra;
                }
                if (palabra == "repetir")
                {
                    // repetir : variable numerovar , variable numerovar , variable numerovar :
                    // utilizadas
                    dospuntos = 2;
                    variablesrep = 5;
                    numeros = 2;

                    separador = 2;
                    incremento = 1;
                    repetir = true;

                    palabraanterior = palabra;
                    tipoanterior = tipo;




                }



            }
            else if (repetir == true)
            {

                if (tipo == "variable" && palabra == ":") // aqui unicamente reconocemos los 2 puntos
                {

                    if (palabraanterior == "repetir")
                    { // aqui tenemos los dos puntos iniciables y restamos uno 
                        dospuntos -= 1;
                        tipoanterior = tipo;


                    }
                    else if (palabra == ":" && palabraanterior == "++")
                    {


                        analisisSin.Text = "se termino la expresion de <<repetir>> con << : >> se espera un <<fin>>";
                        fin++;


                    }
                    else if (palabraanterior == "++")
                    {
                        // aqui tenemos los dos puntos que cierran la expresion
                        analisisSin.Text += "se han agregado : para iniciar el <<repetir>> \n";
                        dospuntos -= 1;
                        tipoanterior = tipo;
                    }
                    else
                    {
                       // richErroresSintac.Text += "Error, verifica donde colocas los << : >>\n";
                    }

                }
                else if (palabra == "++")
                {
                    palabraanterior = palabra;
                    tipoanterior = tipo;
                    incremento -= 1;



                }
                else if (tipo == "valor numerico")
                {
                    // aqui si la palaba es uun numero
                    tipoanterior = tipo;
                }
                else if (palabra == ",")
                {


                    // aqui tenemos una , asi que hacemos la resta de recurso 
                    if (tipoanterior == "variable" | tipoanterior == "valor numerico")
                    {
                        separador -= 1;
                        palabraanterior = palabra;
                        tipoanterior = tipo;
                        // si el tipo anteriro es una variable la , estará bien colocada
                        analisisSin.Text += "una si hay una variable o constante antes de la << , >> Correcto\n";

                    }
                    else
                    {
                       // richErroresSintac.Text += "ERROR verifica la posicion de las << , >>\n";

                    }


                }
                else
                {
                    // aqqui sabemos que es una variable 

                    if (palabraanterior == ":")
                    {
                        palabraanterior = palabra;
                        tipoanterior = tipo;
                        analisisSin.Text += "la variable " + palabra + " se ha agregado a la expresion del <<repetir>> ";
                        // aqui todo iria bien aqui tendriamos que llevar de la estructura de repetir
                        // repetir : variable1

                        variablesrep -= 1;
                    }
                    //

                }




            }
            else
            {



                if (tipo == "apertura de llave") { llavesnecesarias = llavesnecesarias - 1; if (palabraanterior == "se" | palabraanterior == "VamoAlMambo" | palabraanterior == "hacer") { analisisSin.Text = "sin errores entre VamoAlMambo o hacer\n"; } else {// richErroresSintac.Text = "verifica no tener palabras entre VamoAlMambo o hacer y sus llaves\n";
                                                                                                                                                                                                                                                       } }
                if (tipo == "se") { if (palabraanterior != "cierre de llave") {// richErroresSintac.Text = "Error la palabra <<se>> no esta siendo utilizada correctamente\n"; } else { analisisSin.Text = "sino situado correctamente\n";
                                                                               } }

                if (tipo == "cierre de llave") { llavesnecesarias -= 1; palabraanterior = tipo; }

                if (tipo == "cierre VamoAlMambo") { cierreVamoAlMambo = true; }// una  vez se cerro el VamoAlMambo ya nada debe ser funcional
                if (tipo == "apertura parentesis")
                {
                    parentesisnecesarios -= 1;
                    if (palabraanterior == "si" | palabraanterior == "repetir")
                    {

                        /////////// unicamente me falta saber por que el repetir no logra hacer que los datps entren a los de aqui a decrementarse
                        analisisSin.Text = "sin errores entre si o repetir\n";
                    }
                    else
                    {
                        //richErroresSintac.Text = "verifica no tener palabras entre palabras si o repetir que no sean <<(>> \n";
                    }
                    palabraanterior = "apertura parentesis";
                }
                if (tipo == "cierre de parentesis")
                {
                    if (tipoanterior == "variable" | tipoanterior == "valor numerico")
                    {
                        analisisSin.Text += "se ha cerrado el parentesis correctamente\n";


                    }
                    else
                    {

//                        richErroresSintac.Text += "antes de el cierre de parentesis debe haber una variable o un numero\n";


                    }
                }
                if (tipo == "declaracion entero") { declaradorentero -= 1; palabraanterior = "entero"; }
                if (tipo == "declaracion flotante") { declaradorentero -= 1; palabraanterior = "flotante"; }
                if (tipo == "asignacion") { asignaciones -= 1; palabraanterior = "="; }
                if (tipo == "comparacion")
                {
                    comparaciones -= 1;





                    if (tipoanterior == "variable")
                    {
                        analisisSin.Text += "se detectó structura variable == se espera valor numerico variable o constante entera\n";
                        esperavarconsint = true;
                    }
                    else if (tipoanterior == "valor numerico")
                    {
                        analisisSin.Text += "se detectó structura numero == se espera una variable de tipo entero\n";

                        esperavarint = true;


                    }



                    palabraanterior = "==";





                }
                if (tipo == "suma") { sumas -= 1; palabraanterior = "+"; }
                if (tipo == "incremento") { sumas -= 1; palabraanterior = "++"; }
                if (tipo == "resta") { restas -= 1; palabraanterior = "-"; }
                if (tipo == "division") { divisiones -= 1; palabraanterior = "/"; }
                if (tipo == "cierre operacion") { cierreoperaciones -= 1; palabraanterior = ";"; }
                if (tipo == "declaracion cadena") { declaracioncadenas -= 1; palabraanterior = "@"; }
                if (tipo == "apertura textoliteral") { aperturatextoliterales -= 1; palabraanterior = "<<"; esperandocadena += 1; asignarcadena -= 1; }
                if (tipo == "cierre textoliteral") { cierretextoliterales -= 1; palabraanterior = ">>"; }
                if (tipo == "valor numerico")
                {
                    valornumericos -= 1; palabraanterior = palabra;

                    tipoanterior = tipo;


                }
                if (tipo == "variable")
                {
                    tipoanterior = tipo;
                    variables += 1;
                    if (palabraanterior == "entero" || palabraanterior == "flotante" )
                    {

                        variables -= 1;
                        using (StreamWriter agregar = new StreamWriter("variablesINT.txt", true))
                        {
                            agregar.Write(palabra);
                           // richenteras.Text += palabra + ","; agregar.Write(",");

                            // para hacer   QUE NO SE PUEDAN REPETIR LAS VARIABLES DEL MISMO TIPO HACER QUI UN FOREACH

                          //  varnumasig.Text += palabra;
                        }

                        analisisSin.Text = "se ha declarado como entero la variable: " + palabra + " \n";
                        palabraanterior = palabra;
                        esperandovalor += 1;

                    }
                    /////////////////////////
                    else if (palabraanterior == "@")
                    {
                        using (StreamWriter agregar = new StreamWriter("variableString.txt", true))
                        {

                            agregar.Write(palabra); //richcadenas.Text += palabra + ",";
                                                    agregar.Write(",");
                            variablestring = palabra;
                        }
                        analisisSin.Text += "se ha declarado como candena la variable: " + palabra + " pero se espera su asignación\n";
                        asignarcadena += 1;


                    }
                    else
                    {
                        Boolean cadena = false;
                        Boolean entero = false;
                        char[] delimitadoresCharR = { ',' };
                        //string[] wordscadenas = richcadenas.Text.Split(delimitadoresCharR);

                        //string[] wordsenteros = richenteras.Text.Split(delimitadoresCharR);
                        //foreach (string word in wordscadenas)
                        //{
                        //    if (word == palabra)
                        //    {
                        //        cadena = true;
                        //    }
                        //}
                        //foreach (string word in wordsenteros)
                        //{
                        //    if (word == palabra)
                        //    {
                        //        entero = true;
                        //    }
                        //}
                        if (cadena == true && entero == true)
                        {

                     //       richErroresSintac.Text += "Error, la variable " + palabra + " se repite como cadena y como numero";

                        }
                        else if (cadena == true && entero == false)
                        {

                            analisisSin.Text += "se encontro " + palabra + " como variable de tipo CADENA\n";

                        }
                        else if (cadena == false && entero == true)
                        {

                            analisisSin.Text += "se encontro " + palabra + " como variable de tipo ENTERO\n";

                        }
                        else { //richErroresSintac.Text += "Error la variable " + palabra + " no se ha declarado\n";
                               }
                    }




                    palabraanterior = "variable";


                }
                if (tipo == "hacer") { hacer -= 1; palabraanterior = "hacer"; }
                ////////
                if (tipo == "separador") { separador -= 1; palabraanterior = ","; }
                if (tipo == "fin") { fin -= 1; palabraanterior = "fin"; }



            }




        }



        Boolean s = false;

        Boolean aperturaComparacion = false;

        Boolean ComparacionCerrada = false;


        private void Form1_MouseMove(object sender, MouseEventArgs e)
        {
            if (e.Button != MouseButtons.Left)
            { xClick = e.X; yClick = e.Y; }
            else
            { this.Left = this.Left + (e.X - xClick); this.Top = this.Top + (e.Y - yClick); }
        }





        Boolean amoc = false;
        Boolean vae = false;
        Boolean vaes = false;
        Boolean vaest = false;
        string concate = "";

        Boolean ifon = false;

        Boolean paif = false;

        Boolean dec = false;
        int puntos = 0;
        string con = "";


        void traducir(string palabra, string tipo)
        {
            char[] delimitadoresChar = { ' ', '\n' };
            string[] words = CodigoMeedCompyTxt.Text.Split(delimitadoresChar);
            int ciers = 0;
            
            if (palabra != "//" && palabra != "///")
            {
                /////////////// aqui sabemos que no estamos comentando las cosas ///////////////////////////
                ///
                if (palabra == "<") { CCCode.Text += "<"; }
                if (palabra == ">") { CCCode.Text += ">"; }
                if (palabra == "sino") { CCCode.Text += "else "; }
                if (palabra == "|") { CCCode.Text += "\" ; "; }
                if (palabra == "escribir") { CCCode.Text += "\ncout << \" "; }
                if (palabra == "@") { CCCode.Text += "\nstring "; }
                if (palabra == "?") { CCCode.Text += "\n}"; }
                if (palabra == "entero") { CCCode.Text += "\nint "; dec = true; }
                if (palabra == "flotante") { CCCode.Text += "\nfloat "; dec = true; }
                if (tipo == "separador") { CCCode.Text += ";"; }
                if (palabra == "VamoAlMambo") {
                    CCCode.Text += "//PROGRAMA EN C \n#include <iostream>\nusing namespace std;\nint main()\n";
                }
                if (palabra == "};") { CCCode.Text += "\nreturn 0 ;\n}"; }
                if (palabra == "{") { CCCode.Text += palabra + "\n"; }
                if (palabra == "}") { CCCode.Text += palabra + "\n"; }
                if (tipo == "dosdot") { CCCode.Text += "){\n"; }
                if (palabra == "=") { CCCode.Text += " = "; }
                if (palabra == "fin") { CCCode.Text += "}\n"; }
                if (palabra == "==") { CCCode.Text += " == "; }
                if (palabra == "++") { CCCode.Text += "++ "; }
                if (palabra == "+") { CCCode.Text += "+ "; }
                if (palabra == "(") { CCCode.Text += "( "; }
                if (palabra == ")") { CCCode.Text += " )"; }
                if (palabra == "repetir") { CCCode.Text += "for"; }
                if (palabra == "si") { CCCode.Text += "if"; }
                if (tipo == "valor numerico") { if (dec == true) { CCCode.Text += " = " + palabra + ";\n "; dec = false; } else { CCCode.Text += palabra; } }
                if (palabra == "<<") { CCCode.Text += " = \" "; }
                if (palabra == ">>") { CCCode.Text += "\";\n"; }
                if (tipo == "variable") { CCCode.Text += "" + palabra + " "; }
                if (tipo == "=") { CCCode.Text += " " + palabra + " "; }
            }
            else
            {
                ////////////////////  aqui sabemos que se incio un comentario /////////////
                //commmm = true;
                //if (palabra == "///") { commmm = false; }





            }


        }





      
        private void BCargar_Click(object sender, EventArgs e)
        {
            StreamReader leer = new StreamReader("programafinal.txt");
            CodigoMeedCompyTxt.Text = leer.ReadToEnd();
        }
        
        private void BAnalisis_Click(object sender, EventArgs e)
        {
            DG_Lexico.Rows.Clear();
            string newtext = "";
            newtext = "";//RIchTxLexico.Text;
            //RIchTxLexico.Text = "";

            string newtexterro = "";
            //newtexterro = richErroresSintac.Text;
            //richErroresSintac.Text = "";


            analiLex();
            // ErroresSintacticos();


        }

        private void Compilador_Load(object sender, EventArgs e)
        {
            StreamReader leer = new StreamReader("programafinal.txt");
            CodigoMeedCompyTxt.Text = leer.ReadToEnd();
            pintar();
        }

        private void BCcodigo_Click(object sender, EventArgs e)
        {
            Clipboard.SetText(CCCode.Text);
            MessageBox.Show("CODIGO COPIADO");
        }

        private void BCompilar_Click(object sender, EventArgs e)
        {
            DG_Lexico.Rows.Clear();
            string newtext = "";
            newtext = "";//RIchTxLexico.Text;
            //RIchTxLexico.Text = "";

            string newtexterro = "";
            //newtexterro = richErroresSintac.Text;
            //richErroresSintac.Text = "";


            analiLex();
            // ErroresSintacticos();


        }

        private void pictureBox1_Click_1(object sender, EventArgs e)
        {
            DialogResult result;
            result = MessageBox.Show("Do you want to save file?", "Konfirmasi", MessageBoxButtons.YesNo, MessageBoxIcon.Question);
            if (result == DialogResult.No)
            {
                return;
            }
            if (result == DialogResult.Yes)
            {
                try
                {
                    saveFile();
                    
                }
                catch (Exception err)
                {
                    MessageBox.Show(err.ToString());
                }
            }
        }
        public void saveFile()
        {
            string dirParameter = AppDomain.CurrentDomain.BaseDirectory + @"\ProgramaC.cpp";

        // Save File to .txt
            FileStream fParameter = new FileStream(dirParameter, FileMode.Create, FileAccess.Write);
            StreamWriter m_WriterParameter = new StreamWriter(fParameter);
            m_WriterParameter.BaseStream.Seek(0, SeekOrigin.End);
            m_WriterParameter.Write(CCCode.Text);
            m_WriterParameter.Flush();
            m_WriterParameter.Close();
            MessageBox.Show("Programa Guardado en: " + dirParameter);
        }
    
    private void CodigoMeedCompyTxt_TextChanged(object sender, EventArgs e)
        {

        }
        
    }
}
