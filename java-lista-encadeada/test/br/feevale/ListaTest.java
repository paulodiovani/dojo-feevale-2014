package br.feevale;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ListaTest {
    private Lista<String> lista;

    @Before
    public void setUp() {
        this.lista = new Lista<String>();
    }

    @Test
    public void itIsEmpty() {
        assertTrue(lista.isEmpty());
    }

    @Test
    public void itHasSize() {
        assertEquals(0, lista.size());

        lista.add("Foo bar");
        assertEquals(1, lista.size());

        lista.add("Person 1");
        lista.add("Person 2");
        lista.add("Person 3");
        assertEquals(4, lista.size());
    }

    @Test
    public void itIsNotEmpty() {
        lista.add("Foo bar");
        assertFalse(lista.isEmpty());
    }

    @Test
    public void itClearsOut() {
        lista.add("Foo bar");
        lista.add("Foo bar");

        lista.clear();
        assertTrue(lista.isEmpty());
    }

    @Test
    public void itGetsWhatIsGiven() {
        lista.add("Person 1");  //0
        lista.add("Person 2");  //1
        lista.add("Person 3");  //2

        assertEquals("Person 1", lista.get(0));
        assertEquals("Person 2", lista.get(1));
        assertEquals("Person 3", lista.get(2));
    }

    @Test
    public void itRemoves() {
        lista.add("Person 1");  //0
        lista.add("Person 2");  //1
        lista.add("Person 3");  //2

        assertEquals(3, lista.size());

        lista.remove(0);
        assertEquals(2, lista.size());

        lista.remove(1);
        assertEquals(1, lista.size());
    }

    @Test
    public void itReturnsWhatRemoves() {
        lista.add("Person 1");  //0
        lista.add("Person 2");  //1

        assertEquals("Person 2", lista.remove(1));
    }

    @Test
    public void itChangeContent() {
        lista.add("Person 1");  //0
        lista.add("Person 2");  //1
        lista.add("Person 3");  //2

        lista.set(1, "Person 2 is gone");
        assertEquals("Person 2 is gone", lista.get(1));

        lista.set(0, "Person 1 is gone too");
        assertEquals("Person 1 is gone too", lista.get(0));
    }
}