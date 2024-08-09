/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaDE;

/**
 *
 * @author Usuario
 */
public class Lista {
    public int cantElem;
    public Nodo prim;
    public Nodo ult;
    public Lista()
    {
        this.prim=this.ult=null;
        this.cantElem=0;
    }
    
    @Override
    public String toString() {
        String s = "[";
        Nodo p = this.prim;
        while (p != null) {
            s = s + p.elem;
            if (p.prox != null) {
                s = s + " ";
            }
            p = p.prox;
        }
        return s + "]";
    }
    
    public void insertarUltm(int ele)
    {
        if(prim==null)
        {
            prim=ult=new Nodo(null,ele,null);
        }else{
            ult=ult.prox=new Nodo(ult,ele,null);
        }
        this.cantElem++;
    }
    public void eliminarUlt()
    {
       if(prim!=null)
       {
           if(this.cantElem==1)
           {
               prim=ult=null;
           }else{
               ult.ant.prox=null;
               ult=ult.ant;
           }
           this.cantElem--;
       }
    }
    
    public int  frecuencia(int x)
    {
        Nodo p=prim;
        int c=0;
        while(p!=null)
        {
            if(p.elem==x)
            {
                c++;
            }
            p=p.prox;
        }
        return c;
    }
    
    public boolean todoPares(int x)
    {
        Nodo p=prim;
        while(p!=null)
        {
            if(p.elem%2!=0)
            {
                return false;
            }
            p=p.prox;
        }
        return true;
    }
    public boolean seEncuentra(int x)
    {
        Nodo p=prim;
        while(p!=null)
        {
            if(p.elem==x)
            {
                return true;
            }
            p=p.prox;
        }
        return false;
    }
    
    public int  SumarPares()
    {
        int sum=0;
         Nodo p=prim;
        while(p!=null)
        {
            if(p.elem%2==0)
            {
                sum +=p.elem;
            }
            p=p.prox;
        }
        return sum;
    }
    
    
    public boolean Ordenado()
    {
        Nodo p=prim;
        int ele=p.elem;
        while(p!=null)
        {
            if(!(ele<=p.elem))
            {
                return false;
            }
            ele=p.elem;
            p=p.prox;
        }
        return true;
    }
    public static void main(String[] arg)
    {
        Lista L=new Lista();
        L.insertarUltm(5);
        L.insertarUltm(15);
        L.insertarUltm(11);
                L.insertarUltm(17);

                        L.insertarUltm(21);

       
        System.out.println(L.toString());
        L.eliminarUlt();
        L.eliminarUlt();
                L.eliminarUlt();
        L.eliminarUlt();
        
                

        System.out.println(L.toString());

    }
}
