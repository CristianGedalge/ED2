/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author CGGC
 */
public class Arbol {

    public Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(String ele) {
        this.raiz = insertar(this.raiz, ele);
    }

    private Nodo insertar(Nodo p, String ele) {
        if (p == null) {
            p = new Nodo(ele);
            return p;
        } else {
            if (ele.charAt(0) < p.ele.charAt(0)) {
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

    public void eliminar(String x) {
        raiz = eliminar(x, raiz);
    }

    private Nodo eliminar(String x, Nodo p) {
        if (p == null) {
            return null;
        }

        if (x == p.ele) {
            return eliminarNodo(p);
        }
        if (x.charAt(0) < p.ele.charAt(0)) {
            p.izq = eliminar(x, p.izq);
        } else {
            p.der = eliminar(x, p.der);
        }
        return p;

    }

    public Nodo eliminarNodo(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        Nodo q = p.izq;
        while (q.der != null) {
            q = q.der;
        }

        String y = q.ele;
        eliminar(y);
        p.ele = y;
        return p;
    }

    public void eliminar2(String x) {
        raiz = eliminar2(x, raiz);
    }

    public Nodo eliminar2(String x, Nodo p) {
        if (p == null) {
            return null;
        }

        if (x == p.ele) {
            return eliminarNodo2(p);
        }
        if (x.charAt(0) < p.ele.charAt(0)) {
            p.izq = eliminar2(x, p.izq);
        } else {
            p.der = eliminar2(x, p.der);
        }
        return p;

    }

    public Nodo eliminarNodo2(Nodo p) {
        if (p.izq == null && p.der == null) {
            return null;
        }
        if (p.izq != null && p.der == null) {
            return p.izq;
        }
        if (p.izq == null && p.der != null) {
            return p.der;
        }
        Nodo q = p.der;
        while (q.izq != null) {
            q = q.izq;
        }

        String y = q.ele;
        eliminar2(y);
        p.ele = y;
        return p;
    }

//A1.eliminarSup(x) : Método que elimina el elemento x, del árbol A1. Si el elemento a eliminar es un nodo raíz, buscar el elemento inmediato Superior, para eliminar.
    public void eliminarSup(String x) {
        eliminar2(x);
    }
//A1.eliminarInf(x): Método que elimina el elemento x, del árbol A1. Si el elemento a eliminar es un nodo raíz, buscar el elemento inmediato Inferior, para eliminar

    public void eliminarInf(String x) {
        eliminar(x);
    }

//A1.eliminarHojas() : Método que elimina los nodos hoja de árbol A1.
    public void eliminarHojas() {
        eliminarHojas(raiz);
    }

    public Nodo eliminarHojas(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            return null;
        }
        p.izq = eliminarHojas(p.izq);
        p.der = eliminarHojas(p.der);
        return p;
    }

//A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.
    public void eliminar(List<String> L1) {
        for (String elem : L1) {
            raiz = eliminar(elem, raiz);
        }
    }

//A1.eliminarMenor(): Método que elimina el elemento menor del árbol A1.
    public void eliminarMenor() {
        if (raiz != null) {
            raiz = eliminarMenor(raiz);
        }
    }

    private Nodo eliminarMenor(Nodo p) {
        if (p.izq == null) {
            return p.der;
        }
        p.izq = eliminarMenor(p.izq);
        return p;
    }
//A1.eliminarMayor(): Método que elimina el elemento mayor del árbol A1.

    public void eliminarMayor() {
        if (raiz != null) {
            raiz = eliminarMayor(raiz);
        }
    }

    private Nodo eliminarMayor(Nodo p) {
        if (p.der == null) {
            return p.izq;
        }
        p.der = eliminarMayor(p.der);
        return p;
    }

//A1.eliminarNivel( n ) : Método que elimina los nodos del árbol A1 del nivel n.
    public void eliminarNivel(int n) {
        this.raiz = eliminarNivel(raiz, n, 1);
    }

    private Nodo eliminarNivel(Nodo p, int n, int nivel) {
        if (p == null) {
            return null;
        }
        if (nivel == n) {
            return eliminarNodo(p);
        }
        p.izq = eliminarNivel(p.izq, n, nivel + 1);
        p.der = eliminarNivel(p.der, n, nivel + 1);
        return p;
    }
//A1.eliminarRaices() : Método que elimina los nodos raíces del árbol A1.

    public void eliminarRaices() {
        raiz = eliminarRaices(this.raiz);
        raiz = null;
        for (String palabra : Arr) {
            insertar(palabra);
        }
    }

    List<String> Arr = new ArrayList<String>();

    private Nodo eliminarRaices(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            Arr.add(p.ele);
            return null;
        }
        eliminarRaices(p.izq);
        eliminarRaices(p.der);
        return p;
    }

    // 1.metodo que elimina todo el nodo restante a partir de n;
    public void eliminarTodoApartirden(String n) {
        raiz = eliminarTodo(this.raiz, n);
    }

    private Nodo eliminarTodo(Nodo p, String n) {
        if (p == null) {
            return null;
        }
        if (p.ele == n) {
            return null;
        }
        p.izq = eliminarTodo(p.izq, n);
        p.der = eliminarTodo(p.der, n);
        return p;

    }

    // metodo que cuenta nodos
    public int contNodos() {
        return contNodos(raiz);
    }

    private int contNodos(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + contNodos(p.izq) + contNodos(p.der);
    }

    //altura de un arbol
    public int altura() {
        return altura(this.raiz);
    }

    private int altura(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (altura(p.izq) > altura(p.der)) {
            return 1 + altura(p.izq);
        }
        return 1 + altura(p.der);
    }

    // cant nodos en un nivel n
    public int cantNodoxNivel(int nivel) {
        return cantNodoxNivel(this.raiz, nivel, 0);
    }

    private int cantNodoxNivel(Nodo p, int nivel, int inicio) {
        if (p == null) {
            return 0;
        }
        inicio++;
        if (inicio == nivel) {
            return 1;
        }
        return cantNodoxNivel(p.izq, nivel, inicio) + cantNodoxNivel(p.der, nivel, inicio);
    }

    //muestra los nodos por niveles 
//        1
//       / \
//      2   3  res=1 2 3
    public void mostrarNivel() {
        if (raiz == null) {
            System.out.println("El arbol esta vacio");
            return;
        }
        LinkedList<Nodo> colaLista = new LinkedList<>();
        colaLista.add(raiz);
        while (!colaLista.isEmpty()) {
            Nodo nodoAux = colaLista.removeFirst();//elimina el primer elemento y lo devuelve
            System.out.print(nodoAux.ele + " ");
            if (nodoAux.izq != null) {
                colaLista.add(nodoAux.izq);
            }

            if (nodoAux.der != null) {
                colaLista.add(nodoAux.der);
            }
        }
    }

    //preOrden
    public void preOrden() {
        preOrden(this.raiz);
    }

    private void preOrden(Nodo p) {
        if (p == null) {
            return;
        }
        System.out.println(p.ele);
        preOrden(p.izq);
        preOrden(p.der);

    }

    //postOrden
    public void postOrden() {
        postOrden(this.raiz);
    }

    private void postOrden(Nodo p) {
        if (p == null) {
            return;
        }
        postOrden(p.izq);
        postOrden(p.der);
        System.out.print(p.ele);
    }
}
