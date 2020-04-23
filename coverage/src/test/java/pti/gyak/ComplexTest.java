package pti.gyak;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ComplexTest {

    @Test
    public void testBalAg() {
        Complex complex = new Complex();
        assertEquals(354, complex.func(354, 400, 300));
    }

    @Test
    public void testBalKozepAg() {
        Complex complex = new Complex();
        assertEquals(-698, complex.func(698, 400, 300));
    }

    @Test
    public void testJobbKozepAg() {
        Complex complex = new Complex();
        assertEquals(200, complex.func(200, 500, 200));
    }

    @Test
    public void testJobbAg() {
        Complex complex = new Complex();
        assertEquals(200, complex.func(200, 200, 500));
    }
}