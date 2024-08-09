/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author Usuario
 */
public class Arbol {

    public Nodo raiz;

    public Arbol() {
        raiz = null;
    }

    public Arbol(Arbol A1) {
        raiz = copiar(A1.raiz);
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

    public void generarElem(int n, int a, int b) {
        for (int i = n; i > 0; i--) {
            int x = (int) (Math.random() * (b - a)) + a;
            //System.err.println(x);
            insertar(x);
        }
    }

    public void insertar(int x) {
        raiz = insertar(raiz, x);
    }

    private Nodo insertar(Nodo p, int x) {
        if (p == null) {
            return new Nodo(x);

        }
        if (p.elem == x) {
            p.frec++;
        } else {
            if (x < p.elem) {
                p.izq = insertar(p.izq, x);
            } else {
                p.der = insertar(p.der, x);
            }
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
    
    public void inOrdenMayMen()
    {
        inOrdenMayMen(this.raiz);
    }
    private void inOrdenMayMen(Nodo p)
    {
        if(p==null)return;
        inOrdenMayMen(p.der);
            System.out.println(p.elem + " | " + p.frec);
        inOrdenMayMen(p.izq);
            
    }
    
    
    
    
    
    public static void main(String[] args) {
        Arbol A1=new Arbol();
        A1.generarElem(15, 1, 7);
        System.out.println("--------------------------------");
        A1.inOrdenMayMen();
    }

}
