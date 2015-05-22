package lista;

import lista.ListaDoblementeEnlazada.Nodo;

public class Pruebaaaa {
    public static void main(String[] args) {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
        Nodo<Integer> nodo1 = new Nodo<Integer>(1, null, null);
        Nodo<Integer> nodo2 = new Nodo<Integer>(2, null, null);
        Nodo<Integer> nodo3 = new Nodo<Integer>(3, null, null);
        lista.insertarPrincipio(nodo1);
        lista.insertarPrincipio(nodo2);
        lista.insertarPrincipio(nodo3);
        
        ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
        lista2.insertarPrincipio(nodo1);
        lista2.insertarPrincipio(nodo3);
        lista2.insertarPrincipio(nodo2);
        
        System.out.println(lista.iguales(lista2));
    }
}
