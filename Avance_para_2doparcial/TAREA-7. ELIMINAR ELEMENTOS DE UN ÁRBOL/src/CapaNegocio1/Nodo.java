package CapaNegocio1;
public class Nodo {
    Nodo izq;
    Nodo der;
    int ele;
    public Nodo(int ele)
    {
        this.ele=ele;
        this.izq=this.der=null;
    }
}