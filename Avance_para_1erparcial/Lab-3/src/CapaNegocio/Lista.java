/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CapaNegocio;

/**
 *
 * @author jorge choque ygabriel
 */
public class Lista {

    private int[] elem;
    private int cantElem;
    private int max;

    public Lista(int max) {
        this.max = max;
        this.cantElem = 0;
        this.elem = new int[max];
    }
//1. L1.insertarIesimo(x, i) : Método que inserta el elemento x, en la posición i, de la lista L1.

    public void insertarIesimo(int x, int i) {
        int k = this.cantElem - 1;
        while (k >= i) {
            this.elem[k + 1] = this.elem[k];
            k = k - 1;
        }
        this.elem[i] = x;
        this.cantElem++;
    }

// 2. L1.insertarPrim(x) : Método que insertar el elemento x, al inicio de la lista L1.
    public void insertPrim(int x) {
        insertarIesimo(x, 0);
    }

//3. L1.insertarUlt(x) : Método que inserta el elemento x, al final de la lista L1.
    public void insertarUlt(int x) {
        insertarIesimo(x, this.cantElem);
    }

//4. L1.insertarLugasAsc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de menor a mayor.
    public void insertarLugasAsc(int x) {//[15,8,9]=[3,8,9,15)
        int i = 0;
        int elemento = this.elem[i];
        while (elemento < x) {

            elemento = this.elem[i];
            i++;
        }
        insertarIesimo(x, i - 1);
    }
//5. L1.insertarLugasDesc(x) : Método que inserta el elemento x, en su lugar correspondiente en la Lista L1, ordenada de mayor a menor.

    public void insertarLugasDesc(int x) {
        int i = 0;
        while (i < this.cantElem && this.elem[i] > x) {
            i++;
        }
        insertarIesimo(x, i);
    }

//6. L1.comunes(L2, L3) : Método que encuentra en L1, los elementos comunes en las Listas L2, L3. 
    public void comunes(Lista L2, Lista L3) {
        int k = 0;
        for (int i = 0; i < L2.cantElem; i++) {
            for (int j = 0; j < L3.cantElem; j++) {
                if (L2.elem[i] == L3.elem[j]) {
                    int ñ = 0;
                    if (!Existe(L2.elem[i])) {
                        insertarIesimo(L2.elem[i], ñ++);
                    }
                }
            }
        }
    }

    public boolean Existe(int x) {
        int i = 0;
        while (i < this.cantElem) {
            if (x == this.elem[i]) {
                return true;
            }
            i++;
        }
        return false;
    }
//7. L1.intercalar(L2, L3) : Método que encuentra en L1, los elementos intercalados de las Listas L2 y L3.

    public void intercalar(Lista L2, Lista L3) {
        int i = 0;
        int j = 0;
        int k = 0;
        boolean flag = true;
        while (i < this.max && (j < L2.cantElem || k < L3.cantElem)) {
            if (j < L2.cantElem && flag) {
                this.elem[i++] = L2.elem[j++];
                flag = false;
            } else {

                if (k < L3.cantElem) {
                    this.elem[i++] = L3.elem[k++];
                    flag = true;
                }
            }
        }

        this.cantElem = i;
    }
//8. L1.ordenado() : Método lógico que devuelve True, si los elementos de la lista L1, están ordenados en forma ascendente o descendente.

    public boolean ordenado() {

        return Ascendente() || Descendente();
    }

