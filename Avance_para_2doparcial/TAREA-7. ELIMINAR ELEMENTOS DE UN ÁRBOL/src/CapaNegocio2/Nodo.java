package CapaNegocio2;

public class Nodo {
    Nodo izq;
    Nodo der;
    String ele;
    public Nodo(String ele)
    {
        this.ele=ele;
        this.izq=this.der=null;
    }
}