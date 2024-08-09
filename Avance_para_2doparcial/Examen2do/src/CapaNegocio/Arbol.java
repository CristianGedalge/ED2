package CapaNegocio;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class Arbol {

    Nodo raiz;

    public Arbol() {
        this.raiz = null;
    }

    public void insertar(int ele) {
        this.raiz = insertarR(this.raiz, ele);
    }

    private Nodo insertarR(Nodo p, int ele) {
        if (p == null) {
            return new Nodo(ele);
        }
        if (ele < p.elem) {
            p.izq = insertarR(p.izq, ele);
        } else {
            p.der = insertarR(p.der, ele);
        }
        return p;
    }

    //1
    public int cantNodos() {
        return cantNodosR(this.raiz);
    }

    private int cantNodosR(Nodo p) {
        if (p == null) {
            return 0;
        }
        return 1 + cantNodosR(p.izq) + cantNodosR(p.der);
    }

    //2
    public int sumaPares() {
        return sumaParesR(this.raiz);
    }

    private int sumaParesR(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (p.elem % 2 == 0) {
            return p.elem + sumaParesR(p.izq) + sumaParesR(p.der);
        }
        return sumaParesR(p.izq) + sumaParesR(p.der);
    }

    //3
    public int cantNodoTerminales() {
        return cantNodoTerminalesR(raiz);
    }

    private int cantNodoTerminalesR(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (p.izq == null && p.der == null) {
            return 1;
        }
        return cantNodoTerminalesR(p.izq) + cantNodoTerminalesR(p.der);
    }

    //4
    public int altura() {
        return alturaR(raiz);
    }

    private int alturaR(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (alturaR(p.izq) > alturaR(p.der)) {
            return 1 + alturaR(p.izq);
        } else {
            return 1 + alturaR(p.der);
        }
    }

    //5
    public void inOrdern() {
        inOrdenR(this.raiz);
        System.out.println("");
    }

    private void inOrdenR(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenR(p.izq);
        System.out.print(p.elem+",");
        inOrdenR(p.der);

    }
    //

    public void mostrarMenorelem() {
        mostrarmenorelem(this.raiz);
    }

    private void mostrarmenorelem(Nodo p) {
        if (p == null) {
            return;
        }
        if (p.izq == null && p.der == null) {
            System.out.println(p.elem);
        }
        mostrarmenorelem(p.izq);

    }

    public void mostrarMayorelem() {
        mostrarMayorelem(this.raiz);
    }

    private void mostrarMayorelem(Nodo p) {
        if (p == null) {
            return;
        }
        if (p.izq == null && p.der == null) {
            System.out.println(p.elem);
        }
        mostrarMayorelem(p.der);

    }

    public boolean existe(int x) {
        return existe(raiz, x);
    }

    public boolean existe(Nodo p, int x) {
        if (p == null) {
            return false;
        }
        if (p.elem == x) {
            return true;
        }
        if (x < p.elem) {
            return existe(p.izq, x);
        }
        return existe(p.der, x);
    }
//Metodos de eliminar
    public void elim(int x) {
        raiz = elim(raiz, x);
    }

    public Nodo elim(Nodo p, int x) {
        if (p == null) {
            return null;
        }
        if (p.elem == x) {
            return elimNodo(p);
        }
        if (x < p.elem) {
            p.izq = elim(p.izq, x);
        } else {
            p.der = elim(p.der, x);
        }
        return p;
    }

    public Nodo elimNodo(Nodo p) {
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
         Nodo aux=null;
        while (q.der != null) {
            q=q.der;
        }
        int y = q.elem;
        elim(y);

        p.elem = y;
        return p;

    }
    //1 elim pares
    public void elimP() {
        raiz = elimP(raiz);
    }

    private Nodo elimP(Nodo p) {
        if (p == null) {
            return null;
        }
        p.izq = elimP(p.izq);
        p.der = elimP(p.der);
        if (p.elem % 2 == 0) {
            return elimNodo(p);
        }
        return p;
    }
    //2. Elim terminales
    public void elimTer() {
        raiz = elimTer(raiz);
    }

    private Nodo elimTer(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null && p.der == null) {
            return null;
        }
        p.izq = elimTer(p.izq);
        p.der = elimTer(p.der);
        return p;
    }
    //3. elim menor
    public void elimMen() {
        raiz = elimMen(raiz);
    }

    private Nodo elimMen(Nodo p) {
        if (p == null) {
            return null;
        }
        if (p.izq == null) {
            return p.der;
        }
        p.izq = elimMen(p.izq);
        return p;
    }
    //4. elim mayor
    public void elimMay(){
        raiz=elimMay(raiz);
    }
    private Nodo elimMay(Nodo p){
        if(p==null)return null;
        
        if(p.der==null){
            return p.izq;
        }
        p.der=elimMay(p.der);
        return p;
    }
    //5. elim nivel
    public void elimNivel(int n) {
        raiz = elimNivel(raiz, n, 0);
    }

    private Nodo elimNivel(Nodo p, int ni, int i) {
        if (p == null) {
            return null;
        }
        i++;
        if (ni == i) {
            return elimNodo(p);
        }
        p.izq = elimNivel(p.izq, ni, i);
        p.der = elimNivel(p.der, ni, i);
        return p;
    }

    
    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.insertar(10);
        A1.insertar(3);
        A1.insertar(18);
        A1.insertar(14);
        A1.insertar(16);
        A1.insertar(20);
        A1.insertar(21);
        A1.insertar(17);


        A1.inOrdern();
        A1.elimNivel(3);
        A1.inOrdern();

       

    }
}
