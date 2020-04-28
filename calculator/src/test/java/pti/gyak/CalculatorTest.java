package pti.gyak;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculatorTest {

    @Test
    public void testAdd() {
        assertEquals(2.0, (new Calculator()).enter(1).enter(Operation.ADD).enter(1).result);
    }

    @Test
    public void testSubtract() {
        assertEquals(1.0, (new Calculator()).enter(2).enter(Operation.SUBSTRACT).enter(1).result);
    }

    @Test
    public void testMultiply() {
        assertEquals(4.0, (new Calculator()).enter(2).enter(Operation.MULTIPLY).enter(2).result);
    }

    @Test
    public void testDivide() {
        assertEquals(2.5, (new Calculator()).enter(5).enter(Operation.DIVIDE).enter(2).result);
        assertEquals(Double.POSITIVE_INFINITY, (new Calculator()).enter(5).enter(Operation.DIVIDE).enter(0).result);
    }

    @Test
    public void testReminder() {
        assertEquals(2.0, (new Calculator()).enter(5).enter(Operation.REMAINDER).enter(3).result);
    }

    @Test
    public void testPow() {
        assertEquals(16.0, (new Calculator()).enter(4).enter(Operation.POWER).enter(2).result);
    }

    @Test
    public void testClear(){
        assertEquals(0, (new Calculator()).enter(Operation.CLEAR).result);
    }

    @Test
    public void testHistory() {
        assertEquals("5 + 1 = 6", (new Calculator()).enter(5).enter(Operation.ADD).enter(1).getHistory());
    }
}