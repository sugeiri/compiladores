using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AnalizadorLexico
{
    class automata
    {
        string _textoIma;
        int _edoAct;
        char SigCar(ref int i)
        {
            if(i==_textoIma.Length)
            {
                i++;
                return ' ';
            }
            else
            {
                return _textoIma[i++];
            }
        }
        public bool Reconoce(string texto, int intToken, ref int i, int noAuto)
        {
            char c;
            _textoIma = texto;
            string lenguaje;
            switch (noAuto)
            {
                case 0:  //Automata Delim
                    _edoAct = 0;
                    break;

                case 1:  //Automata id
                    _edoAct = 3;
                    break;
                case 2:  //Automata num
                    _edoAct = 6;
                    break;
                case 3:  //Automata otros
                    _edoAct = 9;
                    break;
                case 4:  //Automata cad
                    _edoAct = 11;
                    break;

            }
            while (i <= _textoIma.Length)
            {
                switch (_edoAct)
                {
                    case 0:  //Automata Delim
                        c = SigCar(ref i);
                        if ((lenguaje = " \n\r\t").IndexOf(c) >= 0)
                            _edoAct = 1;
                        else
                        {
                            if ((lenguaje = "!\"#$%&\'()*+,-./0123456789:;<=>?" +
                                "@ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
                                "[\\]^_'abcdefghijklmnopqrstuvwxyz" +
                                "{|}~,f,,..." +
                                "" +
                                "").IndexOf(c) >= 0)
                        }
                        break;

                    case 1:  //Automata id
                        _edoAct = 3;
                        break;
                    case 2:  //Automata num
                        _edoAct = 6;
                        break;
                    case 3:  //Automata otros
                        _edoAct = 9;
                        break;
                    case 4:  //Automata cad
                        _edoAct = 11;
                        break;

                }
            }
        }
    }
}
