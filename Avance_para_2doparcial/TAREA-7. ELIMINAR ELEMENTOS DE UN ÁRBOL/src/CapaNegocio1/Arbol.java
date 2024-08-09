/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio1;

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

    public void eliminar(int x) {
        raiz = eliminar(x, raiz);
    }

    public Nodo eliminar(int x, Nodo p) {
        if (p == null) {
            return null;
        }

        if (x == p.ele) {
            return eliminarNodo(p);
        }
        if (x < p.ele) {
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

        int y = q.ele;
        eliminar(y);
        p.ele = y;
        return p;
    }

    public void eliminar2(int x) {
        raiz = eliminar2(x, raiz);
    }

    public Nodo eliminar2(int x, Nodo p) {
        if (p == null) {
            return null;
        }

        if (x == p.ele) {
            return eliminarNodo2(p);
        }
        if (x < p.ele) {
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

        int y = q.ele;
        eliminar(y);
        p.ele = y;
        return p;
    }

//A1.eliminarSup(x) : Método que elimina el elemento x, del árbol A1. Si el elemento a eliminar es un nodo raíz, buscar el elemento inmediato Superior, para eliminar.
    public void eliminarSup(int x) {
        eliminar2(x);
    }
//A1.eliminarInf(x): Método que elimina el elemento x, del árbol A1. Si el elemento a eliminar es un nodo raíz, buscar el elemento inmediato Inferior, para eliminar

    public void eliminarInf(int x) {
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
//A1.eliminarPares() : Método que elimina los elementos pares del árbol A1.

    public void eliminarPares() {
        raiz = eliminarPares(raiz);
    }

    public Nodo eliminarPares(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarPares(p.izq);
        p.der = eliminarPares(p.der);
        if (p.ele % 2 == 0) {
            return eliminarNodo(p);
        }
        return p;

    }
//A1.eliminar(L1) : Método que elimina los elementos de la lista L1 que se encuentran en el árbol A1.

    public void eliminar(List<Integer> L1) {
        for (Integer elem : L1) {
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
        for (int num : Arr) {
            insertar(num);
        }
    }

    List<Integer> Arr = new ArrayList<Integer>();

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

//Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
// 1.metodo que elimina todo el nodo restante a partir de n;
    public void eliminarTodoApartirden(int n) {
        raiz = eliminarTodo(this.raiz, n);
    }

    private Nodo eliminarTodo(Nodo p, int n) {
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

// 2.metodo que elimina los elemntos primos;
    public void eliminarPrimos() {
        raiz = eliminarPrimos(raiz);
    }

    public Nodo eliminarPrimos(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarPrimos(p.izq);
        p.der = eliminarPrimos(p.der);
        if (isprimo(p.ele)) {
            return eliminarNodo(p);
        }
        return p;
    }

    public boolean isprimo(int n) {
        int cont = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                cont++;
            }
        }
        return cont == 2;
    }
// 3. metodo que elimina solosimpares

    public void eliminarImpares() {
        raiz = eliminarImpares(raiz);
    }

    public Nodo eliminarImpares(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarImpares(p.izq);
        p.der = eliminarImpares(p.der);
        if (p.ele % 2 != 0) {
            return eliminarNodo(p);
        }
        return p;
    }

//4. metodo que elimina los numeros que pertenecen a la frec fibonacci
    public void eliminarfibo() {
        raiz = eliminarfibo(raiz);
    }

    public Nodo eliminarfibo(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = eliminarfibo(p.izq);
        p.der = eliminarfibo(p.der);
        if (isfibo(p.ele)) {
            return eliminarNodo(p);
        }
        return p;
    }

    public boolean isfibo(int n) {
        int ant = 0;
        int post = 1;
        int fibo = 0;
        while (fibo <= n) {
            fibo = ant + post;
            ant = post;
            post = fibo;
            if (fibo == n) {
                return true;
            }
        }
        return false;
    }

//5. contarNodos
    public int contNodos() {
        return contNodos(raiz);
    }

    private int contNodos(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + contNodos(p.izq) + contNodos(p.der);
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

    public static void main(String[] arg) {
        Arbol A1 = new Arbol();
        A1.insertar(80);
        A1.insertar(60);
        A1.insertar(90);
        A1.insertar(85);
        A1.insertar(95);
        A1.insertar(20);
        A1.insertar(105);
        A1.mostrarNivel();
        //System.out.println(A1.cantNodoxNivel(4));
    }
}
