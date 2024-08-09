package CapaNegocio;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Usuario
 */
public class Grafo {

    public Nodo prim;
    public Nodo ult;
    public int cantNodos;

    public Grafo() {
        prim = ult = null;
        cantNodos = 0;
    }

    public Nodo buscar(String name) {
        Nodo p = prim;
        while (p != null) {
            if (p.name.equals(name)) {
                return p;
            }
            p = p.prox;
        }
        return null;
    }

//1. G1.insertarNodo(name) : Método que insertar un nodo en el grafo G1, con rótulo name. Sugerencia, insertar al último de la Lista de Nodos.
    public void insertarNodo(String name) {
        if (!seEncuentra(name)) {
            insertarUlt(name);
        }
    }

    public void insertarUlt(String name) {
        if (vacia()) {
            prim = ult = new Nodo(name);

        } else {
            ult = ult.prox = new Nodo(name);
        }
        cantNodos++;
    }

    public boolean vacia() {
        return prim == null && ult == null;
    }

    public boolean seEncuentra(String name) {
        Nodo p = prim;
        while (p != null) {
            if (p.name.equals(name)) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }
//2. G1.insertarArco(name1, name2, valor): Método que inserta un arco en el grafo G1, desde el nodo name1 hasta name2 con un peso del arco igual a valor. Sugerencia, insertar al último de la Lista de Arcos que sales de name1.

    public void insertarArco(String name1, String name2, int valor) {
        Nodo pOrigen = buscar(name1);
        Nodo pDest = buscar(name2);
        if (pOrigen == null) {
            insertarNodo(name1);
            insertarArco(name1, name2, valor);
        }
        if (pDest == null) {
            insertarNodo(name2);
            insertarArco(name1, name2, valor);
        }
        if (pDest != null) {
            pOrigen.insertarUlt(pDest, valor);
        }
    }
    
    
    
//1. G1.mostrarCaminos(name1, name2) : Método que muestra todos los caminos posibles desde el nodo name1 hasta name2. Sugerencia, utilizar una lista actual de camino recorrido.
    public void mostrarCaminos(String name1,String name2)
    {
        Nodo pOrigen=buscar(name1);
        Nodo pDest=buscar(name2);
        if(pOrigen==null || pDest==null)
            return ;
        LinkedList<Nodo> L1=new LinkedList<Nodo>();
        L1.add(pOrigen);
        caminos(L1,pOrigen,pDest);
    }
    
    public void caminos(LinkedList<Nodo> L1,Nodo  pOrigen,Nodo pDest){
        if(seEncuentra(L1,pOrigen))return;
        if(pOrigen==pDest){
            System.out.println(L1);
            return;
        }
        Arco p=pOrigen.prim;
        while(p!=null){
            L1.add(p.pDest);
            caminos(L1, p.pDest, pDest);
            L1.removeLast();
            p=p.prox;
        }
    }
    
    public boolean seEncuentra(LinkedList<Nodo>L1,Nodo p){
        int i=0;
        while(i<L1.size()-1){
            if(L1.get(i)==p)return true;
            i++;
        }
        return false;
    }
//2. G1.cantidadCaminos(name1, name2) : Método que devuelve la cantidad de caminos que existen desde el nodo name1 hasta name2.
    public int cantidadCaminos(String name1,String name2){
        Nodo pOrigen = buscar(name1);
    Nodo pDestino = buscar(name2);

    if (pOrigen == null || pDestino == null) {
        return 0;
    }

    int[] contador = {0};

    contarCaminos(pOrigen, pDestino, contador, new LinkedList<Nodo>());   
    return contador[0];
    }
    
    
    private void contarCaminos(Nodo nodoActual, Nodo pDestino, int[] contador, LinkedList<Nodo> caminoActual) {

    caminoActual.add(nodoActual);
    if (nodoActual == pDestino) {
        contador[0]++;
    } else {

        Arco arco = nodoActual.prim;
        while (arco != null) {
            contarCaminos(arco.pDest, pDestino, contador, caminoActual);
            arco = arco.prox;
        }
    }

    caminoActual.removeLast();
}
//3. G1.mostrarTotalCamino(name1, name2) : Método que muestra todos los caminos desde name1 a name2 con su costos totales de recorrido desde el origen al destino.
    public void mostrarTotalCamino(String name1, String name2) {
    Nodo pOrigen = buscar(name1);
    Nodo pDestino = buscar(name2);

    if (pOrigen == null || pDestino == null) {
        System.out.println("Alguno de los nodos no existe en el grafo.");
        return;
    }

    mostrarCaminosRecursivo(pOrigen, pDestino, new LinkedList<Nodo>(), 0);
}
    private void mostrarCaminosRecursivo(Nodo nodoActual, Nodo pDestino, LinkedList<Nodo> caminoActual, int costoTotal) {

    caminoActual.add(nodoActual);

    if (nodoActual == pDestino) {
        System.out.print("Camino encontrado: ");
        for (int i = 0; i < caminoActual.size(); i++) {
            System.out.print(caminoActual.get(i).name);
            if (i < caminoActual.size() - 1) {
                System.out.print(" -> ");
            }
        }
        System.out.println(" Costo total: " + costoTotal);
    } else {
        Arco arco = nodoActual.prim;
        while (arco != null) {
            mostrarCaminosRecursivo(arco.pDest, pDestino, caminoActual, costoTotal + arco.valor);
            arco = arco.prox;
        }
    }

    caminoActual.removeLast();
}
//4. G1.otrosMetodos() : Implementar otros métodos interesantes adicionales, sobre recorridos en el grafo G1.

    public String mostrarelem(String name1,String name2){
        Arco pOrigen=buscar(name1).prim;
        Nodo pDest=buscar(name2);
        String s="";
        
        while(pOrigen!=null)
        {
            if(pOrigen.pDest.name==name2)
            {
                s=pOrigen.valor+" - ";
            }
            pOrigen=pOrigen.prox;
        }
        return s;
         
    }
    
    
    
    public boolean contieneCiclo() {
    Set<Nodo> visitados = new HashSet<>();
    Set<Nodo> enPila = new HashSet<>();
    for (Nodo nodo : obtenerNodos()) {
        if (!visitados.contains(nodo)) {
            if (contieneCicloAux(nodo, visitados, enPila)) {
                return true;
            }
        }
    }
    return false;
}

private boolean contieneCicloAux(Nodo nodo, Set<Nodo> visitados, Set<Nodo> enPila) {
    visitados.add(nodo);
    enPila.add(nodo);
    Arco arco = nodo.prim;
    while (arco != null) {
        if (!visitados.contains(arco.pDest)) {
            if (contieneCicloAux(arco.pDest, visitados, enPila)) {
                return true;
            }
        } else if (enPila.contains(arco.pDest)) {
            return true;
        }
        arco = arco.prox;
    }
    enPila.remove(nodo);
    return false;
}

}
