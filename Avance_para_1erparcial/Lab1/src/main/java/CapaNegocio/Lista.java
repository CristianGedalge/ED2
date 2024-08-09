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

    public void eliminarPrim(int x) {
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
            } else {
                i = i + 1;

            }
        }

    }

//Pregunta 8
    public void eliminarPares()
    {
        int i=0;
        while(i<this.cantElem){
            if(this.elem[i]%2==0)
            {
                eliminarIesimo(i);
            }else{
            i++;
            }
        }
    }
//Pregunta 9
    public void eliminarUnicos()
    {
        int i=0;
        while(i<=this.cantElem)
        {
            int j=0;
            int contador=0;
            while(j<=this.cantElem)
            {
                if(this.elem[i]==this.elem[j])
                {
                    contador++;
                }
                j++;
            }
            if(contador==1)
            {
                eliminarIesimo(i);
            }
            i++;
        }
    }
//Pregunta 10
    
    public void eliminarTodo(Lista L2)
    {
        for (int i = 0; i < this.cantElem; i++) {
                if(apareceEnLista(this.elem[i], L2))
                {
                    int ele=this.elem[i];
                    for (int j = 0; j < this.cantElem; j++) {
                        if(ele==this.elem[j])
                        {
                            eliminarIesimo(j);
                            j--;
                        }
                    }
                    i--;
                }
                
            
        }
    }
    
    public boolean apareceEnLista(int x,Lista L2)
    {
        for (int i = 0; i < L2.cantElem; i++) {
            if(L2.elem[i]==x)
            {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElem) {
            if (i == this.cantElem - 1) {
                s1 = s1 + this.elem[i];
            } else {
                s1 = s1 + this.elem[i] + " ";
            }
            i = i + 1;

        }
        return s1 + "]";
    }

    public static void main(String[] args) {
        Lista L = new Lista(5);
        L.insertarIesimo(1, 0);
        L.insertarIesimo(3,1);
        L.insertarIesimo(6,2);
        
        
          Lista L2 = new Lista(5);
        L2.insertarIesimo(4, 0);
        L2.insertarIesimo(5,1);
        L2.insertarIesimo(5,2);
        System.out.println(L.toString());
        System.out.println(L2.toString());

        L.eliminarTodo(L2);
        System.out.println(L.toString());
    }
}
