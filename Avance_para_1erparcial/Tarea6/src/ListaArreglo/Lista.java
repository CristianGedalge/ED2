/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ListaArreglo;

/**
 *
 * @author Usuario
 */
public class Lista {

    private int max = 100;
    private int v[];
    private int cantElem;

    public Lista() {

        this.v = new int[max];
        this.cantElem = 0;
    }

//1.   L1.toString() : Método que devuelve una cadena, que representa la secuencia de elementos de la lista L1.
    @Override
    public String toString() {
        String s = "[";
        int j = 0;
        while (this.cantElem > j) {
            s = s + this.v[j];
            if (j < this.cantElem-1) {
                s += ",";
            }
            j++;
        }
        return (s+"]");
    }
//2.   L1.insertarPrim(x) : Método que inserta el elemento x, al final de la lista L1.

    public void insertarPrim(int x) {
        int cant = this.cantElem - 1;
        for (int i = cant; i > 0; i--) {
            this.v[i + 1] = this.v[i];
        }
        this.v[0] = x;
        this.cantElem++;

    }
//3.   L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.

    public void insertarUlt(int x) {
        insertarIesimo(x, this.cantElem);
    }
//4. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

    public void insertarIesimo(int x, int i) {
        int cant = this.cantElem - 1;
        for (int j = cant; j >= i; j--) {
            this.v[j + 1] = this.v[j];
        }
        this.v[i] = x;
        this.cantElem++;
    }
//5. L1.insertarIesimo(L2, i) : Método que insertar los elementos de la lista L2 en la lista L1, desde la posición i.

    public void insertarIesimo(Lista L2, int i) {
        for (int j = 0; j < L2.cantElem; j++) {
            insertarIesimo(L2.v[j], i);
            i++;
        }
    }
//6. L1.insertarPrim(L2) : Método que insertar los elementos de la lista L2 al principio de la lista L1.

    public void insertarPrim(Lista L2) {
        int i = 0;
        for (int j = 0; j < L2.cantElem; j++) {
            insertarIesimo(L2.v[j], i);
            i++;
        }
    }
//7. L1.insertarUlt(L2) : Método que insertar los elementos de la lista L2 al final de la lista L1.

    public void insertarUlt(Lista L2) {
        for (int i = 0; i < L2.cantElem; i++) {
            insertarIesimo(L2.v[i], this.cantElem);
        }
    }
//8. L1.insertarAsc(x) : Método que inserta el elemento x en su lugar correspondiente, en la lista L1, ordenada en forma ascendente.

    public void insertarAsc(int x) {

        int i = 0;
        while (i < this.cantElem && this.v[i] < x) {
            i++;
        }
        insertarIesimo(x, i);
    }
//9. L1.insertarDes(x) : Método que inserta el elemento x en su lugar correspondiente, en la lista L1, ordenada en forma descendente.

    public void insertarDes(int x) {

        int i = 0;
        while (i < this.cantElem && this.v[i] > x) {
            i++;
        }
        insertarIesimo(x, i);
    }
//10. L1.concatenar(L2, L3): Método que concatena las listas L2 con L3 en L1.

    public void concatenar(Lista L2, Lista L3) {
        for (int i = 0; i < L2.cantElem; i++) {
            insertarIesimo(L2.v[i], this.cantElem);
        }
        for (int i = 0; i < 10; i++) {
            insertarIesimo(L3.v[i], this.cantElem);
        }
    }
//11. L1.intercalar(L2, L3): Método que intercala los elementos de las Listas L2 con L3 en L1.

