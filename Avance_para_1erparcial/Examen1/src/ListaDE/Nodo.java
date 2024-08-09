/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDE;

/**
 *
 * @author Usuario
 */
public class Nodo {
    public Nodo prox;
    public Nodo ant;
    public int elem;
    public Nodo(Nodo ant,int ele,Nodo prox)
    {
        this.ant=ant;
        this.elem=ele;
        this.prox=prox;

        
    }
}
