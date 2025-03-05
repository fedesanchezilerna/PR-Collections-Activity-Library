package library;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;

class BookTest {
    private Writer tolkien;
    private Writer rowling;
    private Writer thorne;
    private Writer tiffany;
    private Writer king;
    private Writer straub;
    private Book book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13, book14, book15, book16;

    @BeforeEach
    void setUp() {
        tolkien = new Writer("J.R.R. Tolkien", "03/02/1892", "South-Africa");
        rowling = new Writer("J.K. Rowling", "31/07/1965", "UK");
        thorne = new Writer("J. Thorne", "31/07/1965", "UK");
        tiffany = new Writer("J. Tiffany", "31/07/1965", "UK");
        king = new Writer("Stephen King", "21/09/1947", "US");
        straub = new Writer("Peter Straub", "02/04/1947", "US");

        book2 = new Book("978-84-8181-002-5", "The Hobbit", (short) 1934);
        book2.addWriter(tolkien);

        book3 = new Book("978-84-8181-003-5", "The Fellowship of the Ring", (short) 1954);
        book3.addWriter(tolkien);

        book4 = new Book("978-84-8181-004-5", "The Two Towers", (short) 1957);
        book4.addWriter(tolkien);

        book5 = new Book("978-84-8181-005-5", "The Return of the King", (short) 1959);
        book5.addWriter(tolkien);

        book6 = new Book("978-84-8181-006-5", "The Silmarillion", (short) 1960);
        book6.addWriter(tolkien);

        book7 = new Book("978-84-8181-007-5", "The Children of Hurin", (short) 1965);
        book7.addWriter(tolkien);

        book8 = new Book("978-84-8181-008-5", "Harry Potter and the Sorcerer's Stone", (short) 1997);
        book8.addWriter(rowling);

        book15 = new Book("978-84-8181-015-5", "Harry Potter and the Cursed Child", (short) 2007);
        book15.addWriter(rowling);
        book15.addWriter(thorne);
        book15.addWriter(tiffany);

        book16 = new Book("978-034-544-488-2", "The Talisman", (short) 1984);
        book16.addWriter(king);
        book16.addWriter(straub);
    }

    @Test
    void testBookCreation() {
        assertEquals("978-84-8181-002-5", book2.getIsbn());
        assertEquals("The Hobbit", book2.getTitle());
        assertEquals(1934, book2.getYear());
    }

    @Test
    void testAddingWriters() {
        assertTrue(book15.getWriters().contains(thorne));
        assertTrue(book15.getWriters().contains(rowling));
        assertTrue(book15.getWriters().contains(tiffany));
    }

    @Test
    void testEqualsAndHashCode() {
        Book duplicate = new Book("978-84-8181-002-5", "The Hobbit", (short) 1934);
        duplicate.addWriter(tolkien);
        assertNotEquals(book2, duplicate); // Els codis són únics
    }

    @Test
    void testToString() {
        String expected = String.format("%-6S%-20S%-45S%-40S%-5d", book2.getCode(), book2.getIsbn(), book2.getTitle(), "J.R.R. Tolkien", book2.getYear());
        assertTrue(book2.toString().contains(expected));
    }
}