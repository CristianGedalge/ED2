/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.StringTokenizer;

/**
 *
 * @author Usuario
 */
public class Arbol {

    public Nodo raiz;
    public File archivo;

    public Arbol() {
        raiz = null;
    }

    public Arbol(Arbol A1) {
        raiz = copiar(A1.raiz);
    }

    public Nodo copiar(Nodo p) {
        if (p == null) {
            return null;
        }
        Nodo q = new Nodo(p.cad, p.frec);
        p.izq = copiar(p.izq);
        p.der = copiar(p.der);
        return q;
    }

//    public void generarElem(int n, int a, int b) {
//        for (int i = n; i > 0; i--) {
//            int x = (int) (Math.random() * (b - a)) + a;
//            System.err.println(x);
//            insertar(x);
//        }
//    }
//    public void insertar(String x) {
//        raiz = insertar(raiz, x);
//    }
    public void insertar(String x) {
//        crearArchivoTexto();
//        escribirArchivo(x);
//        String linea = leerArchivodeTexto();
//        linea = linea.toLowerCase();
//        StringTokenizer tokenizer = new StringTokenizer(linea);
//
//        while (tokenizer.hasMoreTokens()) {
//            //System.out.println(tokenizer.nextToken());
//            raiz = insertar(raiz, tokenizer.nextToken());
//        }
          leerArchivodeTexto(x);
    }

    private Nodo insertar(Nodo p, String x) {
        if (p == null) {
            return new Nodo(x);

        }
        if (p.cad.equals(x)) {//p.cad.compareTo(x)>1
            p.frec++;
        } else {
            if (x.length() > p.cad.length()) {
                p.izq = insertar(p.izq, x);
            } else {

                p.der = insertar(p.der, x);

            }
        }

        return p;

    }

    public void inordenMenMay() {
        inordenMenMay(raiz);
    }

    private void inordenMenMay(Nodo p) {
        if (p == null) {
            return;
        }
        inordenMenMay(p.izq);
        System.out.println(p.cad + " | " + p.frec);
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
        System.out.println(p.cad + " | " + p.frec);
        inOrdenMayMen(p.izq);

    }

    public void crearArchivoTexto() {
        this.archivo = new File("archivo.txt");

        try {
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado");
            } else {
                System.out.println("Error al crear Archivo,ya hay uno creado");
            }
        } catch (Exception e) {

        }
    }

    public void eliminarArchivo() {
    }

    public void escribirArchivo(String texto) {
        try {
            FileWriter escritura = new FileWriter(this.archivo);
            escritura.write(texto);
            //escritura.write("\n estimado !!!");
            escritura.close();
        } catch (Exception e) {
        }
    }

    /*public void leerArchivodeTexto(String nameArchivo) {
        String linea = "";
        try {
            FileReader lector = new FileReader(nameArchivo);
            BufferedReader lectura = new BufferedReader(lector);
            linea = lectura.readLine();

            while (linea != null) {
                //System.out.println(contenido);

                linea = linea.toLowerCase();
                StringTokenizer tokenizer = new StringTokenizer(linea);
                 
                while (tokenizer.hasMoreTokens()) {
                    //System.out.println(tokenizer.nextToken());
                    raiz = insertar(raiz, tokenizer.nextToken());
                }
                linea=lectura.readLine();
            }
        } catch (Exception e) {
        }
        //return contenido;
    }*/
    
    
     public void leerArchivodeTexto(String nameArchivo) {
        try {
            FileReader lector = new FileReader(nameArchivo);
            BufferedReader lectura = new BufferedReader(lector);
            String linea;

            while ((linea = lectura.readLine()) != null) {
                linea = linea.toLowerCase();
                StringTokenizer tokenizer = new StringTokenizer(linea);
                 
                while (tokenizer.hasMoreTokens()) {
                    String palabra = tokenizer.nextToken();
                    if (palabra.matches("[a-zA-Z]+")) {
                        raiz = insertar(raiz, palabra);
                    }
                }
            }
            lectura.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Arbol A1 = new Arbol();
//        A1.generarElem(10, 1, 5);
//        System.out.println("--------------------------------");
//        A1.inOrdenMayMen();
//        A1.crearArchivoTexto();
//        A1.escribirArchivo("hola como estas mi amigo el amigo de mi amigo es mi enemigo");
        A1.insertar("Startup.txt");
        A1.inOrdenMayMen();
    }
}