    public void intercalar(Lista L2, Lista L3) {
        int cantTotal = L2.cantElem + L3.cantElem;
        int iL2 = 0, iL3 = 0;
        boolean flag = true;
        while (cantTotal > 0) {

            if (iL2 < L2.cantElem && flag) {
                insertarIesimo(L2.v[iL2], this.cantElem);
                iL2++;
                flag = false;
            } else {
                if (iL3 < L3.cantElem && flag) {
                    insertarIesimo(L3.v[iL3], this.cantElem);
                    iL3++;
                    flag = true;
                } else {
                    flag = true;
                }
            }
            cantTotal--;
        }
    }
//12. L1.merge(L2, L3): Método que realiza el merge en L1, de las listas ordenadas en forma ascedente L2 y L3.

    public void merge(Lista L2, Lista L3) {
        int i = 0, j = 0;
        while (i < L2.cantElem && j < L3.cantElem) {
            if (L2.v[i] < L3.v[j]) {
                insertarIesimo(L2.v[i++], this.cantElem);
            } else {
                insertarIesimo(L3.v[j++], this.cantElem);
            }
        }
        while (i < L2.cantElem) {
            insertarIesimo(L2.v[i++], this.cantElem);
        }

        while (j < L3.cantElem) {
            insertarIesimo(L3.v[j++], this.cantElem);
        }
    }
//13.   L1.iguales() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son iguales.

    public boolean iguales() {
        if (this.cantElem == 0) {
            return false;
        }
        int i = 0;
        int ele = this.v[i];
        while (i < this.cantElem) {
            if (ele != this.v[i]) {
                return false;
            }
            i++;
        }
        return true;
    }
//14.   L1.diferentes() : Método Lógico que devuelve True, si todos los elementos de la lista L1 son diferentes.

    public boolean diferentes() {
        if (this.cantElem == 0) {
            return false;
        }
        for (int i = 0; i < this.cantElem; i++) {
            int ele=this.v[i];
            int contador=0;
            for (int j = i; j < this.cantElem; j++) {
                if(ele==this.v[j]) contador++;
            }
            if(contador!=1)
            {
                return false;
            }
        }
        return true;
    }
//15.   L1.mayorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int mayorElem(){
        int i = 0;
        int mayor = this.v[i];
        while (i < this.cantElem) {
            if (!(mayor > this.v[i])) {
                mayor=this.v[i];
            }
            i++;
        }
        return mayor;
}
//16.    L1.menorElem() : Método que devuelve el mayor elemento de la lista L1.
    public int menorElem(){
        int i = 0;
        int menor = this.v[i];
        while (i < this.cantElem) {
            if (!(menor < this.v[i])) {
                menor=this.v[i];
            }
            i++;
        }
        return menor;
    }
//17.    L1.ordenado()  : Método Lógico que devuelve True, si todos los elementos de la lista L1 están ordenados en forma ascendente o descendente.
    public boolean ordenado()
    {
        return asc() ||desc();
    }
    public boolean asc()            
    {
        int i = 0;
        int ele = this.v[i];
        i++;
        while(i < this.cantElem) {
            if (ele <= this.v[i]) {
                ele=this.v[i];
            }else{
                return false;
            }
            i++;
        }
        return true;
    }
    
    public boolean desc()
    {
        int i = 0;
        int ele = this.v[i];
        i++;
        while(i < this.cantElem) {
            if (ele >= this.v[i]) {
                ele=this.v[i];
            }else{
                return false;
            }
            i++;
        }
        return true;
    }
//18.   L1.indexOf(x) : Método que devuelve la posición de la primera ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1.
    public  int indexOf(int x)
    {
        for (int i = 0; i <this.cantElem; i++) {
            if(x==this.v[i])
            {
                return i;
            }
        }
        return -1;
    }
//19.   L1.indexOf(x, i) : Método que devuelve la posición de la primera ocurrencia del elemento x, la búsqueda se realiza desde la posición i.
    public  int indexOf(int x,int i)
    {
        for (int j = i; j <this.cantElem; j++) {
            if(x==this.v[i])
            {
                return i;
            }
        }
        return -1;
    }
