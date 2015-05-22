package test;

import static org.junit.Assert.*;
import lista.ListaDoblementeEnlazada;
import lista.ListaDoblementeEnlazada.Nodo;

import org.junit.Test;

public class ListaDoblementeEnlazadaTest {

    @Test
    public void test1() {
        ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
        Nodo<Integer> nodo = new Nodo<Integer>(1, null, null);
    }

}
