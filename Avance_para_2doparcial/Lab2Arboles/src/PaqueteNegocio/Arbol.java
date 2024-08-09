/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteNegocio;

/**
 *
 * @author Estudiante_2
 */
public class Arbol {

    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int ele) {
        this.raiz = insertar(this.raiz, ele);
    }

    private Nodo insertar(Nodo p, int ele) {
        if (p == null) {
            p = new Nodo(ele);
            return p;
        } else {
            if (ele < p.ele) {
                p.izq = insertar(p.izq, ele);
            } else {
                p.der = insertar(p.der, ele);
            }
        }
        return p;
    }

    public void inOrdenOrdAsc() {
        inOrdenOrdAsc(this.raiz);
    }

    private void inOrdenOrdAsc(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenOrdAsc(p.izq);
        System.out.println(p.ele);
        inOrdenOrdAsc(p.der);

    }

    
     public void inOrdenOrdDesc() {
        inOrdenOrdDesc(this.raiz);
    }

    private void inOrdenOrdDesc(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenOrdDesc(p.der);
        System.out.println(p.ele);
        inOrdenOrdDesc(p.izq);

    }
    public static void main(String[] arg) {
        Arbol A1 = new Arbol();
        A1.insertar(14);
        A1.insertar(15);
        A1.insertar(13);
        A1.insertar(4);
        A1.insertar(5);

        A1.inOrdenOrdAsc();
    }
}
