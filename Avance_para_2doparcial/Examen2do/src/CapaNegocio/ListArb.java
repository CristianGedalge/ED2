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
public class ListArb {
    LinkedList<Arbol> L;
    public ListArb(int tamaño){
        L=new LinkedList<>();
        for(int i=1;i<=tamaño;i++){
            this.L.add(new Arbol());
        }
    }
    
    public void meter(int pos,int ele){//>=0}
        if(pos<L.size())
         L.get(pos).insertar(ele);
    }
    
    public void MostrarinOrden(){
        for (Arbol arbol : L) {
            arbol.inOrdern();
        }
    }
    public static void main(String[] args) {
        ListArb L=new ListArb(2);
        L.meter(0, 40);
        L.meter(0, 21);
        L.meter(0, 12);
        L.meter(0, 67);
        L.meter(0, 50);
        L.meter(0, 71);
        
        
        L.meter(1, 15);
        L.meter(1, 10);
        L.meter(1, 16);
        L.meter(1, 18);
        L.meter(1, 25);
        L.meter(1, 4);
        L.MostrarinOrden();

       
    }
}