    public boolean Ascendente() {
        int i = 1;
        while (i < this.cantElem) {
            if (this.elem[i - 1] > this.elem[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

    public boolean Descendente() {
        int i = 1;
        while (i < this.cantElem) {
            if (this.elem[i - 1] < this.elem[i]) {
                return false;
            }
            i++;
        }
        return true;
    }

//9. L1.iguales() : Método lógico que devuelve True, si todos los elementos de la lista L1, son iguales.
//
    public boolean iguales() {
        if (this.cantElem <= 1) {
            return true;
        }

        int primerElemento = this.elem[0];

        for (int i = 1; i < this.cantElem; i++) {
            if (this.elem[i] != primerElemento) {
                return false;
            }
        }

        return true;
    }

//10. L1.diferentes() : Método lógico que devuelve True, si todos los elementos de la lista L1, son diferentes.
    public boolean diferentes() {
        for (int i = 0; i < this.cantElem; i++) {
            for (int j = i + 1; j < this.cantElem; j++) {
                if (this.elem[i] == this.elem[j]) {
                    return false;
                }
            }
        }

        return true;
    }

//11. L1.menor() : Método que devuelve el menor elemento de la Lista L1.
    public int menor() {
        int i = 0;
        int elemento = this.elem[i];
        while (i < this.cantElem) {
            if (elemento >= this.elem[i]) {
                elemento = this.elem[i];
            }
            i++;
        }
        return elemento;
    }
//12. L1.parImpar() : Método lógico que devuelve True, en la Lista L1, existe al menos un elemento par 
//y al menor un elemento impar.

    public boolean parImpar() {
        boolean hayPar = false;
        boolean hayImpar = false;

        for (int i = 0; i < this.cantElem; i++) {
            if (this.elem[i] % 2 == 0) {
                hayPar = true;
            } else {
                hayImpar = true;
            }

            if (hayPar && hayImpar) {
                return true;
            }
        }

        return false;
    }

//13. L1.mismaFrec() : Método lógico que devuelve True, si todos los elementos tienen la misma frecuencia de aparición en la Lista L1.
    public boolean mismaFrec() {
        int contador = frecuencia(elem[0]);
        for (int i = 0; i < this.cantElem; i++) {
            if (contador != frecuencia(this.elem[i])) {
                return false;
            }

        }
        return true;
    }

    public int frecuencia(int x) {
        int cantFrec = 0;
        for (int i = 0; i < this.cantElem; i++) {
            if (x == this.elem[i]) {
                cantFrec++;
            }
        }
        return cantFrec;
    }
//14. L1.palindrome() : Método lógico que devuelve True, si los elementos de la Lista L1, forma un palíndrome.

    public boolean palindrome() {
        int i = 0;
        int j = this.cantElem - 1;

        while (i < j) {
            if (this.elem[i] != this.elem[j]) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }

//15. L1.mismosElem(L2) : Método lógico que devuelve True, las Lista L1 y L2 tienen los mismos elementos. 
    public boolean mismosElem(Lista L2) {
         return perteneceaL1(L2)&&perteneceaL2(L2);
    }
    public boolean perteneceaL1(Lista L2)
    {
        for (int i = 0; i <L2.cantElem; i++) {
            boolean flag=true;
            for (int j = 0; j < this.cantElem; j++) {
                if(L2.elem[i]==this.elem[j])
                {
                    flag =false;
                    break;
                }
            }
            if(flag){
            return false;  
            }
        } 
        return true;
    }
    public boolean perteneceaL2(Lista L2)
    {
        for (int i = 0; i <this.cantElem; i++) {
            boolean flag=true;
            for (int j = 0; j < L2.cantElem; j++) {
                if(L2.elem[j]==this.elem[i])
                {
                    flag =false;
                    break;
                }
            }
            if(flag){
            return false;  
            }
        } 
        return true;
    }

    //10 metodos 
    public void insertarPrimos(int x) {
        int i = 0;
        while (x != 0) {
            int res = x % 10;
            x = x / 10;
            if (res == 2 || res == 3 || res == 5 || res == 7) {
                this.insertPrim(res);
                i++;
            }

        }
    }

    public void CargarFibonacci(int n) {
        if (n >= 1) {
            insertarIesimo(0, 0);
        }
        if (n >= 2) {
            insertarIesimo(1, 1);
        }
        for (int i = 2; i < n; i++) {
            this.elem[i] = this.elem[i - 2] + this.elem[i - 1];
            this.cantElem++;
        }
    }

    public float promedio() {
        float sum = 0;
        int i = 0;
        while (i < this.cantElem) {
            sum += this.elem[i];
            i++;
        }
        return sum / i;
    }

    public void invertirLista() {
        int i = 0;
        int f = this.cantElem - 1;
        while (i != this.cantElem / 2) {
            int eleinicial = this.elem[i];
            this.elem[i] = this.elem[f];
            this.elem[f] = eleinicial;
            i++;
            f--;

        }
    }

    @Override
    public String toString() {
        String s1 = "[";
        int i = 0;
        while (i < this.cantElem) {
            if (i == this.cantElem - 1) {
                s1 = s1 + this.elem[i];
            } else {
                s1 = s1 + this.elem[i] + " ,";
            }
            i = i + 1;

        }
        return s1 + "]";
    }

    public static void main(String[] args) {
        Lista L1 = new Lista(8);
        Lista L2 = new Lista(4);
        Lista L3 = new Lista(4);

        L1.insertarIesimo(3, 0);
        L1.insertarIesimo(5, 1);
        L1.insertarIesimo(10, 2);
//        L1.insertarIesimo(10 ,3);
//        L1.insertarIesimo(11, 4);
        L2.insertarIesimo(3, 0);
        L2.insertarIesimo(5, 1);
        L2.insertarIesimo(5, 2);
        L2.insertarIesimo(5, 3);

        L3.insertarIesimo(17, 0);
        L3.insertarIesimo(16, 1);
        L3.insertarIesimo(16, 2);
        System.out.println(L1.toString());
        System.out.println(L2.toString());
//       L1.intercalar(L2, L3);
//       L1.insertarLugasAsc(5);
        //L1.comunes(L2, L3);
//        System.out.println(L1.menor());
        System.out.println(L1.mismosElem(L2));

    }
}