//20.   L1.lastIndexOf(x) : Método que devuelve la posición de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1.
    public  int lastIndexOf(int x)
    {
        for (int j = this.cantElem-1; j >=0; j--) {
            if(x==this.v[j])
            {
                return j;
            }
        }
        return -1;
    }
//21.   L1.lastIndexOf(x, i) : Método que devuelve la posición de la última ocurrencia del elemento x. Si x no se encuentra en la lista L1, el método devuelve –1. La búsqueda se realiza desde la posición i.
    public  int lastIndexOf(int x,int i)
    {
        for (int j = this.cantElem; j >=i; j--) {
            if(x==this.v[j])
            {
                return j;
            }
        }
        return -1;
    }
//22.   L1.reemplazar(x, y) : Método que reemplaza todas las ocurrencias del elemento x por el elemento y en la lista L1.
    public void reemplazar(int x, int y){
        for (int j =0; j<this.cantElem; j++) {
            if(x==this.v[j])
            {
                this.v[j]=y;
            }
        }
    }
//23.   L1.seEncuentra(x) : Método Lógico que devuelve True, si el elemento x, se encuentra en la lista L1.
    public boolean seEncuentra(int x ){
        for (int j =0; j<this.cantElem; j++) {
            if(x==this.v[j])
            {
                return true;
            }
        }
        return false;
    }
//24.   L1.frecuencia(x) : Método que devuelve la cantidad de veces que aparece el elemento x en la lista L1.
    public int frecuencia(int x){
        int contador=0;
        for (int j =0; j<this.cantElem; j++) {
            if(x==this.v[j])
            {
                contador++;
            }
        }
        return contador;
    }
//25.   L1.existeFrec(k) : Método Lógico que devuelve True, si existe algún elemento que se repite exactamente k-veces en la lista L1.
    public boolean existeFrec(int k){

        for (int j =0; j<this.cantElem; j++) {
            if(frecuencia(this.v[j])==k)
            {
                return true;
            }
        }
        return false;
    }
//26.   L1.mismasFrec() : Método Lógico que devuelve True, si los elementos de la lista L1 tienen la misma frecuencia.
     public boolean mismaFrec(){
        int frec=frecuencia(v[0]);
        for (int j =0; j<this.cantElem; j++) {
            if(!(frecuencia(this.v[j])==frec))
            {
                return false;
            }
        }
        return true;
    }
//27.   L1.poker() : Método Lógico que devuelve True, si los elementos de la lista L1 forman poker. (Todos los elementos son iguales excepto uno)
   public boolean poker() {
        int p=0;
        int ele1 = this.v[p];
        while (p < this.cantElem) {
            if (ele1 != this.v[p]) {
                int carta1 = frecuencia(ele1);
                int carta2 = frecuencia(this.v[p]);
                if (carta1 == 1 && carta2 > 1 && (carta1 + carta2) == this.cantElem) {
                    return true;
                } else {
                    if (carta1 > 1 && carta2 == 1 && (carta1 + carta2) == this.cantElem) {
                        return true;
                    }
                }
            }
           p++;
        }
        return false;
    }
     
     
//28.   L1.existePar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento par.
    public boolean existePar()
    {
        for (int i = 0; i <this.cantElem; i++) {
            if(this.v[i]%2==0)
            {
                return true;
            }
        }
        return false;
    }
//29.   L1.existeImpar() : Método lógico que devuelve True, si la lista L1 contiene al menos un elemento impar.
    public boolean existeImPar()
    {
        for (int i = 0; i <this.cantElem; i++) {
            if(this.v[i]%2!=0)
            {
                return true;
            }
        }
        return false;
    }
//30.   L1.todoPares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son pares.
    public boolean todosPares()
    {
        for (int i = 0; i <this.cantElem; i++) {
            if(this.v[i]%2!=0)
            {
                return false;
            }
        }
        return true;
    }
