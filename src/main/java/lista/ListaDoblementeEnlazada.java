package lista;

public class ListaDoblementeEnlazada<T> {
    public static class Nodo<E> {

        public E elemento;
        public Nodo<E> siguiente;
        public Nodo<E> anterior;

        public Nodo(E elem, Nodo<E> sig, Nodo<E> prev) {
            elemento = elem;
            siguiente = sig;
            anterior = prev;
        }
    }
    
    private int tamaño;
    private Nodo<T> primero, ultimo;

    public ListaDoblementeEnlazada() {
        primero = null;
        ultimo = null;
        tamaño = 0;
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
        tamaño++;
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
        tamaño++;
        nodo.anterior = nuevoNodo;
    }

    public void insertarPrincipio(Nodo<T> nuevoNodo) {
        if (primero == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
            nuevoNodo.anterior = null;
            nuevoNodo.siguiente = null;
            tamaño++;
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

    public int obtenerTamaño() {
        return tamaño;
    }
    
    public boolean iguales(ListaDoblementeEnlazada<T> lista) {
        boolean res = false;
        int aux = 0;
        if (lista.obtenerTamaño() == this.obtenerTamaño()) {
            if(lista.obtenerTamaño() > 0) {
                Nodo<T> nodoAux = lista.primero;
                Nodo<T> nodoAux2 = this.primero;
                while(nodoAux != null && (nodoAux.elemento == nodoAux2.elemento)) {
                    aux++;
                    nodoAux = nodoAux.siguiente;
                    nodoAux2 = nodoAux2.siguiente;
                }
                if (aux == lista.obtenerTamaño()) {
                    res = true;
                }
            } else {
                res = true;
            }
        }
        return res;
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

