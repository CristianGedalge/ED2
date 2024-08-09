/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import java.util.LinkedList;

/**
 *
 * @author Usuario
 */
public class Nodo {
     public String elem;  
    public int frec;  
    
    public LinkedList<Integer> linea;
    public LinkedList<Integer> pagina;
    public Nodo izq;  
    public Nodo der;  
  
    public Nodo(String elem) {  
        linea=new LinkedList<>();
        pagina=new LinkedList<>();
        this.elem = elem;  
        this.frec = 1;  
        this.izq = this.der = null;  
    }  
  
    public Nodo(String elem, int frec, LinkedList<Integer> lin, LinkedList<Integer>pagina) {  
        
        linea=new LinkedList<>(lin);
        pagina=new LinkedList<>(pagina);
        this.elem = elem;  
        this.frec = frec;  
        this.izq = this.der = null;  
    }  
}