//31.   L1.todoImpares() : Método lógico que devuelve True, si todos los elementos de la lista L1 son impares.
    public boolean todosImpares()
    {
        for (int i = 0; i <this.cantElem; i++) {
            if(this.v[i]%2==0)
            {
                return false;
            }
        }
        return true;
    }
//32.   L1.existeParImpar() : Método lógico que devuelve True, si en la lista L1 al menos existe un elemento par y un elemento impar.
    public boolean existeParImpar()
    {
        return existePar()&& existeImPar();
    }
//33.   L1.alternos() : Método lógico que devuelve true, si la lista L1 contiene elementos en la siguiente secuencia: par, impar, par, impar, . . . or  impar, par, impar, par, . . . .
    public boolean alternos()
    {
        return ParImpar() || ImparPar();
    }
    

    public boolean ParImpar()
    {
        for (int i = 0; i < this.cantElem; i++) {
            if(i%2==0)
            {
                if(this.v[i]%2!=0)               
                    return false;                
            }
            if(i%2!=0)
            {
                if(this.v[i]%2==0)               
                    return false; 
            }
        }
        return true;
    }
    public boolean ImparPar()
    {
        for (int i = 0; i < this.cantElem; i++) {
            if(i%2==0)
            {
                if(this.v[i]%2==0)               
                    return false;                
            }
            if(i%2!=0)
            {
                if(this.v[i]%2!=0)               
                    return false; 
            }
        }
        return true;
    }
