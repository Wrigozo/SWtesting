package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleTest {

    @Test
    public void testBalAg() {
        Simple simple = new Simple();
        assertEquals(354, simple.func(354, 400, 300));
    }

    @Test
    public void testKozepAg() {
        Simple simple = new Simple();
        assertEquals(-698, simple.func(698, 400, 300));
    }

    @Test
    public void testJobbAg() {
        Simple simple = new Simple();
        assertEquals(200, simple.func(123, 200, 300));
    }
}