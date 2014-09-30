package br.feevale;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.junit.Assert.*;

public class ListaTest {
    private Lista<String> listaStr;
    private Lista<Integer> listaInt;

    @Before
    public void setUp() {
        this.listaStr = new Lista<String>();
        this.listaInt = new Lista<Integer>();
    }

    @Test
    public void itIsEmpty() {
        assertTrue(listaStr.isEmpty());
    }

    @Test
    public void itHasSize() {
        assertEquals(0, listaStr.size());

        listaStr.add("Foo bar");
        assertEquals(1, listaStr.size());

        listaStr.add("Person 1");
        listaStr.add("Person 2");
        listaStr.add("Person 3");
        assertEquals(4, listaStr.size());
    }

    @Test
    public void itIsNotEmpty() {
        listaStr.add("Foo bar");
        assertFalse(listaStr.isEmpty());
    }

    @Test
    public void itClearsOut() {
        listaStr.add("Foo bar");
        listaStr.add("Foo bar");

        listaStr.clear();
        assertTrue(listaStr.isEmpty());
    }

    @Test
    public void itGetsWhatIsGiven() {
        listaStr.add("Person 1");  //0
        listaStr.add("Person 2");  //1
        listaStr.add("Person 3");  //2

        assertEquals("Person 1", listaStr.get(0));
        assertEquals("Person 2", listaStr.get(1));
        assertEquals("Person 3", listaStr.get(2));
    }

    @Test
    public void itRemoves() {
        listaStr.add("Person 1");  //0
        listaStr.add("Person 2");  //1
        listaStr.add("Person 3");  //2

        assertEquals(3, listaStr.size());

        listaStr.remove(0);
        assertEquals(2, listaStr.size());

        listaStr.remove(1);
        assertEquals(1, listaStr.size());
    }

    @Test
    public void itReturnsWhatRemoves() {
        listaStr.add("Person 1");  //0
        listaStr.add("Person 2");  //1

        assertEquals("Person 2", listaStr.remove(1));
    }

    @Test
    public void itChangeContent() {
        listaStr.add("Person 1");  //0
        listaStr.add("Person 2");  //1
        listaStr.add("Person 3");  //2

        listaStr.set(1, "Person 2 is gone");
        assertEquals("Person 2 is gone", listaStr.get(1));

        listaStr.set(0, "Person 1 is gone too");
        assertEquals("Person 1 is gone too", listaStr.get(0));
    }

    @Test
    public void itContainsItems() {
        String foo = "Foo";
        listaStr.add(foo);
        assertTrue(listaStr.contains(foo));

        Integer bar = 125;
        listaInt.add(bar);
        assertTrue(listaInt.contains(bar));
    }

    @Test
    public void itRemoveItems() {
        String foo = "Foo";
        String bar = "Bar";
        listaStr.add(foo);
        listaStr.add(bar);
        assertEquals(2, listaStr.size());

        assertTrue(listaStr.remove(foo));
        assertEquals(1, listaStr.size());

        Integer baz = 125;
        listaInt.add(baz);
        assertTrue(listaInt.remove(baz));
        assertEquals(0, listaInt.size());
    }

    @Test
    public void itIterateOverElements() {
        listaStr.add("Item 0");
        listaStr.add("Item 1");
        listaStr.add("Item 2");
        listaStr.add("Item 3");
        listaStr.add("Item 4");

        Iterator itr = listaStr.iterator();
        assertTrue(itr instanceof Iterator);

        Integer i = 0; //para compara no loop
        while (itr.hasNext()) {
            String next = (String) itr.next();
            String item = (String) listaStr.get(i);  //próximo

            assertEquals(item, next); //must be the same
            i++;
        }
    }

    @Test
    public void itRemovesFromIterator() {
        Boolean exceptionThrown = false;

        listaStr.add("Item 0");
        listaStr.add("Item 1");

        Iterator itr = listaStr.iterator();

        try {
            itr.remove();
        } catch (IllegalStateException e) {
            assertTrue(e instanceof IllegalStateException);
            exceptionThrown = true;
        }

        assertTrue(exceptionThrown);

        itr.next();
        itr.remove();

        assertEquals(1, listaStr.size());
    }

    @Test
    public void itMakesAnArray() {
        listaInt.add(0);
        listaInt.add(1);
        listaInt.add(2);
        listaInt.add(3);

        Object[] arr = listaInt.toArray();

        //array size must be equal to list size
        assertEquals(listaInt.size(), arr.length);

        //they must have the same contents
        for (Integer i = 0; i < listaInt.size(); i++) {
            assertEquals(listaInt.get(i), arr[i]);
        }
    }
}