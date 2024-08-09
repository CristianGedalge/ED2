/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

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

    public void eliminarTodo(int x) {
        int i = 0;
        while (i < this.cantElem) {
            if (this.elem[i] == x) {
                this.eliminarIesimo(i);
            }else{
            i++;
            }
        }
    }

//Pregunta 8
    public void eliminarPares() {
        int i = 0;
        while (i < this.cantElem) {
            if (this.elem[i] % 2 == 0) {
                this.eliminarIesimo(i);
            }
            i++;
        }
    }

//Pregunta 9
    public void eliminarUnicos() {
        int i = 0;
        while (i < this.cantElem) {
            int j = 0;
            int contador = 0;
            while (j < this.cantElem) {
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

//Pregunta 10
    public void eliminarTodo(Lista L2) {
        int j = 0;

        while (L2.cantElem > 0 && j < L2.cantElem) {
            int i = 0;
            int ele = L2.elem[j];
            while (i < this.cantElem) {
                if (this.elem[i] == ele) {
                    this.eliminarIesimo(i);
                } else {
                    i++;
                }
            }
            j++;
        }

    }
//Pregunta 11

    public void pasarDigitos(int n) {
        while (n != 0) {
            int r = n % 10;
            n = n / 10;
            this.insertPrimero(r);
        }
    }
//Pregunta 12

    public void rotarIzqDer(int n) {
        for (int i = n; i > 0; i--) {
            int ele = this.elem[this.cantElem - 1];
            eliminarUlt();
            insertPrimero(ele);
        }

    }
//Pregunta 13

    public void rotarDerIzq(int n) {

        for (int i = n; i > 0; i--) {
            int ele = this.elem[0];
            eliminarPrim();
            insertUltimo(ele);
        }
    }

//Pregunta 14
    public void eliminarPrime(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarIesimo(0);
            }
        }

    }
//Pregunta 15

    public void eliminarUltimo(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarUlt();
            }
        }
    }
//Pregunta 16

    public void insertIesimo(Lista L2, int i) {

        int j = 0;
        while (j < L2.cantElem) {
            insertarIesimo(L2.elem[j], i);
            i++;
            j++;
        }

    }
    
//pregunta 17
     public void insertarPrim(Lista L2){
	for (int i = 0; i < L2.cantElem; i++) {
            insertarIesimo(L2.elem[i], i);
        }
    }
//prefunta 18
    public void insertarultimo(Lista L2)
    {
        int j=0;
        for (int i = this.cantElem; i < this.max; i++) {
            if(i==this.max-1)
            {
             this.elem[i]=L2.elem[j];
             this.cantElem++;
            }else{
            this.insertarIesimo(L2.elem[j], i);
            }
            j++;
        }
    }

     
//pregunta 19
     public void eliminarIesimo(int i,int n)
     {
        int contador=0;
        while(contador<n)
        {
            this.eliminarIesimo(i);
            i++;
            contador++;
        }
     }

//pregunta 20
    public void EliminarExtremos(int n) {
        boolean flag = true;
        while (n != 0 && cantElem != 0) {
            if (flag) {
                flag = false;
                eliminarPrim();
            } else {
                flag = true;
                eliminarUlt();
            }
            n--;

        }

    }
//pregunta 21
    public void eliminarVeces(int k)
    {
        int i=0;
        while(i<this.cantElem)
        {
            int contador=0;
            int ele=this.elem[i];
            int j=0;
            while(j<this.cantElem)
            {
                if(ele==this.elem[j])
                {
                    contador++;
                }
                j++;
            }
            if(contador==k)
            {
                this.eliminarTodo(ele);
            }
            i++;
        }
    }
//pregunta 22
    public void eliminarAlternos()
    {
        for(int i=1;i<this.cantElem;i++)
        {
            this.eliminarIesimo(i);
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
        Lista L = new Lista(4);
        L.insertPrimero(5);
        L.insertPrimero(9);
//        L.insertPrimero(5);
//        L.insertPrimero(8);
//        L.insertPrimero(30);
        System.out.println(L.toString());
        Lista L2 = new Lista(6);
    
        L2.insertPrimero(8);
        L2.insertPrimero(15);
        L2.insertPrimero(5);
        L2.insertPrimero(40);
        L2.insertPrimero(30);
        System.out.println(L2.toString());
//        L.pasarDigitos(5681);
//L.eliminarUltimo(2);
//        L2.eliminarAlternos();
L.insertarultimo(L2);
        Lista L3=new Lista(4);
        L3.insertarIesimo(1, 0);
        L3.insertarIesimo(8, 1);
        L3.insertarIesimo(10, 1);
        System.out.println(L.toString());

    }
}
