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
public class Lista {

    public Nodo prim;
    public int cantElem;
    public Nodo ult;

    public Lista() {
        this.prim = this.ult = null;
        this.cantElem = 0;
    }

//1.      L1.InsertarIesimo(x, i) : Método que inserta el elemento x, en la la iésima posición de la Lista L1.
    @Override
    public String toString() {
        String s = "[";
        Nodo p = this.prim;
        while (p != null) {
            s = s + p.elem;
            if (p.prox != null) {
                s = s + " ";
            }
            p = p.prox;
        }
        return s + "]";
    }
//2.      L1.insertarPrim(x) : Método que inserta el elemento x, al inicio de la lista L1.

    public void insertarPrim(int x) {
        if (vacio()) {
            prim = ult = new Nodo(x, null);
        } else {
            prim = new Nodo(x, prim);
        }
        this.cantElem++;
    }

//3.      L1.insertarUlt(x) : Método que inserta el elemento x, al inicio de la lista L1.
    public void insertarUlt(int x) {
        if (vacio()) {
            prim = ult = new Nodo(x, null);
        } else {
            ult = ult.prox = new Nodo(x, null);
        }
        this.cantElem++;
    }

    public boolean vacio() {
        return this.cantElem == 0;
    }
//4.      L1.InsertarIesimo(x, i) : Método que inserta el elemento x, en la la iésima posición de la Lista L1.

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (p != null && k < i) {
            ap = p;
            p = p.prox;
            k = k + 1;
        }
        insertarNodo(x, ap, p);

    }

    public void insertarNodo(int x, Nodo ap, Nodo p) {
        if (ap == null) {
            insertarPrim(x);
        } else if (p == null) {
            insertarUlt(x);
        } else {
            ap.prox = new Nodo(x, p);
            this.cantElem++;
        }
    }


//5.      L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.    

    public boolean iguales() {
        int ele = this.prim.elem;
        while (this.prim != null) {
            if (ele != this.prim.elem) {
                return false;
            }
            prim = prim.prox;
        }
        return true;
    }

//6.      L1.menorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int menorElem() {
        int ele = this.prim.elem;
        while (this.prim != null) {
            if (ele > this.prim.elem) {
                ele = this.prim.elem;
            }
            prim = prim.prox;
        }
        return ele;

    }

//7.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    public void seEncuentra(int x, int y) {

        while (this.prim != null) {
            if (x == this.prim.elem) {
                this.prim.elem = y;
            }
            prim = prim.prox;
        }
    }
//8.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.

    public boolean seEncuentra(int x) {

        while (this.prim != null) {
            if (x == this.prim.elem) {
                return true;
            }
            prim = prim.prox;
        }
        return false;
    }
//9.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.

    public int frecuencia(int x) {
        int contador = 0;
        while (this.prim != null) {
            if (x == this.prim.elem) {
                contador++;
            }
            prim = prim.prox;
        }
        return contador;
    }
//10.   L1.insertarUlt(L2) : Método que inserta los elementos de la Lista L2, al final de la Lista L1.

    public void insertarUlt(Lista L2) {
        while (L2!= null) {
            insertarUlt(L2.prim.elem);
            L2.prim = L2.prim.prox;

        }
    }
//11.   L1.insertarLugar(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.

    public void insertarLugar(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x > p.elem) {
            ap = p;
            p = p.prox;
        }
        insertarNodo(x, ap, p);
    }
    public static void main(String[] args) {
        Lista L1 = new Lista();
//        L1.insertarIesimo(3, 0);
//        L1.insertarIesimo(3, 1);
        L1.insertarIesimo(1, 2);
//        L1.insertarUlt(17);
//        L1.insertarUlt(20);
        System.out.println(L1.toString());

        Lista L2 = new Lista();
        L2.insertarIesimo(3, 0);
        L2.insertarIesimo(3, 1);
        L2.insertarIesimo(1, 2);
        System.out.println(L2.toString());
        L1.insertarUlt(L2);
        System.out.println(L1.toString());
    }
}
