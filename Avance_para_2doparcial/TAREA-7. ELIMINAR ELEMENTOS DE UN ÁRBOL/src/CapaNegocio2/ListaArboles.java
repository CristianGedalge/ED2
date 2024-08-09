/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio2;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ListaArboles {

    public ArrayList<Arbol> L1;

    public ListaArboles() {
        L1 = new ArrayList<>();
    }

    public ListaArboles(ArrayList<Arbol> L1) {
        this.L1 = L1;
    }

//1. L1.eliminar(L2): Método que elimina las palabras que aparecen en la Lista de palabras L2, de los árboles de Lista de árboles L1. L2, puede contener por ejemplo artículos or preposiciones or conectivos, etc.
    public void eliminar(ArrayList<String> L2) {
        for (int i = 0; i < L1.size(); i++) {
            for (String palabra : L2) {
                L1.get(i).eliminar(palabra);
            }
        }
    }
//2. L1.eliminarNodosRaices() : Método que elimina los nodos principales raíz, de cada Arbol.

    public void eliminarNodosRaices() {
        for (int i = 0; i < L1.size(); i++) {
            L1.get(i).eliminarRaices();

        }
    }
//3. L1.eliminarNodosTerm() : Método que elimina los nodos terminales de cada Arbol de L1.

    public void NodosTerm() {
        for (int i = 0; i < L1.size(); i++) {
            L1.get(i).eliminarHojas();
        }
    }

//Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
    //1. metodo que muestra el arbol en ordern asc
    public void inOrderAscListaArbol() {
        for (int i = 0; i < L1.size(); i++) {
            System.out.println("Arbol " + (i + 1) + ":");
            L1.get(i).inOrdenOrdAsc();

        }
    }

    //2. metodo que muestra el arbol en ordern Desc
    public void inOrderDescListaArbol() {
        for (int i = 0; i < L1.size(); i++) {
            System.out.println("Arbol " + (i + 1) + ":");
            L1.get(i).inOrdenOrdDesc();

        }
    }

    //3. metodo que elimina el nivel de todos los arboles de la lista 
    public void eliminarnivel(int n) {
        for (int i = 0; i < L1.size(); i++) {
            L1.get(i).eliminarNivel(n);

        }
    }

    //4 . metodo que elimina todo apartir de la palabra s;
    public void eliminarTodoApartirdeS(String s) {
        for (int i = 0; i < L1.size(); i++) {
            L1.get(i).eliminarTodoApartirden(s);
        }
    }

    //5. metodo que retorna la cantidad de nodos de cada  arbol de la lista 
    public void mostrarCantnodos() {
        for (int i = 0; i < L1.size(); i++) {
            System.out.println("Arbol" + i + 1 + " :" + L1.get(i).contNodos());
        }
    }

//1. L1.arbolPequeño() : Método que devuelve el Árbol de menos cantidad de elementos.
    public String ArbolPequeño() {
        int cantElem = L1.get(0).contNodos();
        int numerodeArbol = 1;

        for (int i = 0; i < L1.size(); i++) {
            if (!(cantElem < L1.get(i).contNodos())) {
                cantElem = L1.get(i).contNodos();
                numerodeArbol = i + 1;
            }
        }
        return "Arbol " + numerodeArbol;
    }
//2. L1.arbolGrande() : Método que devuelve el Árbol de mayor cantidad de elementos.

    public String ArbolGrande() {
        int cantElem = L1.get(0).contNodos();
        int numerodeArbol = 1;

        for (int i = 0; i < L1.size(); i++) {
            if (!(cantElem > L1.get(i).contNodos())) {
                cantElem = L1.get(i).contNodos();
                numerodeArbol = i + 1;
            }
        }
        return "Arbol " + numerodeArbol;
    }

//3. L1.igualTamaño() : Método lógico que devuelve True, si todos los Arboles tiene la misma cantidad de elementos.
    public Boolean igualTamaño() {
        int cantElem = L1.get(0).contNodos();
        for (int i = 0; i < L1.size(); i++) {
            if (!(cantElem != L1.get(i).contNodos())) {
                return false;
            }
        }
        return true;
    }

//4. L1.arbolAsc() : Método Lógico que devuelve True, si los árboles crecen secuencialmente por cantidad de elementos. 5,6,7
    public Boolean arbolAsc() {
        int cantElem = L1.get(0).contNodos()-1;
        for (int i = 0; i < L1.size(); i++) {
            if (cantElem+1== L1.get(i).contNodos()) {
                cantElem= L1.get(i).contNodos();
            }else{
                return false;
            }
        }
        return true;
    }
//5. L1.arbolMayorAltura() : Método que devuelve el arbol de mayor altura. 
    public String arbolMayorAltura() {
        int cantElem = L1.get(0).contNodos();
        int numerodeArbol = 1;

        for (int i = 0; i < L1.size(); i++) {
            if (!(cantElem > L1.get(i).altura())) {
                cantElem = L1.get(i).contNodos();
                numerodeArbol = i + 1;
            }
        }
        return "Arbol " + numerodeArbol;
    }
//6. Proponer e implementar al menos 5 ejercicios adicionales interesantes. En lo posible citar fuente.
   //1. metodo que devuelve la altura de cada arbol   
    public void alturadecadaArbol(){
        int num=0;
        for (Arbol arbol : L1) {
            num++;
            System.out.println("Arbol "+num+": "+arbol.altura());
        }
    }
    //2. cantidad de nodos que hay en el nivel n dela posicion i de la lista arbol
    public int cantNodospos(int i,int n){
        return L1.get(i).cantNodoxNivel(n);
    }    
    
    //3. preOrdenpos
    public void preOrdenpos(int i){
        L1.get(i).preOrden();
    }
    //4.postOrden
    public void postOrden(int i){
        L1.get(i).postOrden();
    }
    //5.mostrar nivel
    public void mostrarXnivelCadaArbol()
    {
        int num=0;
        for (Arbol arbol : L1) {
            System.out.println("Arbol "+num+":");
            arbol.mostrarNivel();
            num++;
        }
    }
    
    
    
    
    public static void main(String[] args) {
        ListaArboles L1 = new ListaArboles();
        Arbol A1 = new Arbol();
        A1.insertar("hola");
        A1.insertar("juan");

        Arbol A2 = new Arbol();

        A2.insertar("hola");
        A2.insertar("eleve");
        A2.insertar("jose");
        A2.insertar("jose");

        Arbol A3 = new Arbol();

        A3.insertar("hola");
        A3.insertar("peru");
        A3.insertar("bolivia");
        ArrayList<Arbol> L = new ArrayList<>();
        L.add(A1);
        L.add(A2);
        L.add(A3);
        L1 = new ListaArboles(L);
        System.out.println(L1.cantNodospos(2, 3));
//        ArrayList<String> s = new ArrayList<>();
//        s.add("hola");
//        L1.eliminar(s);
//        L1.inOrderAscListaArbol();

    }
}
