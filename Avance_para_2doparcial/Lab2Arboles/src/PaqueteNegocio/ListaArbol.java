/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PaqueteNegocio;

/**
 *
 * @author Estudiante_2
 */
public class ListaArbol {

    public int cantElem;
    public int max;
    public Arbol arbol[];

    public ListaArbol() {
        this.max = this.cantElem = 10;
        this.arbol = new Arbol[this.max];
        for (int i = 0; i < 10; i++) {
            this.arbol[i] = new Arbol();
        }
    }

    public void generar(int n, int a, int b) {// en el vector cargamos n elementos 
        for (int i = 1; i <= n; i++) {
            int numrandom = (int) (a + (b - a) * Math.random());// 1 5 9 10 5 6 4 8 8 9
            arbol[numrandom % 10].insertar(numrandom);
        }
    }

    public void mostrarOrdenadosAsc() {
        for (int i = 0; i < 10; i++) {
            arbol[i].inOrdenOrdAsc();
            System.out.println();
        }
    }

    public void mostrarOrdenadosDesc() {
        for (int i = 0; i < 10; i++) {
            arbol[i].inOrdenOrdDesc();
            System.out.println();
        }
    }

    public static void main(String[] arg) {
        ListaArbol LA1 = new ListaArbol();
        LA1.generar(10, 0, 10);
        LA1.mostrarOrdenadosAsc();

    }
}
