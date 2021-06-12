package analizadorlexico.SPPS1;


import analizadorlexico.SPPS1.Automata;


//--------------------------------------- // clase Lexico //--------------------------------------- 
public class Lexico  {    
    final int TOKREC = 7;
   final int MAXTOKENS = 500;    
   private String[] _lexemas;    
   private String[] _tokens;    
   private String _lexema;    
   private int _noTokens;    
   private int _i;    
   private int _iniToken;    
   private Automata oAFD;    
   public Lexico() 
           // constructor por defecto    
   {      
       _lexemas = new String[MAXTOKENS];    
       _tokens = new String[MAXTOKENS];
       oAFD = new Automata();     
       _i = 0;      
       _iniToken = 0;      
       _noTokens = 0;    
   }    
   public void Inicia()     
   {      
       _i = 0;
       _iniToken = 0;      
       _noTokens = 0;     
       _lexemas = new String[MAXTOKENS];      
       _tokens = new String[MAXTOKENS];    
   }    
   public void Analiza(String texto)     
   {      
       Boolean recAuto;
       int noAuto;      
       while (_i < texto.length())       
       {        
           recAuto=false;
           noAuto=0;        
           for(;noAuto<TOKREC&&!recAuto;)          
               if(oAFD.Reconoce(texto,this,noAuto))            
                   recAuto=true;          
               else            
                   noAuto++;        
           if (recAuto)        
           {          
               _lexema = texto.substring(_iniToken, _i);
               switch (noAuto)          
               {                 
                            //--------------  Automata  delim--------------           
                   case 0 : _tokens[_noTokens] = "delim";                         
                   break;           
                   //--------------  Automata  Id--------------           
                   case 1 : _tokens[_noTokens] = "Id";                         
                   break;            
//--------------  Automata  OpAsig--------------           
                   case 2 : _tokens[_noTokens] = "OpAsig";                         
                   break;            
//--------------  Automata  oparit--------------           
                   case 3 : _tokens[_noTokens] = "oparit";
                   break;            
//--------------  Automata  num--------------           
                   case 4 : _tokens[_noTokens] = "num";                         
                   break;            
//--------------  Automata  sep--------------           
                   case 5 : _tokens[_noTokens] = "sep";                         
                   break;            
//--------------  Automata  termInst--------------           
                   case 6 : _tokens[_noTokens] = "termInst";                        
                   break;          
               }          
               _lexemas[_noTokens++] = _lexema;        
           }        
           else
               _i++;
           _iniToken = _i; 
       }    
   } 
// fin del método Analiza()    
   public int getI()    
   {        
       return _i;    
   }    
   public void setI(int valor)    
   {        
       _i=valor;    
   }    
   public int getIniToken()    {
       return _iniToken;    
   }    
   public String[] Tokens()
   {        
       return _tokens;    
   }    
   public String[] Lexemas()
   {        
       return _lexemas;   
   }  
}  // fin de la clase Lexico  //---------------------------