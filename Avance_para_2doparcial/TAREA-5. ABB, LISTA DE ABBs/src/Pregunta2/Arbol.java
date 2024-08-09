/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Pregunta2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 *
 * @author Usuario
 */
public class Arbol {

    public Nodo raiz;
    public int cantElem;

    public Arbol() {
        raiz = null;
        cantElem = 0;
    }

    public Arbol(Arbol A1) {
        raiz = copiar(A1.raiz);
        cantElem = A1.cantElem;
    }

    private Nodo copiar(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo q = new Nodo(p.elem, p.frec);
        q.izq = copiar(p.izq);
        q.der = copiar(p.der);
        return q;
    }

    public void insertar(String elem) {
        raiz = insertarRec(raiz, elem);
    }

    private Nodo insertarRec(Nodo raiz, String elem) {
        if (raiz == null) {
            raiz = new Nodo(elem);
            cantElem++;
            return raiz;
        }
        if (elem.compareTo(raiz.elem) < 0) {
            raiz.izq = insertarRec(raiz.izq, elem);
        } else if (elem.compareTo(raiz.elem) > 0) {
            raiz.der = insertarRec(raiz.der, elem);
        } else {
            raiz.frec++;
        }
        return raiz;
    }

    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izq);
            System.out.println(nodo.elem + ": " + nodo.frec);
            inOrden(nodo.der);
        }
    }

    public void inOrdenDesc(Nodo nodo) {
        if (nodo != null) {
            inOrdenDesc(nodo.der);
            System.out.println(nodo.elem + ": " + nodo.frec);
            inOrdenDesc(nodo.izq);
        }
    }

    public void leerDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Convertir la línea a minúsculas y eliminar signos de puntuación
                linea = linea.toLowerCase().replaceAll("[+*=$%&.,\"\'()\\[\\]{};:!¡¿?1234567890-]", " ");
                StringTokenizer st = new StringTokenizer(linea);
                while (st.hasMoreTokens()) {
                    String palabra = st.nextToken();
                    if (!esPalabraIrrelevante(palabra)) {
                        insertar(palabra);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean esPalabraIrrelevante(String palabra) {
        Set<String> palabrasIrrelevantes = new HashSet<>(Arrays.asList(
                "y", "o", "el", "la", "los", "las", "un", "una", "unos", "unas",
                "de", "del", "a", "en", "con", "por", "para", "sin", "sobre",
                "entre", "pero", "si", "no", "lo", "al"
        ));
        return palabrasIrrelevantes.contains(palabra);
    }
//Encontrar las palabras que tienen una frecuencia entre a y b inclusive.

    public void palFrecuencia(int a, int b) {
        inOrden(raiz, a, b);
    }

    private void inOrden(Nodo nodo, int a, int b) {
        if (nodo != null) {
            inOrden(nodo.izq, a, b);
            if (nodo.frec > a && nodo.frec <= b) {
                System.out.println(nodo.elem + ": " + nodo.frec);
            }
            inOrden(nodo.der, a, b);
        }
    }

//LISTA DE ARBOLES    
//Encontrar las palabras de mayor frecuencia de cada árbol.
    public void mayorfrecuencia(ArrayList<Arbol> L1) {
        int i = 0;
        while (i < L1.size()) {
            Arbol A = L1.get(i);
            System.out.println(buscarPalabra(A.raiz));
            i++;
        }
    }

    public String buscarPalabra(Nodo p) {
        Nodo nodopalabra = MayFrecR(p);
        return nodopalabra.elem;
    }
//    public int MayFrecR(Nodo p)
//    {
//        int frc;
//        if(p==null)return 0;      
//        if(MayFrecR(p.izq)>MayFrecR(p.der))
//            frc=MayFrecR(p.izq);
//        else
//             frc=MayFrecR(p.der);
//        if(p.frec>frc)
//            return p.frec;
//        return frc;
//             
//    }

    public Nodo MayFrecR(Nodo p) {
        int frcizq;
        int frcder;

        if (p == null) {
            return null;
        }
        Nodo pizq = MayFrecR(p.izq);
        Nodo pder = MayFrecR(p.der);
        if (pizq == null) {
            frcizq = 0;
        } else {
            frcizq = pizq.frec;
        }
        if (pder == null) {
            frcder = 0;
        } else {
            frcder = pder.frec;
        }
        int frc;
        Nodo def;//nodo definitivo;
        if (frcizq > frcder) {
            frc = frcizq;
            def = pizq;
        } else {
            frc = frcder;
            def = pder;
        }
        if (p.frec > frc) {
            return p;
        }
        return def;
    }

//Encontrar las palabras que más se repiten en la Lista de árboles.
//Verificar si todos los árboles tienen la misma cantidad de elementos.
    public boolean cantElem(ArrayList<Arbol> L1) {
        int i = 0;
        int cant = L1.get(i).cantElem;
        while (i < L1.size()) {
            Arbol A = L1.get(i);
            if (cant != A.cantElem) {
                return false;
            }
            i++;
        }
        return true;
    }
//Encontrar las palabras de frecuencia mínima de cada árbol.

    public void menorfrecuencia(ArrayList<Arbol> L1) {
        int i = 0;
        while (i < L1.size()) {
            Arbol A = L1.get(i);
            System.out.println(buscarPalabraMen(A.raiz));
            i++;
        }
    }

    public String buscarPalabraMen(Nodo p) {
        Nodo nodopalabra = MenFrecR(p);
        return nodopalabra.elem;
    }

    public Nodo MenFrecR(Nodo p) {
        int frcizq;
        int frcder;

        if (p == null) {
            return null;
        }
        Nodo pizq = MenFrecR(p.izq);
        Nodo pder = MenFrecR(p.der);
        if (pizq == null) {
            frcizq = 0;
        } else {
            frcizq = pizq.frec;
        }
        if (pder == null) {
            frcder = 0;
        } else {
            frcder = pder.frec;
        }
        int frc;
        Nodo def;//nodo definitivo;
        if (frcizq < frcder) {
            frc = frcizq;
            def = pizq;
        } else {
            frc = frcder;
            def = pder;
        }
        if (p.frec < frc) {
            return p;
        }
        return def;
    }
//Encontrar las palabras de frecuencia mínima de todo el árbol.

    public String palmenFrecTree(ArrayList<Arbol> L1) {
        int i = 0;
        Arbol A = L1.get(i);
        Nodo p = MenFrecR(A.raiz);
        while (i < L1.size()) {
            Arbol A1 = L1.get(i);
            Nodo p1 = MenFrecR(A1.raiz);
            if (!(p.frec < p1.frec)) {
                p = p1;
            }
            i++;
        }
        return p.elem;
    }
//Verificar si todos los árboles tienen la misma altura.

    public boolean mismaaltura(ArrayList<Arbol> L1) {
        int i = 0;
        Arbol A = L1.get(i);
        int alt = altura(A.raiz);
        while (i < L1.size()) {
            Arbol A1 = L1.get(i);
            int alt2 = altura(A1.raiz);
            if (alt != alt2) {
                return false;
            }
            i++;
        }
        return true;
    }

    public int altura(Nodo p) {
        if (p == null) {
            return 0;
        }
        if (altura(p.izq) > altura(p.der)) {
            return altura(p.izq) + 1;
        }
        return altura(p.der) + 1;
    }
//Verificar si todos los árboles tienen alturas diferentes.

    public boolean difAltura(ArrayList<Arbol> L1) {
        int i = 0;
        int v[] = new int[L1.size()];
        while (i < L1.size()) {
            Arbol A1 = L1.get(i);
            int alt2 = altura(A1.raiz);
            v[0] = alt2;
            i++;
        }
        for (int j = 0; j < v.length; j++) {
            int cont=0;
            for (int k = 0; k < v.length; k++) {
                if(v[j]==v[k])
                    cont++;
            }
            if(cont>1)
                return false;
        }
        return true;
    }
//Incluir al menos 5 métodos adicionales interesantes.

    public static void main(String[] args) {
        Arbol A1 = new Arbol();
        A1.leerDesdeArchivo("python.txt");
        Arbol A2 = new Arbol();
        A2.leerDesdeArchivo("python.txt");
        Arbol A3 = new Arbol();
        A3.leerDesdeArchivo("python.txt");
//        A3.inOrden();
        Arbol A0 = new Arbol();
        System.out.println(A0.altura(A3.raiz));

        //System.out.println(A0.buscarPalabra(A3.raiz));
        ArrayList<Arbol> L = new ArrayList<>();
//        L.add(A1);
//        L.add(A2);
//        L.add(A3);
        //A0.mayorfrecuencia(L);
    }

//Encontrar las palabras de mayor frecuencia.
//Encontrar las palabras de menor frecuencia.
//Encontrar las palabras de longitud entre a y b, inclusive.
//Encontrar la cantidad de palabras menores a una palabra.
//Encontrar la cantidad de palabras mayores a una palabra.
//Encontrar la altura de la raíz a una palabra. (distancia de la raíz al nodo que contiene la palabra)
//Incluir al menos 5 métodos adicionales interesantes.
}
