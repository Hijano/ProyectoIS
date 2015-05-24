package lista;

import static org.junit.Assert.*;
import lista.ListaDoblementeEnlazada.Nodo;

import org.junit.Test;

public class ListaDoblementeEnlazadaTest {
  // constructor
  //
  //
  //
  //
  //
  //
  @Test
  public <T> void constructorDevuelveUnaInstanciaDeListaDoblementeEnlazada() {
    assertTrue((new ListaDoblementeEnlazada<T>()) instanceof ListaDoblementeEnlazada);
  }

  // estaVacia
  //
  //
  //
  //
  //
  //
  @Test
  public <T> void constructorDevuelveUnaListaVacia() {
    assertTrue((new ListaDoblementeEnlazada<T>()).estaVacio());
  }

  @Test
  public void siLaListaTieneAlgunElementoEntoncesNoEstaVacia() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(new Nodo<Integer>(4, null, null));
    assertFalse(lista.estaVacio());
  }

  // InsertarDespués
  //
  //
  //
  //
  //
  //
  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoDespuesDeUnNodoNuloSeDeberiaLanzarUnaExcepcion() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarDespues(null, nodoNuevo);
  }

  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoNuloDespuesDeUnNodoSeDeberiaLanzarUnaExcepcion() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarDespues(nodoNuevo, null);
  }

  @Test
  public void siSeInsertaUnNodoDespuesDelUltimoElNodoInsertadoEsElUltimoDeLaLista() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodo);
    lista.insertarDespues(nodo, nodoNuevo);
    assertNull(nodoNuevo.siguiente);
    assertNotNull(nodo.siguiente);
    assertEquals(lista.ultimo(), nodoNuevo.elemento);

  }

  @Test
  public void siSeInsertaUnNodoDespuesDeOtroQueNoEsElUltimoSeInsertaBien() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    Nodo<Integer> nodoSiguienteAntiguo = new Nodo<Integer>(5, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarFinal(nodoSiguienteAntiguo);
    lista.insertarAntes(nodoSiguienteAntiguo, nodo);
    lista.insertarDespues(nodo, nodoNuevo);
    assertSame(nodoSiguienteAntiguo.anterior, nodoNuevo);
    assertSame(nodoNuevo.siguiente, nodoSiguienteAntiguo);
    assertSame(nodoNuevo.anterior, nodo);
    assertSame(nodo.siguiente, nodoNuevo);
  }

  // InsertarAntes
  //
  //
  //
  //
  //
  //
  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoAntesDeUnNodoNuloSeDeberiaLanzarUnaExcepcion() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarAntes(null, nodoNuevo);
  }

  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoNuloAntesDeUnNodoSeDeberiaLanzarUnaExcepcion() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarAntes(nodoNuevo, null);
  }

  @Test
  public void siSeInsertaUnNodoAntesDelPrimeroElNodoInsertadoEsElPrimeroDeLaLista() {
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodo);
    lista.insertarAntes(nodo, nodoNuevo);
    assertNull(nodoNuevo.anterior);
    assertNotNull(nodo.anterior);
    assertEquals(lista.primero(), nodoNuevo.elemento);
  }

  @Test
  public void siSeInsertaUnNodoAntesDeOtroNodoQueNoEsElPrimeroSeInsertaBien() {
    Nodo<Integer> nodoAnteriorAntiguo = new Nodo<Integer>(2, null, null);
    Nodo<Integer> nodoNuevo = new Nodo<Integer>(4, null, null);
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodoAnteriorAntiguo);
    lista.insertarDespues(nodoAnteriorAntiguo, nodo);
    lista.insertarAntes(nodo, nodoNuevo);
    assertSame(nodoNuevo.anterior, nodoAnteriorAntiguo);
    assertSame(nodoAnteriorAntiguo.siguiente, nodoNuevo);
    assertSame(nodoNuevo.siguiente, nodo);
    assertSame(nodo.anterior, nodoNuevo);
  }

  // insertarPrincipio
  //
  //
  //
  //
  //
  //
  @Test
  public void siSeInsertaAlPrincipioDeUnaListaVaciaEsElPrimeroDeLaListaYElUltimo() {
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodo);
    assertEquals(lista.primero(), nodo.elemento);
    assertSame(lista.ultimo(), nodo.elemento);

  }

  @Test
  public void siSeInsertaAlPrincipioDeUnaListaNoVaciaEsElPrimeroDeLaListaYSeInsertaBien() {
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    Nodo<Integer> nodoPrimero = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodoPrimero);
    lista.insertarPrincipio(nodo);
    assertEquals(lista.primero(), nodo.elemento);
    assertSame(nodoPrimero.anterior, nodo);
    assertSame(nodo.siguiente, nodoPrimero);
  }

  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoNuloAlPrincipioDeUnaListaSeLanzaUnaExcepcion() {
    Nodo<Integer> nodo = null;
    Nodo<Integer> nodoPrimero = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodoPrimero);
    lista.insertarPrincipio(nodo);
  }

  // insertarFinal
  //
  //
  //
  //
  //
  //
  @Test
  public void siSeInsertaAlFinalDeUnaListaVaciaEsElPrimeroDeLaListaYElUltimo() {
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarFinal(nodo);
    assertEquals(lista.primero(), nodo.elemento);
    assertSame(lista.ultimo(), nodo.elemento);

  }

  @Test
  public void siSeInsertaAlFinalDeUnaListaNoVaciaEsElUltimoDeLaListaYSeInsertaBien() {
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    Nodo<Integer> nodoPrimero = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodoPrimero);
    lista.insertarFinal(nodo);
    assertEquals(lista.ultimo(), nodo.elemento);
    assertSame(nodoPrimero.siguiente, nodo);
    assertSame(nodo.anterior, nodoPrimero);
  }

  @Test(expected = Exception.class)
  public void siSeInsertaUnNodoNuloAlFinalDeUnaListaSeLanzaUnaExcepcion() {
    Nodo<Integer> nodo = null;
    Nodo<Integer> nodoPrimero = new Nodo<Integer>(4, null, null);
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.insertarPrincipio(nodoPrimero);
    lista.insertarFinal(nodo);
  }

  // primero
  //
  //
  //
  //
  //
  //
  @Test(expected = Exception.class)
  public void siLaListaEstaVaciaPrimeroDeberiaLanzarUnaExcepcion() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.primero();
  }

  @Test
  public void siLaListaTieneUnElementoElPrimeroEsElPrimero() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarPrincipio(nodo);
    assertEquals(lista.primero(), nodo.elemento);
  }

  @Test
  public void siLaListaTieneVariosElementosElPrimeroEsElPrimero() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarPrincipio(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarDespues(nodo, new Nodo<Integer>(i, null, null));

    }
    assertEquals(lista.primero(), nodo.elemento);
  }

  // ultimo
  //
  //
  //
  //
  //
  //

  @Test(expected = Exception.class)
  public void siLaListaEstaVaciaUltimoDeberiaLanzarUnaExcepcion() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    lista.ultimo();
  }

  @Test
  public void siLaListaTieneUnElementoEseElementoEsElUltimo() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    assertEquals(lista.ultimo(), nodo.elemento);
  }

  @Test
  public void siLaListaTieneVariosElementosElUltimoEsElUltimo() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarAntes(nodo, new Nodo<Integer>(i, null, null));

    }
    assertEquals(lista.ultimo(), nodo.elemento);
  }

  // eliminar
  //
  //
  //
  //
  //
  //
  @Test
  public void siSeBorraElNodoDeUnaListaConUnElementoLaListaQuedaVacia() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    lista.eliminar(nodo);
    assertTrue(lista.estaVacio());
  }

  @Test
  public void siSeBorraElPrimeroElNuevoPrimeroEsElSiguiente() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarPrincipio(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarDespues(nodo, new Nodo<Integer>(i, null, null));

    }
    Nodo<Integer> nuevoPrimero = nodo.siguiente;
    lista.eliminar(nodo);
    assertEquals(lista.primero(), nuevoPrimero.elemento);
  }

  @Test
  public void siSeBorraElUltimoElNuevoUltimoEsElAnterior() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarAntes(nodo, new Nodo<Integer>(i, null, null));

    }
    Nodo<Integer> nuevoUltimo = nodo.anterior;
    lista.eliminar(nodo);
    assertEquals(lista.ultimo(), nuevoUltimo.elemento);
  }

  @Test
  public void siSeBorraUnElementoQueNoEsNiElPrimeroNiElUltimoSeBorraBien() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarAntes(nodo, new Nodo<Integer>(i, null, null));
      lista.insertarDespues(nodo, new Nodo<Integer>(-i, null, null));
    }
    Nodo<Integer> nodoAnterior = nodo.anterior;
    Nodo<Integer> nodoSiguiente = nodo.siguiente;
    lista.eliminar(nodo);
    assertSame(nodoAnterior.siguiente, nodoSiguiente);
    assertSame(nodoSiguiente.anterior, nodoAnterior);
  }

  /*
   * @Test public void siSeBorraUnElementoQueNoEstaLaListaQuedaIgual(){
   * ListaDoblementeEnlazada<Integer> lista = new
   * ListaDoblementeEnlazada<Integer>(); ListaDoblementeEnlazada<Integer>
   * listaAntes = new ListaDoblementeEnlazada<Integer>(); Nodo<Integer> nodo =
   * new Nodo<Integer>(3,null,null); lista.insertarFinal(nodo);
   * listaAntes.insertarFinal(nodo); for (int i = 5; i<12;i++) {
   * lista.insertarAntes(nodo, new Nodo<Integer>(i,null,null));
   * lista.insertarDespues(nodo, new Nodo<Integer>(-i,null,null));
   * listaAntes.insertarAntes(nodo, new Nodo<Integer>(i,null,null));
   * listaAntes.insertarDespues(nodo, new Nodo<Integer>(-i,null,null)); }
   * lista.eliminar(new Nodo<Integer>(null,null,null));
   * assertEquals(listaAntes,lista); }
   */
  @Test
  public void siSeBorraUnNodoNuloLaListaQuedaIgual() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    Nodo<Integer> nodo = new Nodo<Integer>(3, null, null);
    lista.insertarFinal(nodo);
    for (int i = 5; i < 12; i++) {
      lista.insertarAntes(nodo, new Nodo<Integer>(i, null, null));
      lista.insertarDespues(nodo, new Nodo<Integer>(-i, null, null));
    }
    String listaAntes = lista.toString();
    lista.eliminar(null);
    String listaDespues = lista.toString();
    assertEquals(listaAntes, listaDespues);
  }

  // toString
  //
  //
  //
  //
  //
  @Test
  public void siLaListaEsVaciaToStringSePintaUnaListaVacia() {
    String st = "Lista: ()";
    assertEquals(st, (new ListaDoblementeEnlazada<Integer>()).toString());
  }

  @Test
  public void siLaListaNoEsVaciaToStringPintaLosNodosEnSuOrden() {
    ListaDoblementeEnlazada<Integer> lista = new ListaDoblementeEnlazada<Integer>();
    StringBuilder sb = new StringBuilder("Lista: (");
    for (int i = 0; i < 10; i++) {
      lista.insertarFinal(new Nodo<Integer>(i, null, null));
      sb.append(i).append(",");
    }

    lista.insertarFinal(new Nodo<Integer>(10, null, null));
    sb.append(10).append(")");
    assertEquals(sb.toString(), lista.toString());
  }

  @SuppressWarnings("null")
  @Test(expected = Exception.class)
  public void siLaListaEsNulaToStringLanzaUnaExcepcion() {
    ListaDoblementeEnlazada<Integer> lista = null;
    String cad = "Lista: ()";
    assertEquals(cad, lista.toString());
  }

  @Test
  public void unaListaVaciaEsIgualAOtraListaVacia() {
    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
    assertEquals(lista1, lista2);
  }

  @Test
  public void unaListaVaciaNoEsIgualAOtraListaNoVacia() {

    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
    lista2.insertarPrincipio(new Nodo<Integer>(3, null, null));
    assertNotEquals(lista1, lista2);
  }

  @Test
  public void unaListaEsIgualAOtraSiTienenLosMismosElementosYEnElMismoOrden() {
    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
    lista1.insertarPrincipio(new Nodo<Integer>(3, null, null));
    lista2.insertarPrincipio(new Nodo<Integer>(3, null, null));
    assertEquals(lista1, lista2);
  }

  @Test
  public void unaListaNoEsIgualAOtraSiFaltaAlgúnElemento() {
    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
    for (int i = 0; i < 5; i++) {
      lista1.insertarPrincipio(new Nodo<Integer>(3, null, null));
    }
    for (int i = 0; i < 4; i++) {
      lista2.insertarPrincipio(new Nodo<Integer>(3, null, null));
    }
    assertNotEquals(lista1, lista2);
  }

  @Test
  public void unaListaNoEsIgualAOtraSiLosElementosNoEstanEnElMismoOrden() {
    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    ListaDoblementeEnlazada<Integer> lista2 = new ListaDoblementeEnlazada<Integer>();
    for (int i = 0; i < 5; i++) {
      lista1.insertarPrincipio(new Nodo<Integer>(i, null, null));
    }
    for (int i = 0; i < 5; i++) {
      lista2.insertarFinal(new Nodo<Integer>(i, null, null));
    }
    assertNotEquals(lista1, lista2);
  }

  @Test
  public void unaListaNoEsIgualAUnEntero() {
    ListaDoblementeEnlazada<Integer> lista1 = new ListaDoblementeEnlazada<Integer>();
    Integer lista2 = 2;
    assertNotEquals(lista1, lista2);
  }

  @Test
  public void elConstructorVacioDeExcepcionesDevuelveUnaInstanciaDeLaClase() {
    ListaDoblementeEnlazadaException l = new ListaDoblementeEnlazadaException();
    assertTrue(l instanceof ListaDoblementeEnlazadaException);
  }

  @Test
  public void elConstructorDeExcepcionesDevuelveUnaInstanciaDeLaClase() {
    ListaDoblementeEnlazadaException l = new ListaDoblementeEnlazadaException(
        "mensaje");
    assertTrue(l instanceof ListaDoblementeEnlazadaException);
  }
}
