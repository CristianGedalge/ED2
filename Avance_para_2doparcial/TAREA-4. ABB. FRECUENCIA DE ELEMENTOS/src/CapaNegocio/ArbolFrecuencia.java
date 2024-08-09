/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author Usuario
 */
public class ArbolFrecuencia {
    public Nodo raiz;

    public ArbolFrecuencia() {
        raiz = null;
    }

    public ArbolFrecuencia(Arbol A1) {
        copiar(A1.raiz);
    }

    private void copiar(Nodo p) {
        if (p == null) {
            return;
        }
        insertar(p.elem, p.frec);
        copiar(p.izq);
        copiar(p.der);
    }

    public void insertar(int elem, int frec) {
        raiz = insertar(raiz, elem, frec);
    }

    private Nodo insertar(Nodo p, int elem, int frec) {
        if (p == null) {
            return new Nodo(elem, frec);
        }
        if (frec < p.frec || (frec == p.frec && elem < p.elem)) {
            p.izq = insertar(p.izq, elem, frec);
        } else {
            p.der = insertar(p.der, elem, frec);
        }
        return p;
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
        A1.generarElem(10, 1, 7);
        ArbolFrecuencia A2 = new ArbolFrecuencia(A1);
        System.out.println("Orden Ascendente por Frecuencia:");
        A2.inordenMenMay();
        System.out.println("Orden Descendente por Frecuencia:");
        A2.inOrdenMayMen();
    }
}
