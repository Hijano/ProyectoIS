
public class listaDoblementeEnlazada<T> {
	
    private static class Nodo<E> {
        private E elemento;
        private Nodo<E> siguiente;
        private Nodo<E> anterior;

        public Nodo(E x, Nodo<E> nxt, Nodo<E> prv) {
            elemento = x;
            siguiente = nxt;
            anterior = prv;
        }
    }

    private Nodo<T> primero, ultimo;
    
    public listaDoblementeEnlazada() {
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
        for (Nodo<T> node = primero; node != null; node = node.siguiente)
            s += node.elemento + (node.siguiente != null ? "," : "");
        s += ")";
        return s;
    }
    
    public static void main(String[] args) {
		listaDoblementeEnlazada<Integer> prueba = new listaDoblementeEnlazada<Integer>();
		
		Nodo<Integer> nodo5 = new Nodo<Integer>(5, null, null);
		Nodo<Integer> nodo9 = new Nodo<Integer>(9, null, null);
		Nodo<Integer> nodo1 = new Nodo<Integer>(1, null, null);
		Nodo<Integer> nodo7 = new Nodo<Integer>(7, null, null);
		Nodo<Integer> nodo3 = new Nodo<Integer>(3, null, null);
		Nodo<Integer> nodo6 = new Nodo<Integer>(6, null, null);
		boolean val;
		val = prueba.estaVacio();
		if (val) {
			System.out.println("ESTA VACIO");
		} else {
			System.out.println("NO VACIO");
		}
		prueba.insertarPrincipio(nodo5);			// 5
		prueba.insertarDespues(nodo5, nodo1);		// 5 - 1
		prueba.insertarFinal(nodo6); 				// 5 - 1 - 6
		prueba.insertarAntes(nodo1, nodo7);   		// 5 - 7 - 1 - 6
		prueba.insertarPrincipio(nodo9);			// 9 - 5 - 7 - 1 - 6
		prueba.insertarFinal(nodo3); 				// 9 - 5 - 7 - 1 - 6 - 3
		
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		prueba.eliminar(nodo7); 					// 9 - 5 - 1 - 6 - 3
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		prueba.eliminar(nodo1); 					// 9 - 5 - 6 - 3
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		prueba.eliminar(nodo3); 					// 9 - 5 - 6
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		prueba.eliminar(nodo9);						// 5 - 6
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		prueba.eliminar(nodo6);						// 5
		System.out.println(prueba.toString());
		System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		val = prueba.estaVacio();
		if (val) {
			System.out.println("ESTA VACIO");
		} else {
			System.out.println("NO VACIO");
		}
		prueba.eliminar(nodo5); 					// (Vacio)
		System.out.println(prueba.toString());
		//System.out.println("PRIMERO: " + prueba.primero() + ", ULTIMO: " + prueba.ultimo());
		val = prueba.estaVacio();
		if (val) {
			System.out.println("ESTA VACIO");
		} else {
			System.out.println("NO VACIO");
		}
	}
}
