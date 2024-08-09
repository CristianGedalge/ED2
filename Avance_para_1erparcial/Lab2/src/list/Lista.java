/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package list;

/**
 *
 * @author Estudiante
 */
public class Lista {

    private int[] elem;
    private int cantElem;
    private int max;

    public Lista(int max) {
        this.max = max;
        this.cantElem = 0;
        this.elem = new int[max];
    }
//Pregunta 1

    public void insertarIesimo(int x, int i) {
        int k = this.cantElem - 1;
        while (k >= i) {
            this.elem[k + 1] = this.elem[k];
            k = k - 1;
        }
        this.elem[i] = x;
        this.cantElem++;
    }
//Preunta 2

    public void insertPrimero(int x) {
        insertarIesimo(x, 0);
    }
//Pregunta 3

    public void insertUltimo(int x) {
        insertarIesimo(x, this.cantElem);
    }
//Pregunta 4

    public void eliminarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElem) {
            this.elem[k - 1] = this.elem[k];
            k = k + 1;
        }
        this.cantElem--;
    }
//Pregunta 5

    public void eliminarPrim() {
        this.eliminarIesimo(0);
    }
//Pregunta 6

    public void eliminarUlt() {
        this.eliminarIesimo(this.cantElem - 1);
    }
//Pregunta 7

    public void pasarDigitos(int n) {
        while (n != 0) {
            int r = n % 10;
            n = n / 10;
            this.insertPrimero(r);
        }
    }



//Pregunta 8
    public void rotarIzqDer(int n) {
        for (int i = n; i > 0; i--) {
            int ele = this.elem[this.cantElem - 1];
            eliminarUlt();
            insertPrimero(ele);
        }

    }
//Pregunta 9

    public void rotarDerIzq(int n) {

        for (int i = n; i > 0; i--) {
            int ele = this.elem[0];
            eliminarPrim();
            insertUltimo(ele);
        }
    }

//Pregunta 10
    public void eliminarPrime(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarIesimo(0);
            }
        }

    }
//Pregunta 11

    public void eliminarUltimo(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarUlt();
            }
        }
    }
//Pregunta 12
    
    public void insertIesimo(Lista L2,int i){
        
        
        int j=0;
        while(j<L2.cantElem)
        {
            insertarIesimo(L2.elem[j], i);
            i++;
            j++;
        }
        
    }
    public void eliminarUnicos() {
        int i = 0;
        while (i <= this.cantElem) {
            int j = 0;
            int contador = 0;
            while (j <= this.cantElem) {
                if (this.elem[i] == this.elem[j]) {
                    contador++;
                }
                j++;
            }
            if (contador == 1) {
                eliminarIesimo(i);
            }
            i++;
        }
    }
    @Override
    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElem) {
            if (i == this.cantElem - 1) {
                s1 = s1 + this.elem[i];
            } else {
                s1 = s1 + this.elem[i] + " ,";
            }
            i = i + 1;

        }
        return s1 + "]";
    }

    public static void main(String[] args) {
        Lista L = new Lista(5);
        L.insertPrimero(4);
        L.insertPrimero(6);
        L.insertPrimero(10);
        System.out.println(L.toString());
//        L.pasarDigitos(5681);
//L.eliminarUltimo(2);
        L.rotarIzqDer(2);
        System.out.println(L.toString());

    }
}
