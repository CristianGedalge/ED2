/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaNegocio;

import com.sun.org.apache.bcel.internal.generic.L2D;

/**
 *
 * @author CGGC
 */
public class Lista {

    public Nodo prim;
    public Nodo ult;
    public int cantElem;

    public Lista() {
        prim = ult = null;
        this.cantElem = 0;
    }
//    1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

    public void insertarIesimo(int x, int i) {
        int k = 0;
        Nodo p = prim, ap = null;
        while (k < i && p != null) {
            ap = p;
            p = p.prox;
            k = k + 1;

        }
        insertarNodo(ap, p, x);
    }
//2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.

    public void insertarPrim(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);

        } else {
            prim = prim.ant = new Nodo(null, x, prim);

        }
        cantElem = cantElem + 1;
    }
//3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.

    public void insertarUltm(int x) {
        if (vacia()) {
            prim = ult = new Nodo(null, x, null);
        } else {
            ult = ult.prox = new Nodo(ult, x, null);

        }
        cantElem = cantElem + 1;
    }
//4. L1.insertarLugarAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenadas de menor a mayor.

    public void insertarLugarAsc(int x) {
        Nodo p = prim, ap = null;
        while (p != null && p.elem < x) {
            ap = p;
            p = p.prox;

        }
        insertarNodo(ap, p, x);
    }
//5. L1.insertarLugarDes(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista ordenadas de mayor a menor.

    public void insertarLugarDes(int x) {
        Nodo p = prim, ap = null;
        while (p != null && p.elem > x) {
            ap = p;
            p = p.prox;

        }
        insertarNodo(ap, p, x);
    }
//6. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.

    public void insertarIesimo(Lista L2, int i) {

        Nodo p = L2.prim;
        while (p != null) {

            insertarIesimo(p.elem, i);
            p = p.prox;
            i++;

        }
    }
//7. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al principio de la lista L1.
//

    public void insertarPrim(Lista L2) {
        Nodo p = L2.prim, ap = null;
        int i = 0;
        while (p != null) {
            insertarIesimo(p.elem, i);
            p = p.prox;
            i++;
        }
    }
//8. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al final de la lista L1.
//

    public void insertarUlt(Lista L2) {
        Nodo p = L2.prim, ap = null;
        int i = cantElem;
        while (p != null) {
            insertarIesimo(p.elem, i);
            p = p.prox;
            i++;
        }
    }

//9. L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.
//
    public boolean iguales() {
        Nodo p = prim;
        while (p.prox != null) {
            if (p.elem != p.prox.elem) {
                return false;
            }
            p = p.prox;
        }
        return true;
    }
//10. L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.
//

    public Boolean Diferentes() {
        Nodo p = this.prim;
        while (p.prox != null) {
            if (p.elem == p.prox.elem) {
                return false;
            }
        }

        return true;
    }

//11. L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
//
    public int mayorElem() {
        Nodo p = prim;
        int numero = p.elem;
        while (p != null) {
            if (p.elem > numero) {
                numero = p.elem;
            }
            p = p.prox;
        }
        return numero;
    }
//12. L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
//

    public int menorElem() {
        Nodo p = prim;
        int numero = p.elem;
        while (p != null) {
            if (p.elem < numero) {
                numero = p.elem;
            }
            p = p.prox;
        }
        return numero;
    }

//13. L1.indexOf(x) : Método que devuelve la posición (lugar) de la primera ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –
//
    public int indexOf(int x) {
        Nodo actual = prim;
        int index = 0;
        while (actual != null) {
            if (actual.elem == x) {
                return index;
            }
            actual = actual.prox;
            index++;
        }
        return -1;
    }
//14. L1.lastIndexOf(x) : Método que devuelve la posición (lugar) de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –
//

    public int lastIndexOf(int x) {
        Nodo actual = prim;
        int lastIndex = -1;
        while (actual != null) {
            if (actual.elem == x) {
                lastIndex++;
            }
            actual = actual.prox;
        }
        return lastIndex;
    }
//15. L1.palindrome() : Método lógico que devuelve True, si la lista L1 contiene elementos que forma un palíndrome. 

    public boolean palindrome() {
        Nodo Cabeza = this.prim;
        Nodo Cola = this.ult;

        int i = 0;
        while (i < (this.cantElem / 2)) {
            if (Cabeza.elem != Cola.elem) {
                return false;
            }
            Cabeza = Cabeza.prox;
            Cola = Cola.ant;
            i++;

        }
        return true;
    }

    //16.  Incluir al menos 10 ejercicios cualesquiera, interesantes. (No utilizar métodos de eliminar . . . )
