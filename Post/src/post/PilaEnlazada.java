/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package post;
public class PilaEnlazada {
    

    Nodo raiz;

    public void push(Object d) {
        Nodo nuevo = new Nodo(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            if (d != null) {
                nuevo.siguinte = raiz;
                raiz = nuevo;
            }
        }
    }

    public Object pop() {
        Nodo temp = raiz;
        raiz = raiz.siguinte;
        return temp.dato;
    }

    public void imprimir() {
        Nodo temp = raiz;
        while (temp != null) {
            System.out.print(temp.dato + "->");
            temp = temp.siguinte;
        }
    }
    public int pos(Object o){
        Nodo temp = raiz;
        for (int i = 1; temp != null ; i++) {
            if (temp.dato == o) {
                return i;
            }
            temp = temp.siguinte;
        }
        return -1;
    
    }
    public Object peek() {
        return raiz.dato;
    }
   
    public int search(Object o){
        Nodo temp = raiz;
        while (temp != null) {
            if (temp.dato == o) {
                return 1;
            }
            temp = temp.siguinte;
        }
        return 0;
    }
    
    boolean isEmpty() {
        return raiz == null;
    }

    @Override
    public String toString() {
        Nodo temp = raiz;
        String salida = "";
        while (temp != null) {
            salida += temp.dato;
            temp = temp.siguinte;
        }
        return salida;
    }
    
}

class Nodo {

    Object dato;
    Nodo siguinte;

    public Nodo(Object dato) {
        this.dato = dato;
    }

}