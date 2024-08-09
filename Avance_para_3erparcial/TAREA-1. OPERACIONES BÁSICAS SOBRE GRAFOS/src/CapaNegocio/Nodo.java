package CapaNegocio;


import CapaNegocio.Arco;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Nodo {
    public String name;
    public Nodo prox;
    public Arco prim;
    public Arco ult;
    public int cantArcos;
    public Nodo (String name){
        this.name=name;
        prox=null;
        prim=ult=null;
        cantArcos=0;
    }
    public boolean vacia(){
        return cantArcos==0;
    }
    public void insertarUlt(Nodo p,int valor){
        if(vacia()){
            prim=ult=new Arco(p,valor);
        }else{
            ult=ult.prox=new Arco(p,valor);
        }
        cantArcos++;
    }
    
    public boolean seEncuentraArco(String namee)
    {
        Arco arc=prim;
        while(arc!=null)
        {
            if(arc.pDest.name==namee)
            {
                return true;
            }
            arc=arc.prox;
        }return false;
    }
}