// 16.1. L1.eliminarRepetidos() : Método que elimina todos los elementos repetidos en la lista L1.
    public void eliminarRepetidos() {
        Nodo p = prim;
        while (p != null) {
            Nodo q = p.prox;
            while (q != null) {
                if (p.elem == q.elem) {
                    q.ant.prox = q.prox;
                    if (q == ult) {
                        ult = q.ant;
                    } else {
                        q.prox.ant = q.ant;
                    }
                    cantElem--;
                }
                q = q.prox;
            }
            p = p.prox;
        }
    }

// 16.2  L1.invertir() : Método que invierte el orden de los elementos en la lista L1.
    public void invertir() {
        Nodo p = prim;
        while (p != null) {
            Nodo temp = p.prox;
            p.prox = p.ant;
            p.ant = temp;
            if (p.ant == null) {
                ult = prim;
                prim = p;
                break;
            }
            p = p.ant;
        }
    }

//16.3
    public int posicion(int x) {
        Nodo p = prim;
        int pos = 0;
        while (p != null) {
            if (x == p.elem) {
                return pos;
            }
            pos++;
            p = p.prox;
        }
        return -1;
    }

//16.4
    public void rotarDerecha(int k) {
        if (k <= 0 || cantElem < 2) {
            return;
        }
        k = k % cantElem;
        for (int i = 0; i < k; i++) {
            ult.prox = prim;
            prim.ant = ult;
            prim = ult;
            ult = ult.ant;
            prim.ant = null;
            ult.prox = null;
        }
    }

//16.5
    public int suma() {
        Nodo p = prim;
        int sum = 0;
        while (p != null) {
            sum += p.elem;
            p = p.prox;
        }
        return sum;
    }

//16.6
    public void intercambiarExtremos() {
        if (cantElem < 2) {
            return;
        }
        int temp = prim.elem;
        prim.elem = ult.elem;
        ult.elem = temp;
    }

//16.7
    public int encontrarMaximo() {
        if (vacia()) {
            return Integer.MAX_VALUE;
        }
        int maximo = prim.elem;
        Nodo p = prim.prox;
        while (p != null) {
            if (p.elem > maximo) {
                maximo = p.elem;
            }
            p = p.prox;
        }
        return maximo;
    }

//16.8
    public double calcularPromedio() {
        if (vacia()) {
            return 0.0;
        }
        double suma = 0.0;
        Nodo p = prim;
        while (p != null) {
            suma += p.elem;
            p = p.prox;
        }
        return suma / cantElem;
    }

//16.9
    public void eliminarElemento(int x) {
        Nodo p = prim;
        while (p != null) {
            if (p.elem == x) {
                if (p == prim) {
                    prim = p.prox;
                    if (prim != null) {
                        prim.ant = null;
                    }
                } else if (p == ult) {
                    ult = p.ant;
                    ult.prox = null;
                } else {
                    p.ant.prox = p.prox;
                    p.prox.ant = p.ant;
                }
                cantElem--;
            }
            p = p.prox;
        }
    }

//16.10
    public int contarPares() {
        Nodo p = prim;
        int count = 0;
        while (p != null) {
            if (p.elem % 2 == 0) {
                count++;
            }
            p = p.prox;
        }
        return count;
    }



@Override
public String toString() {
        String s1 = "[";
        Nodo p = prim;
        while (p != null) {
            s1 = s1 + p.elem;
            if (p.prox != null) {
                s1 = s1 + "  ";
            }
            p = p.prox;
        }
        return s1 + "]";
    }

    public void insertarNodo(Nodo ap, Nodo p, int x) {
        if (ap == null) {
            insertarPrim(x);
        } else if (p == null) {
            insertarUltm(x);
        } else {
            ap.prox = p.ant = new Nodo(ap, x, p);
            this.cantElem++;
        }
    }

    public boolean vacia() {
        return this.cantElem == 0;
    }

    public void insertarLugar(int x) {
        Nodo p = prim, ap = null;
        while (p != null && x > p.elem) {
            ap = p;
            p = p.prox;

        }
        insertarNodo(ap, p, x);

    }

    public static void main(String[] args) {
        Lista L1 = new Lista();
        L1.insertarIesimo(4, 0);

        L1.insertarUltm(1);
//        L1.insertarUltm(22);
        //   L1.insertarLugarAsc(6);
        System.out.println(L1.palindrome());
        Lista L2 = new Lista();
        L2.insertarIesimo(6, 0);
        L2.insertarUltm(5);
        System.out.println(L1);

        System.out.println(L2);
        L1.insertarIesimo(L2, 2);
        System.out.println(L1);

    }
}
