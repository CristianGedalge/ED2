/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaArreglo;

/**
 *
 * @author Usuario
 */
public class Lista {

    public int max = 50;
    public int v[];
    public int cantElem;

    public Lista() {
        this.v = new int[max];
        this.cantElem = 0;
    }

    //3.   L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
    public void insertarUlt(int x) {

        v[this.cantElem] = x;
        this.cantElem++;
    }

    public void eliminarPrim() {
        for (int i = 0; i < this.cantElem; i++) {
            v[i] = v[i + 1];
        }
        this.cantElem--;

    }

    public boolean todosPares() {
        for (int i = 0; i < this.cantElem; i++) {
            if (v[i] % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    public boolean todosImPares() {
        for (int i = 0; i < this.cantElem; i++) {
            if (v[i] % 2 == 0) {
                return false;
            }
        }
        return true;
    }

    public boolean seEncuentra(int x) {
        for (int i = 0; i < this.cantElem; i++) {
            if (v[i] == x) {
                return true;
            }
        }
        return false;
    }

    public int indexOf(int ele) {
        for (int i = 0; i < this.cantElem; i++) {
            if (v[i] == ele) {
                return i;
            }
        }
        return -1;
    }

    public int frecuencia(int x) {
        int j = 0;
        for (int i = 0; i < this.cantElem; i++) {
            if (v[i] == x) {
                j++;
            }
        }
        return j;
    }

    @Override
    public String toString() {
        int i = 0;
        String s = "[";
        while (i < this.cantElem) {
            s = s + v[i];
            i++;
        }
        return s + "]";
    }

}
