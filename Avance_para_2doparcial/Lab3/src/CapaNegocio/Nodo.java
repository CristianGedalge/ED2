/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author Estudiante_2
 */
public class Nodo {
    Nodo izq;
    Nodo der;
    int elem;
    public Nodo(int ele)
    {
        this.elem=ele;
        this.izq=this.der=null;
    }
}
