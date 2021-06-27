/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package analizadorsemantico;


public class Pila {
    private Nodo UltimoValorIngresado;
    
    public Pila(){
        UltimoValorIngresado = null;
    }
    
    //Método para insertar dentro de la pila
    public void Insertar(char valor){
        Nodo nuevo_nodo = new Nodo();
        nuevo_nodo.informacion = valor;
        
        if (UltimoValorIngresado == null) {
            
            nuevo_nodo.siguiente = null;
            UltimoValorIngresado = nuevo_nodo;
            
        } else {
            
            nuevo_nodo.siguiente = UltimoValorIngresado;
            UltimoValorIngresado = nuevo_nodo;
        }
    }
    
    //Método para extraer de la pila
    public char extraer(){
        if (UltimoValorIngresado != null) {
            
            char informacion = UltimoValorIngresado.informacion;
            UltimoValorIngresado = UltimoValorIngresado.siguiente;
            return informacion;
            
        } else {
            return Character.MAX_VALUE;
        }
    }
    
    //Método para saber si la pila esta vacia
    public boolean PilaVacia(){
        return UltimoValorIngresado == null;
    }
}
