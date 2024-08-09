/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

/**
 *
 * @author CGGC
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
//4.      L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.

    public boolean iguales() {
        int elemento = prim.elem;
        Nodo p = prim;
        while (p != null) {
            if (elemento != p.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }

//5.      L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
    public boolean diferentes() {
        Nodo cabeza = prim;
        while (cabeza != null) {
            int elemento = cabeza.elem;
            Nodo copia = cabeza.prox;
            while (copia != null) {
                if (elemento == copia.elem) {
                    return false;
                }
            }
        }
        return true;
    }

//6.      L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem() {
        int ele = this.prim.elem;
        while (this.prim != null) {
            if (!(ele > this.prim.elem)) {
                ele = this.prim.elem;
            }
            prim = prim.prox;
        }
        return ele;

    }
//7.      L1.menorElem() : Método que devuelve el menor elemento de la lista L1.

    public int menorElem() {
        Nodo P = prim;
        int ele = P.elem;
        while (P != null) {
            if (ele > P.elem) {
                ele = P.elem;
            }
            P = P.prox;
        }
        return ele;

    }
//8.      L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.

    public boolean ordenado() {
        return Ascendente() || Descendente();
    }

    public boolean Ascendente() {
        Nodo P = prim;
        int elemento = P.elem;
        while (P != null) {
            if (elemento <= P.elem) {
                elemento = P.elem;
            } else {
                return false;
            }

            P = P.prox;
        }
        return true;
    }

    public boolean Descendente() {
        Nodo P = prim;
        int elemento = P.elem;
        while (P != null) {
            if (elemento >= P.elem) {
                elemento = P.elem;
            } else {
                return false;
            }

            P = P.prox;
        }
        return true;
    }
//9.      L1.pares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.

    public boolean pares() {
        Nodo p = prim;
        while (p != null) {
            if (!(p.elem % 2 == 0)) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
//10.      L1.parImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par e impar.

    public boolean parImpar() {
        Nodo p = prim;
        boolean par = false, impar = false;
        while (p != null) {
            if (p.elem % 2 == 0) {
                par = true;
            } else {
                impar = true;
            }
            p = p.prox;
        }
        return par && impar;
    }
//11.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.

    public void reemplazar(int x, int y) {
        Nodo P = prim;
        while (P != null) {
            if (P.elem == x) {
                P.elem = y;
            }
            P = P.prox;
        }
    }
//12.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.

    public boolean seEncuentra(int x) {
        Nodo P = this.prim;
        while (P != null) {
            if (x == P.elem) {
                return true;
            }
            P = P.prox;
        }
        return false;
    }
//13.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.

    public int frecuencia(int x) {
        Nodo P = this.prim;
        int contador = 0;
        while (P != null) {
            if (x == P.elem) {
                contador++;
            }
            P = P.prox;
        }
        return contador;
    }
//14.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.

    public boolean existeFrec(int k) {
        Nodo P = this.prim;
        while (P != null) {
            if (k == frecuencia(P.elem)) {
                return true;
            }
            P = P.prox;
        }
        return false;
    }
//15.   L1.mismasFrec() : Método Lógico que devuelve True, si todos los elementos de la lista L1 tienen la misma frecuencia.

    public boolean mismaFrec() {
        Nodo P = this.prim;
        int frec = frecuencia(P.elem);
        while (P != null) {
            if (frec != frecuencia(P.elem)) {
                return false;
            }
            P = P.prox;
        }
        return true;
    }
//16.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)

    public boolean poker() {
        Nodo P = this.prim;
        int ele1 = P.elem;
        while (P != null) {
            if (ele1 != P.elem) {
                int carta1 = frecuencia(ele1);
                int carta2 = frecuencia(P.elem);
                if (carta1 == 1 && carta2 > 1 && (carta1 + carta2) == this.cantElem) {
                    return true;
                } else {
                    if (carta1 > 1 && carta2 == 1 && (carta1 + carta2) == this.cantElem) {
                        return true;
                    }
                }
            }
            P = P.prox;
        }
        return false;
    }
//17.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 == 0) {
                return  true;
            }
            p=p.prox;
        }
        return false;
    }
//18.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    public boolean existeImpar() {
        Nodo p = prim;
        while (p != null) {
            if (p.elem % 2 != 0) 
                return  true;
            p=p.prox;
        }
        return false;
    }
//19.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
//
//20.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
//
//21.   L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
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

//6.      L1.menorElem() : Método que devuelve el mayor elemento de la lista L1.
//7.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    public void seEncuentra(int x, int y) {

        while (this.prim != null) {
            if (x == this.prim.elem) {
                this.prim.elem = y;
            }
            prim = prim.prox;
        }
    }
    public void insertarUlt(Lista L2) {
        while (L2 != null) {
            insertarUlt(L2.prim.elem);
            L2.prim = L2.prim.prox;

        }
    }
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
        L1.insertarIesimo(4, 0);
        L1.insertarIesimo(4, 1);
        L1.insertarIesimo(5, 2);
        L1.insertarUlt(4);
//        L1.insertarUlt(5);
        System.out.println(L1.toString());

        Lista L2 = new Lista();
        L2.insertarIesimo(6, 0);
        L2.insertarIesimo(4, 1);
        L2.insertarIesimo(2, 2);
//        System.out.println(L2.toString());
//        L1.reemplazar(4,44);
        //System.out.println(L1.ordenado());
        System.out.println(L1.poker());
    }
}
