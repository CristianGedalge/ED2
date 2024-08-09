/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import java.util.LinkedList;

/**
 *
 * @author CRISTIAN
 */
public class ListaArbol {
    LinkedList<Arbol> L;
    public ListaArbol(){
        this.L=new LinkedList<>();
    }
    public ListaArbol(LinkedList<Arbol> L){
        this.L=L;
    }
    
    public void mostrarinOrden(){
        for (Arbol arbol : L) {
            arbol.inOrdern();
        }
    }
    
    public void sumaP(int pos ){
       if(pos<L.size())
            System.out.println(L.get(pos).sumaPares());
    }
    public void cantNodos(){
        int i=1;
        for (Arbol arbol : L) {
            System.out.println("Arbol "+i+": "+arbol.cantNodos());
            i++;
        }
    }
    
    public void NodosTer(){
        int i=1;
        for (Arbol arbol : L) {
            System.out.println("Arbol "+i+": "+arbol.cantNodoTerminales());
            i++;
        }
    }
    public void altura(){
        int i=1;
        for (Arbol arbol : L) {
            System.out.println("Arbol "+i+": "+arbol.altura());
            i++;
        }
    }
    public void elimP(){
        int i=1;
        for (Arbol arbol : L) {
            arbol.elimP();
        }
    }
    public static void main(String[] args) {

        LinkedList<Arbol> LA=new LinkedList<>();
        Arbol A1=new Arbol();
        A1.insertar(66);
        A1.insertar(23);
        A1.insertar(97);
        A1.insertar(26);
        A1.insertar(10);
        A1.insertar(77);
        A1.insertar(99);
        
        
        Arbol A2 = new Arbol();
        A2.insertar(10);
        A2.insertar(3);
        A2.insertar(18);
        A2.insertar(14);
        A2.insertar(16);
        LA.add(A1);
        LA.add(A2);
                ListaArbol L=new ListaArbol(LA);
        L.elimP();
        L.mostrarinOrden();
                

    }
}
