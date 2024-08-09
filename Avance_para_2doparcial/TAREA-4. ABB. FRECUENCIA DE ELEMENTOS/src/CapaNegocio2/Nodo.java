/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio2;

import CapaNegocio.*;

/**
 *
 * @author Usuario
 */
public class Nodo {
    public String cad;
    public int frec;
    public Nodo izq;
    public Nodo der;
    public Nodo(String cad )
    {
        this.cad=cad;
        this.frec=1;
        this.izq=this.der=null;
    }
    public Nodo(String cad,int frec){
        this.cad=cad;
        this.frec=frec;
        this.izq=this.der=null;
    }
    
}
