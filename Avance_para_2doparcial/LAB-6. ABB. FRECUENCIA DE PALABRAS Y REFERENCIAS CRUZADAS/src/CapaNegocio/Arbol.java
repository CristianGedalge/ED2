/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.StringTokenizer;

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
        Nodo q = new Nodo(p.elem, p.frec, p.linea,p.pagina);
        q.izq = copiar(p.izq);
        q.der = copiar(p.der);
        return q;
    }

    public void insertar(String elem, int pagina,int pag) {
        raiz = insertarRec(raiz, elem, pagina,pag);
    }

    private Nodo insertarRec(Nodo raiz, String elem, int pagina,int pag) {
        if (raiz == null) {
            raiz = new Nodo(elem);
            if(!raiz.linea.contains(pagina))
                raiz.linea.add(pagina);
            if(!raiz.pagina.contains(pag))
                raiz.pagina.add(pag);
            cantElem++;
            return raiz;
        }
        if (elem.compareTo(raiz.elem) < 0) {
            raiz.izq = insertarRec(raiz.izq, elem, pagina,pag);
        } else if (elem.compareTo(raiz.elem) > 0) {
            raiz.der = insertarRec(raiz.der, elem, pagina,pag);
        } else {
            if(!raiz.linea.contains(pagina))
                raiz.linea.add(pagina);
            if(!raiz.pagina.contains(pag))
                raiz.pagina.add(pag);
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
            System.out.print(nodo.elem + ": " + nodo.frec+"|");
            for (int lin : nodo.linea) {
                System.out.print(lin + ",");
            }
            
            System.out.print("|");
            for (int pag : nodo.pagina) {
                System.out.print(pag + ",");
            }
            System.out.println();
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

    public void inordenMenMay() {
        inordenMenMay(raiz);
    }

    private void inordenMenMay(Nodo p) {
        if (p == null) {
            return;
        }
        inordenMenMay(p.izq);
        System.out.println(p.elem + " | " + p.frec);
        inordenMenMay(p.der);
    }

    public void inOrdenMayMen() {
        inOrdenMayMen(this.raiz);
    }

    private void inOrdenMayMen(Nodo p) {
        if (p == null) {
            return;
        }
        inOrdenMayMen(p.der);
        System.out.println(p.elem + " | " + p.frec);
        inOrdenMayMen(p.izq);

    }

    public void leerDesdeArchivo(String nombreArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            int NLin = 0;
            int NLincopy=0;
            int pag=1;
            while ((linea = br.readLine()) != null) {
                // Convertir la línea a minúsculas y eliminar signos de puntuación
                linea = linea.toLowerCase().replaceAll("[+*=$%&.,\"\'()\\[\\]{};:!¡¿?1234567890-]", " ");
                StringTokenizer st = new StringTokenizer(linea);
                while (st.hasMoreTokens()) {
                    String palabra = st.nextToken();
                    if (!esPalabraIrrelevante(palabra)) {
                        insertar(palabra, NLin,pag);
                    }
                }
                NLin++;
                NLincopy++;
                if(NLincopy==40)
                {
                    pag++;
                    NLincopy=0;
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
//Encontrar las palabras de mayor frecuencia.

    public void mayorfrec() {
        lista.add(raiz);
        mayorFrec(raiz);
        for (Nodo nodo : lista) {
            System.out.println(nodo.elem + ": " + nodo.frec);
        }
    }
    public LinkedList<Nodo> lista = new LinkedList<>();

    private void mayorFrec(Nodo p) {
        if (p == null) {
            return;
        }
        if (lista.getFirst().frec < p.frec) {
            lista.clear();
            lista.add(p);
        } else if (lista.getFirst().frec == p.frec) {
            lista.add(p);
        }
        mayorFrec(p.izq);
        mayorFrec(p.der);

    }

//Encontrar las palabras de menor frecuencia.
    public void menorfrec() {
        lista.add(raiz);
        menorfrec(raiz);
        for (Nodo nodo : lista) {
            System.out.println(nodo.elem + ": " + nodo.frec);
        }
    }

    private void menorfrec(Nodo p) {
        if (p == null) {
            return;
        }
        if (lista.getFirst().frec > p.frec) {
            lista.clear();
            lista.add(p);
        } else if (lista.getFirst().frec == p.frec) {
            lista.add(p);
        }
        menorfrec(p.izq);
        menorfrec(p.der);

    }
//Encontrar las palabras de longitud entre a y b, inclusive.

    public void longitud(int a, int b) {
        longitud(raiz, a, b);
    }

    private void longitud(Nodo nodo, int a, int b) {
        if (nodo != null) {
            longitud(nodo.izq, a, b);
            if (nodo.elem.length() > a && nodo.elem.length() <= b) {
                System.out.println(nodo.elem + ": " + nodo.frec);
            }
            longitud(nodo.der, a, b);
        }
    }
//Encontrar la cantidad de palabras menores a una palabra.

    public void longitud(String A) {
        longitud(raiz, A.length());
    }

    private void longitud(Nodo nodo, int pal) {
        if (nodo != null) {
            longitud(nodo.izq, pal);
            if (nodo.elem.length() < pal) {
                System.out.println(nodo.elem + ": " + nodo.frec);
            }
            longitud(nodo.der, pal);
        }
    }
//Encontrar la cantidad de palabras mayores a una palabra.

    public void cantPalMayoresA(String A) {
        int cantidad = cantPalMayoresA(raiz, A.length());
        System.out.println("Cantidad de palabras mayores a '" + A + "': " + cantidad);
    }

    private int cantPalMayoresA(Nodo nodo, int longPalabra) {
        if (nodo == null) {
            return 0;
        }
        int can = cantPalMayoresA(nodo.izq, longPalabra);
        if (nodo.elem.length() > longPalabra) {
            can++;
        }
        can += cantPalMayoresA(nodo.der, longPalabra);
        return can;
    }
//Encontrar la altura de la raíz a una palabra. (distancia de la raíz al nodo que contiene la palabra)

    public int alturaElemento(String elem) {
        return alturaElementoRec(raiz, elem);
    }

    private int alturaElementoRec(Nodo nodo, String elem) {
        if (nodo == null) {
            return -1; // El nodo no se encontró en el árbol
        }
        if (nodo.elem.equals(elem)) {
            return altura(nodo);
        }

        int alturaIzq = alturaElementoRec(nodo.izq, elem);
        if (alturaIzq != -1) {
            return alturaIzq;
        }

        return alturaElementoRec(nodo.der, elem);
    }

    private int altura(Nodo nodo) {
        if (nodo == null) {
            return -1; // Altura de un nodo nulo es -1
        } else {
            int alturaIzq = altura(nodo.izq);
            int alturaDer = altura(nodo.der);
            return 1 + Math.max(alturaIzq, alturaDer);
        }
    }
    
    
    //pregunta2
    
  

    public static void main(String[] args) {
        Arbol A1=new Arbol();
        A1.leerDesdeArchivo("Startup.txt");
        A1.inOrden();
    }
}
