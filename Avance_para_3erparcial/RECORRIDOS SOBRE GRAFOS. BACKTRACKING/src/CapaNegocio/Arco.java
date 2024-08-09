/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author Usuario
 */
public class Arco {
    public Nodo pDest;
    public int valor;
    public Arco prox;
    public Arco(Nodo pDest,int valor){
        this.pDest=pDest;
        this.valor=valor;
    }
  

}
