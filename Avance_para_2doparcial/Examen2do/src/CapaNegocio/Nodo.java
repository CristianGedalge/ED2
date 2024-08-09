package CapaNegocio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class Nodo {

    public Nodo izq;
    public Nodo der;
    public int elem;

    public Nodo(int elem) {
        this.izq = this.der = null;
        this.elem = elem;
    }

}
