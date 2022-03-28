package com.example.utility;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class Vector2DTest {

    @Test
    public void testEquals() {
        Vector2D vec1 = new Vector2D(3, 1);
        Vector2D vec2 = new Vector2D(3, 1);

        assertTrue(vec1.equals(vec2));

        vec2 = new Vector2D(3, 3);

        assertFalse(vec1.equals(vec2));
    }
    
    @Test
    public void testTranslate() {
        Vector2D vec = new Vector2D();

        vec.translate(10, 15);

        assertEquals(10, vec.getX());
        assertEquals(15, vec.getY());

        vec = new Vector2D(4, 3);

        vec.translate(-2, -3);

        assertEquals(2, vec.getX());
        assertEquals(0, vec.getY());

        vec = new Vector2D(1, -3);

        vec.translate(-10, -2);

        assertEquals(-9, vec.getX());
        assertEquals(-5, vec.getY());
    }
}
