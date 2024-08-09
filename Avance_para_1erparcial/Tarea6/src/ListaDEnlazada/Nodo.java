/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ListaDEnlazada;

/**
 *
 * @author CGGC
 */
public class Nodo {
    public Nodo ant;
    public int elem;
    public Nodo prox;
    public Nodo(Nodo ant,int x,Nodo prox)
    {
        this.ant=ant;
        this.elem=x;
        this.prox=prox;
        
    }
    

}
