/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorlexico.SPPS1;

//--------------------------------------- // clase Automata //--------------------------------------- 
public class Automata {

    String _textoIma;
    int _edoAct;

    private char SigCar(int i) {
        if (i == _textoIma.length()) {
            return '';
        } else {
            return _textoIma.charAt(i);
        }
    }

    public Boolean Reconoce(String texto, Lexico oAnaLex, int noAuto) {
        char c;
        _textoIma = texto;
        String lenguaje;
        switch (noAuto) {
            //--------------  Automata  delim--------------       
            case 0:
                _edoAct = 0;
                break;
//--------------  Automata  Id--------------      
            case 1:
                _edoAct = 3;
                break;
//--------------  Automata  OpAsig--------------       
            case 2:
                _edoAct = 6;
                break;
//--------------  Automata  oparit--------------       
            case 3:
                _edoAct = 9;
                break;
//--------------  Automata  num--------------       
            case 4:
                _edoAct = 11;
                break;
//--------------  Automata  sep--------------       
            case 5:
                _edoAct = 16;
                break;
//--------------  Automata  termInst--------------       
            case 6:
                _edoAct = 18;
                break;

        }
        while (oAnaLex.getI() <= _textoIma.length()) {
            switch (_edoAct) {
//--------------  Automata  delim--------------       
                case 0:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = " \n\r\t").indexOf(c) >= 0) {
                        _edoAct = 1;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 1:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = " \n\r\t").indexOf(c) >= 0) {
                        _edoAct = 1;
                    } else if ((lenguaje = "!\"#$%&\'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~€‚ƒ„...†‡ˆ‰Š‹ŒŽ‘’“”•–— ̃™š›œžŸ ¡¢£¤¥¦§ ̈©ª«¬-® ̄°±²³ ́μ¶· ̧¹º»¼½¾¿\f").indexOf(c) >= 0) {
                        _edoAct = 2;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 2:
                    oAnaLex.setI(oAnaLex.getI() - 1);
                    return true;
//--------------  Automata  Id--------------      
                case 3:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").indexOf(c) >= 0) {
                        _edoAct = 4;
                    } else if ((lenguaje = "_").indexOf(c) >= 0) {
                        _edoAct = 4;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 4:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz").indexOf(c) >= 0) {
                        _edoAct = 4;
                    } else if ((lenguaje = "_").indexOf(c) >= 0) {
                        _edoAct = 4;
                    } else if ((lenguaje = "0123456789").indexOf(c) >= 0) {
                        _edoAct = 4;
                    } else if ((lenguaje = " !\"#$%&\'()*+,-./:;<=>?@[\\]^`{|}~€‚ƒ„...†‡ˆ‰Š‹ŒŽ‘’“”•–— ̃™š›œžŸ ¡¢£¤¥¦§ ̈©ª«¬-® ̄°±²³ ́μ¶· ̧¹º»¼½¾¿\n\t\r\f").indexOf(c) >= 0) {
                        _edoAct = 5;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 5:
                    oAnaLex.setI(oAnaLex.getI() - 1);
                    return true;
//--------------  Automata  OpAsig--------------       
                case 6:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "=").indexOf(c) >= 0) {
                        _edoAct = 7;
                    } else if ((lenguaje = "+").indexOf(c) >= 0) {
                        _edoAct = 8;
                    } else if ((lenguaje = "-").indexOf(c) >= 0) {
                        _edoAct = 8;
                    } else if ((lenguaje = "*").indexOf(c) >= 0) {
                        _edoAct = 8;
                    } else if ((lenguaje = "/").indexOf(c) >= 0) {
                        _edoAct = 8;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());

                        return false;
                    }
                    break;
                case 7:
                    return true;
                case 8:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "=").indexOf(c) >= 0) {
                        _edoAct = 7;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;

                    }
                    break;
//--------------  Automata  oparit--------------       
                case 9:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "+").indexOf(c) >= 0) {
                        _edoAct = 10;
                    } else if ((lenguaje = "-").indexOf(c) >= 0) {
                        _edoAct = 10;
                    } else if ((lenguaje = "*").indexOf(c) >= 0) {
                        _edoAct = 10;
                    } else if ((lenguaje = "/").indexOf(c) >= 0) {
                        _edoAct = 10;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 10:
                    return true;
//--------------  Automata  num--------------       
                case 11:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "0123456789").indexOf(c) >= 0) {
                        _edoAct = 12;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 12:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "0123456789").indexOf(c) >= 0) {
                        _edoAct = 12;
                    } else if ((lenguaje = " !\"#$%&\'()*+,-/:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~€‚ƒ„...†‡ˆ‰Š‹ŒŽ‘’“”•–— ̃™š›œžŸ ¡¢£¤¥¦§ ̈©ª«¬-® ̄°±²³ ́μ¶· ̧¹º»¼½¾¿\n\t\r\f").indexOf(c) >= 0) {
                        _edoAct = 13;
                    } else if ((lenguaje = ".").indexOf(c) >= 0) {
                        _edoAct = 14;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 13:
                    oAnaLex.setI(oAnaLex.getI() - 1);
                    return true;
                case 14:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "0123456789").indexOf(c) >= 0) {
                        _edoAct = 15;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 15:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "0123456789").indexOf(c) >= 0) {
                        _edoAct = 15;
                    } else if ((lenguaje = " !\"#$%&\'()*+,-/:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~€‚ƒ„...†‡ˆ‰Š‹ŒŽ‘’“”•–— ̃™š›œžŸ ¡¢£¤¥¦§ ̈©ª«¬-® ̄°±²³ ́μ¶· ̧¹º»¼½¾¿\n\t\r\f").indexOf(c) >= 0) {
                        _edoAct = 13;
                    } else if ((lenguaje = ".").indexOf(c) >= 0) {
                        _edoAct = 13;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
//--------------  Automata  sep--------------       
                case 16:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = "(").indexOf(c) >= 0) {
                        _edoAct = 17;
                    } else if ((lenguaje = ")").indexOf(c) >= 0) {
                        _edoAct = 17;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 17:
                    return true;
//--------------  Automata  termInst--------------       
                case 18:
                    c = SigCar(oAnaLex.getI());
                    oAnaLex.setI(oAnaLex.getI() + 1);
                    if ((lenguaje = ";").indexOf(c) >= 0) {
                        _edoAct = 19;
                    } else {
                        oAnaLex.setI(oAnaLex.getIniToken());
                        return false;
                    }
                    break;
                case 19:
                    return true;
            }
        }
        switch (_edoAct) {
            case 2:
// Autómata  delim             
            case 5:
// Autómata  Id             
            case 13:
// Autómata  num                            
                oAnaLex.setI(oAnaLex.getI() - 1);
                return true;
        }
        return false;
    }
} // fin de la clase Automata
