/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author CGGC
 */
public class ArbolFrecuenci {

    Nodo raiz;

    public ArbolFrecuenci() {
        this.raiz = null;
    }

    public ArbolFrecuenci(Arbol A1) {
        copiar(A1.raiz);
    }
    
    public Nodo copiar(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo q = new Nodo(p.elem, p.frec);
        p.izq = copiar(p.izq);
        p.der = copiar(p.der);
        return q;
    }
    
    
    public void inordenMenMay() {
        inordenMenMay(raiz);
    }

    private void inordenMenMay(Nodo p) {
        if (p == null) {
            return;
        }
        inordenMenMay(p.izq);
        System.out.println(p.elem + " | " + p.frec);
        inordenMenMay(p.der);
    }

    public void inOrdenMayMen() {
        inOrdenMayMen(raiz);
    }

    private void inOrdenMayMen(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenMayMen(p.der);
        System.out.println(p.elem + " | " + p.frec);
        inOrdenMayMen(p.izq);
    }

    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.generarElem(10, 1, 5);
    }
}
