/*
 * WriterTest.java 2 Feb 2025
 *
 *
 * © Copyright 2025 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WriterTest {
    private Writer tolkien;
    private Writer rowling;
    private Writer thorne;
    private Writer tiffany;
    private Writer king;
    private Writer straub;
    private Writer straub2;

    @BeforeEach
    void setUp() {
        tolkien = new Writer("J.R.R. Tolkien", "03/02/1892", "South-Africa");
        rowling = new Writer("J.K. Rowling", "31/07/1965", "UK");
        thorne = new Writer("J. Thorne", "31/07/1965", "UK");
        tiffany = new Writer("J. Tiffany", "31/07/1965", "UK");
        king = new Writer("Stephen King", "21/09/1947", "US");
        straub = new Writer("Peter Straub", "02/04/1947", "US");
        straub2 = new Writer("Peter Straub", "02/04/1947", "US");
    }

    @Test
    void testGetName() {
        assertEquals("J.R.R. Tolkien", tolkien.getName());
        assertEquals("J.K. Rowling", rowling.getName());
    }

    @Test
    void testGetDateBirth() {
        assertEquals("03/02/1892", tolkien.getDateBirth());
        assertEquals("31/07/1965", rowling.getDateBirth());
    }

    @Test
    void testGetCountryOfBirth() {
        assertEquals("South-Africa", tolkien.getCountryOfBirth());
        assertEquals("UK", rowling.getCountryOfBirth());
    }

    @Test
    void testSetName() {
        tolkien.setName("John Ronald Reuel Tolkien");
        assertEquals("John Ronald Reuel Tolkien", tolkien.getName());
    }

    @Test
    void testEquals() {
        assertTrue(straub.equals(straub2));
        assertFalse(king.equals(rowling));
    }

    @Test
    void testHashCode() {
        //System.out.println(straub.hashCode());
        //System.out.println(straub2.hashCode());
        assertEquals(straub.hashCode(), straub2.hashCode());
    }

    @Test
    void testToString() {
        assertNotNull(tolkien.toString());
        assertNotNull(rowling.toString());
    }
}