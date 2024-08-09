/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author CRISTIAN
 */
public class Nodo {
   Arco prim,ult;
   Nodo prox;
   String name;
   int CA;
   public Nodo(String name){
       prim=ult=null;
       CA=0;
       this.name=name;
       prox=null;
   }
   
   public void insertArc(Nodo pD,int val){
               if(CA==0)
            prim=ult= new Arco(pD,val);
        else
            ult=ult.prox=new Arco(pD,val);
        CA++;
   }
}