//34.   L1.palindrome() : Método lógico que devuelve True, si la lista L1 contiene elementos que forma un palíndrome. Ejemplo, caso anterior.
    public boolean palindrome() {
        int i = 0;
        int j = this.cantElem - 1;

        while (i < j) {
            if (this.v[i] != v[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
//35. L1.invertir() : Método que invierte los elementos de la lista L1.
    public void invertir()
    {
        int j=0;
        for (int i = this.cantElem-1; i >= (this.cantElem+1)/2; i--) {
            int ele=v[j];
            this.v[j]=this.v[i];
            
            v[i]=ele;
            j++;
        }
    }
//ELIMINAR LOS ELEMENTOS DE UNA LISTA
//
//1. L1.eliminarPrim() : Método que elimina el primer elemento de la lista L1.
    public void eliminarPrim() {
        this.eliminarIesimo(0);
    }
//2. L1.eliminarUlt() : Método que elimina el último elemento de la lista L1.  
    public void eliminarUlt() {
        this.eliminarIesimo(this.cantElem - 1);
    }
//3. L1.eliminarIesimo(i) : Método que elimina el i-ésimo elemento de la lista L1.
    public void eliminarIesimo(int i) {
        int k = i + 1;
        while (k < this.cantElem) {
            this.v[k - 1] = this.v[k];
            k = k + 1;
        }
        this.cantElem--;
    }
//4. L1.eliminarPrim(x) : Método que elimina el primer elemento x de la lista L1.
    public void eliminarPrim(int x) {
        boolean flag=true;
        int i=0;
       while(i<this.cantElem&& flag)
       {
           if(x==this.v[i])
           {
               eliminarIesimo(i);
               flag=false;
           }
           i++;
       }
    }
//5. L1.eliminarUlt(x) : Método que elimina el último elemento x de la lista L1.
    public void eliminarUlt(int x) {
        boolean flag=true;
        int i=this.cantElem-1;
       while(i>=0&& flag)
       {
           if(x==this.v[i])
           {
               eliminarIesimo(i);
               flag=false;
           }
           i--;
       }
    }
//6. L1.eliminarTodo( x ) : Método que elimina todos los elementos x de la lista L1.
    public void eliminarTodo(int x) {
        int i = 0;
        while (i < this.cantElem) {
            if (this.v[i] == x) {
                this.eliminarIesimo(i);
            }else{
            i++;
            }
        }
    }
//7. L1.eliminarPrim( n ) : Método que eliminar los primeros n-elementos de la lista L1.
    public void eliminarPrimm(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarIesimo(0);
            }
        }

    }
//8. L1.eliminarUlt( n ) : Método que elimina los n-últimos elementos de la lista L1.
    public void eliminarUltimo(int n) {
        if (n <= this.cantElem) {
            for (int i = n; i > 0; i--) {
                eliminarUlt();
            }
        }
    }
//9. L1.eliminarIesimo(i, n) : Método que elimina los n-elementos de la lista L1, desde la posición i.
    public void eliminarIesimo(int i,int n)
     {
        int contador=0;
        while(contador<n)
        {
            this.eliminarIesimo(i);
            i++;
            contador++;
        }
     }
//10. L1.eliminarExtremos( n ) : Método que eliminar la n-elementos de los extremos de la lista L1. 
    public void EliminarExtremos(int n) {
        boolean flag = true;
        while (n != 0 && cantElem != 0) {
            if (flag) {
                flag = false;
                eliminarPrim();
            } else {
                flag = true;
                eliminarUlt();
            }
            n--;

        }

    }
//11. L1.eliminarPares() : Método que elimina los elementos pares de la lista L1.
    public void eliminarPares() {
        int i = 0;
        while (i < this.cantElem) {
            if (this.v[i] % 2 == 0) {
                this.eliminarIesimo(i);
            }else{
            i++;
            }
        }
    }
//12.L1.eliminarUnicos() : Método que elimina los elementos que aparecen solo una vez en la lista L1.
     public void eliminarUnicos() {
        int i = 0;
        while (i < this.cantElem) {
            if(frecuencia(this.v[i])==1)
            {
                eliminarTodo(this.v[i]);
            }else{
                i++;
            }
        }
    }
//13 L1.eliminarTodo(L2) : Método que elimina todos los elementos de la lista L1, que aparecen en la lista L2.
    public void eliminarTodo(Lista L2) {
        int j = 0;
        while (L2.cantElem > 0 && j < L2.cantElem) {
            int i = 0;
            int ele = L2.v[j];
            while (i < this.cantElem) {
                if (this.v[i] == ele) {
                    this.eliminarIesimo(i);
                } else {
                    i++;
                }
            }
            j++;
        }

    }
//14. L1.eliminarVeces(k) : Método que elimina los elementos que se repiten k-veces en la lista L1.
    public void eliminarVeces(int k)
    {
        int i=0;
        while(i<this.cantElem)
        {
            if(frecuencia(this.v[i])==k)
            {
                eliminarTodo(this.v[i]);
            }else{
                i++;
            }
        }
    }
//15. L1.eliminarAlternos() : Método que elimina los elementos de las posiciones alternas. (permanece, se elimina, permanece, se elimina, etc.)
    public void eliminarAlternos()
    {
        for(int i=1;i<this.cantElem;i++)
        {
            this.eliminarIesimo(i);
        }
    }
//16. L1.rotarIzqDer( n ) : Método que hace rotar los elementos de la lista L1 n-veces de izquierda a derecha.
    public void rotarIzqDer(int n) {
        for (int i = n; i > 0; i--) {
            int ele = this.v[this.cantElem - 1];
            eliminarUlt();
            insertarPrim(ele);
        }

    }
//17. L1.rotarDerIzq( n ) : Método que hace rotar los elementos de la lista L1 n-veces de derecha a izquierda.
     public void rotarDerIzq(int n) {

        for (int i = n; i > 0; i--) {
            int ele = this.v[0];
            eliminarPrim();
            insertarUlt(ele);
        }
    }
     

     public static void main(String[] args) {
        Lista L1=new Lista();
        L1.insertarUlt(3);
        L1.insertarUlt(4);
        L1.insertarUlt(6);
        L1.insertarUlt(4);
        L1.insertarUlt(11);
        L1.insertarUlt(11);
//        L1.insertarUlt(16);
         System.out.println(L1);
         L1.invertir();
         System.out.println(L1);

    }
}
