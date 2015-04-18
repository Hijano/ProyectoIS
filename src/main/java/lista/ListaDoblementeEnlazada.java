package lista;

public class ListaDoblementeEnlazada<T> {
    private static class Nodo<E> {
        private E elemento;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E elem, Nodo<E> sig, Nodo<E> prev) {
            elemento = elem;
            siguiente = sig;
            anterior = prev;
        }
    }

    private Nodo<T> primero, ultimo;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
    }

    public boolean estaVacio() {
        return primero == null && ultimo == null;
    }

    public void insertarDespues(Nodo<T> nodo, Nodo<T> nuevoNodo) {
        nuevoNodo.anterior = nodo;
        nuevoNodo.siguiente = nodo.siguiente;

        if (nodo.siguiente == null) {
            ultimo = nuevoNodo;
        } else {
            nodo.siguiente.anterior = nuevoNodo;
        }

        nodo.siguiente = nuevoNodo;
    }

    public void insertarAntes(Nodo<T> nodo, Nodo<T> nuevoNodo) {
        nuevoNodo.anterior = nodo.anterior;
        nuevoNodo.siguiente = nodo;

        if (nodo.anterior == null) {
            primero = nuevoNodo;
        } else {
            nodo.anterior.siguiente = nuevoNodo;
        }

        nodo.anterior = nuevoNodo;
    }

    public void insertarPrincipio(Nodo<T> nuevoNodo) {
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            nuevoNodo.anterior = null;
            nuevoNodo.siguiente = null;
        } else {
            insertarAntes(primero, nuevoNodo);
        }
    }

    public void insertarFinal(Nodo<T> nuevoNodo) {
        if (ultimo == null) {
            insertarPrincipio(nuevoNodo);
        } else {
            insertarDespues(ultimo, nuevoNodo);
        }
    }

    public T primero() {
        return primero.elemento;
    }

    public T ultimo() {
        return ultimo.elemento;
    }

    public void eliminar(Nodo<T> nodo) {
        if (nodo.anterior == null) {
            primero = nodo.siguiente;
        } else {
            nodo.anterior.siguiente = nodo.siguiente;
        }

        if (nodo.siguiente == null) {
            ultimo = nodo.anterior;
        } else {
            nodo.siguiente.anterior = nodo.anterior;
        }

        nodo = null;
    }

    public String toString() {
        String s = "Lista: (";
        for (Nodo<T> node = primero; node != null; node = node.siguiente) {
            s += node.elemento + (node.siguiente != null ? "," : "");
        }
        s += ")";
        return s;
    }
    
}

