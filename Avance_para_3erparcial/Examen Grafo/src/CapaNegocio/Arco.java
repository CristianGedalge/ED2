/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author CRISTIAN
 */
public class Arco {
    Nodo pD;
    Arco prox;
    int valor;
    public Arco(Nodo pD,int val){
        this.pD=pD;
        valor=val;
        prox=null;
        
    }
}
