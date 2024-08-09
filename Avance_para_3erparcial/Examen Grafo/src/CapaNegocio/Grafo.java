/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

import java.util.LinkedList;

/**
 *
 * @author CRISTIAN
 */
public class Grafo {

    Nodo prim, ult;
    int CN;

    public Grafo() {
        prim = ult = null;
        CN = 0;
    }

    public void insert(String name1, String name2, int val) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null) {
            insertN(name1);
            insert(name1, name2, val);
        }
        if (pD == null) {
            insertN(name1);
            insert(name1, name2, val);
        }
        if (pO != null && pD != null) {
            pO.insertArc(pD, val);
        }
    }

    public Nodo buscar(String name1) {
        Nodo p = prim;
        while (p != null) {
            if (p.name == name1) {
                return p;
            }
            p = p.prox;
        }
        return null;
    }

    public void insertN(String name1) {
        if (!existe(name1)) {
            if (CN == 0) {
                prim = ult = new Nodo(name1);
            } else {
                ult = ult.prox = new Nodo(name1);
            }
            CN++;
        }
    }

    public boolean existe(String name) {
        Nodo p = prim;
        while (p != null) {
            if (p.name == name) {
                return true;
            }
            p = p.prox;
        }
        return false;
    }

    public void mostrar() {
        Nodo p = prim;
        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                System.out.println(p.name + "-" + a.valor + "->" + a.pD.name);
                a = a.prox;
            }
            p = p.prox;
        }
    }
    //1

    public int cantSal(String name1) {
        return buscar(name1).CA;
    }

    //2 mayor elemento
    public int mayor() {
        int may = 0;
        Nodo p = prim;
        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                if (a.valor > may) {
                    may = a.valor;
                }
                a = a.prox;
            }
            p = p.prox;
        }
        return may;
    }

    //3. son vecinos 
    public boolean existe(String name1, String name2) {
        Nodo p = buscar(name1);

        Arco a = p.prim;
        while (a != null) {
            if (a.pD.name == name2) {
                return true;
            }
            a = a.prox;
        }
        return false;
    }

    //4 Muestra los nombers de los nodos islas
    public String isla() {
        Nodo p = prim;
        String s = "";
        while (p != null) {
            if (p.CA == 0 && CL(p.name) == 0) {
                s += p.name + ",";
            }
            p = p.prox;
        }
        return s;
    }

    //5 cantidadd de llegadas
    public int CL(String name2) {
        Nodo p = prim;
        int c = 0;
        while (p != null) {
            Arco a = p.prim;
            while (a != null) {
                if (a.pD.name == name2) {
                    c++;
                }
                a = a.prox;
            }
            p = p.prox;
        }
        return c;
    }

    //BACKTRACKING
    //1. MostrarCaminos
    public void mostrarcami(String name1, String name2) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null || pD == null) {
            return;
        }
        LinkedList<Nodo> L = new LinkedList();
        L.add(pO);
        caminos(L, pO, pD);
    }

    public void caminos(LinkedList<Nodo> L, Nodo pO, Nodo pD) {
        if (pO == pD) {
            System.out.println(imprimir(L));
            return;
        }
        Arco arc = pO.prim;
        while (arc != null) {
            if (!L.contains(arc.pD)) {
                L.add(arc.pD);
                caminos(L, arc.pD, pD);
                L.removeLast();
            }
            arc = arc.prox;
        }
    }

    public String imprimir(LinkedList<Nodo> L) {
        String s = "[";
        for (Nodo nodo : L) {
            s += nodo.name + ",";
        }
        return s + "]";
    }

    //2. cant de caminos de A a B
    public int cantcami(String name1, String name2) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null || pD == null) {
            return 0;
        }
        LinkedList<Nodo> L = new LinkedList();
        L.add(pO);
        return camin(L, pO, pD);
    }

    public int camin(LinkedList<Nodo> L, Nodo pO, Nodo pD) {
        int c = 0;
        if (pO == pD) {
            c = 1;
        }
        Arco arc = pO.prim;
        while (arc != null) {
            if (!L.contains(arc.pD)) {
                L.add(arc.pD);
                c += camin(L, arc.pD, pD);
                L.removeLast();
            }
            arc = arc.prox;
        }
        return c;
    }

    //3. metodo que muestra los caminos con costos
    public void mostrarcamicosto(String name1, String name2) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null || pD == null) {
            return;
        }
        LinkedList<Nodo> L = new LinkedList();
        L.add(pO);
        camicosto(L, pO, pD, 0);
    }

    public void camicosto(LinkedList<Nodo> L, Nodo pO, Nodo pD, int costo) {
        if (pO == pD) {
            System.out.println(impListCosto(L, costo));
            return;
        }
        Arco arc = pO.prim;
        while (arc != null) {
            if (!L.contains(arc.pD)) {
                L.add(arc.pD);
                camicosto(L, arc.pD, pD, costo + arc.valor);
                L.removeLast();
            }
            arc = arc.prox;
        }
    }

    public String impListCosto(LinkedList<Nodo> L, int costo) {
        String s = "[";
        int c = 0;
        for (Nodo nodo : L) {
            s += nodo.name + ",";
        }
        return s + "]->" + costo;
    }
    //4. metod que muestra el camino con menor costo

    public void mostrarcamimencosto(String name1, String name2) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null || pD == null) {
            return;
        }
        LinkedList<Nodo> L = new LinkedList();
        LinkedList<Integer> costo= new LinkedList<Integer>();
        //Lista general que guarda todos los caminos posibles
        LinkedList<LinkedList<Nodo>> LG=new LinkedList();
        L.add(pO);
        camiLG(LG,L,costo, pO, pD, 0);
        
        
       int men=Integer.MAX_VALUE;

        for (Integer cost: costo) {
            men=Math.min(cost, men);
        }
        for (int i = 0; i < LG.size(); i++) {
            if(costo.get(i)==men){
                System.out.println(impListCosto(LG.get(i),men));
            }
        }
    }
    
    public void camiLG(LinkedList<LinkedList<Nodo>> LG,LinkedList<Nodo> L,LinkedList<Integer> costo, Nodo pO, Nodo pD, int cost) {
        if (pO == pD) {
           LG.add(new LinkedList<>(L));
           costo.add(cost);
            
            return;
        }
        Arco arc = pO.prim;
        while (arc != null) {
            if (!L.contains(arc.pD)) {
                L.add(arc.pD);
                camiLG(LG,L,costo, arc.pD, pD, cost + arc.valor);
                L.removeLast();
            }
            arc = arc.prox;
        }
    }
    
    
    //5. metod que muestra el camino de menor recorrido
    
    public void mostrarcamimenreco(String name1, String name2) {
        Nodo pO = buscar(name1);
        Nodo pD = buscar(name2);
        if (pO == null || pD == null) {
            return;
        }
        LinkedList<Nodo> L = new LinkedList();
        //Lista general que guarda todos los caminos posibles
        LinkedList<LinkedList<Nodo>> LG=new LinkedList();
        L.add(pO);
        camireco(LG,L, pO, pD, 0);
        
        
       int men=Integer.MAX_VALUE;

        for (LinkedList<Nodo> listaReco : LG) {
            men=Math.min(men,listaReco.size() );
        }

        for (int i = 0; i < LG.size(); i++) {
            if(LG.get(i).size()==men){
                System.out.println(imprimir(LG.get(i)));
            }
        }
    }
    
    public void camireco(LinkedList<LinkedList<Nodo>> LG,LinkedList<Nodo> L, Nodo pO, Nodo pD, int cost) {
        if (pO == pD) {
           LG.add(new LinkedList<>(L));
            
            return;
        }
        Arco arc = pO.prim;
        while (arc != null) {
            if (!L.contains(arc.pD)) {
                L.add(arc.pD);
                camireco(LG,L, arc.pD, pD, cost + arc.valor);
                L.removeLast();
            }
            arc = arc.prox;
        }
    }
    public static void main(String[] args) {
        Grafo g = new Grafo();
        g.insertN("A");
        g.insertN("B");
        g.insertN("C");
        g.insertN("D");
        g.insertN("E");
        g.insertN("F");
        g.insert("A", "B", 5);
        g.insert("B", "D", 15);
        g.insert("C", "A", 1);
        g.insert("C", "D", 2);
        g.insert("C", "B", 8);

        System.out.println("Caminos de C a B: ");
        g.mostrarcami("C", "B");
        System.out.println("Cantidad de Caminos de C a B: ");
        System.out.println(g.cantcami("C", "B"));
        System.out.println("Caminos de C a B con su costo: ");
        g.mostrarcamicosto("C", "B");
        
        System.out.println("El camino de C a B con menor costo: ");
        g.mostrarcamimencosto("C", "B");
        System.out.println("El camino de C a B con menor recorriod: ");
        g.mostrarcamimenreco("C","B");
//        g.mostrar();
//        System.out.println("Islas: "+g.isla());
//        System.out.println("existe relacion ente A y B: "+g.existe("A","D"));
//        System.out.println("Cantidad de Salidas: "+g.cantSal("A"));
//        System.out.println("Mayor elemento: "+g.mayor());
//        System.out.println("Cantidad de Llegadas: "+g.CL("C"));

        System.out.println(g.CN);

    }
}
