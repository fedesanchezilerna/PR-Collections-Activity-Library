/*
 * LibraryTest.java 2 Feb 2025
 *
 *
 * © Copyright 2025 Joan Sèculi <jseculi@escoladeltreball.org>
 *
 * This is free software, licensed under the GNU General Public License v3.
 * See http://www.gnu.org/licenses/gpl.html for more information.
 */
package library;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibraryTest {

    private Library library;
    private Writer tolkien, rowling, thorne, tiffany, king, straub;
    private Book book2, book3, book4, book5, book6, book7, book8, book9, book10,
            book11, book12, book13, book14, book15, book16;

    @BeforeEach
    void setUp() {
        library = new Library("Library");

        tolkien = new Writer("J.R.R. Tolkien", "03/02/1892", "South-Africa");
        rowling = new Writer("J.K. Rowling", "31/07/1965", "UK");
        thorne = new Writer("J. Thorne", "31/07/1965", "UK");
        tiffany = new Writer("J. Tiffany", "31/07/1965", "UK");
        king = new Writer("Stephen King", "21/09/1947", "US");
        straub = new Writer("Peter Straub", "02/04/1947", "US");

        book2 = new Book("978-84-8181-002-5", "The Hobbit", (short) 1934);
        System.out.println(book2.addWriter(tolkien));
        book3 = new Book("978-84-8181-003-5", "The Fellowship of the Ring", (short) 1954);
        System.out.println(book3.addWriter(tolkien));
        book4 = new Book("978-84-8181-004-5", "The Two Towers", (short) 1957);
        System.out.println(book4.addWriter(tolkien));
        book5 = new Book("978-84-8181-005-5", "The Return of the king", (short) 1959);
        System.out.println(book5.addWriter(tolkien));
        book6 = new Book("978-84-8181-006-5", "The Silmarillion", (short) 1960);
        System.out.println(book6.addWriter(tolkien));
        book7 = new Book("978-84-8181-007-5", "The Children of Húrin", (short) 1965);
        System.out.println(book7.addWriter(tolkien));
        book8 = new Book("978-84-8181-008-5", "Harry Potter and the Sorcerer's Stone", (short) 1997);
        System.out.println(book8.addWriter(rowling));
        book9 = new Book("978-84-8181-009-5", "Harry Potter and the Chamber of Secrets", (short) 1998);
        System.out.println(book9.addWriter(rowling));
        book10 = new Book("978-84-8181-010-5", "Harry Potter and the Prisoner of Azkaban", (short) 1999);
        System.out.println(book10.addWriter(rowling));
        book11 = new Book("978-84-8181-011-5", "Harry Potter and the Goblet of Fire", (short) 2000);
        System.out.println(book11.addWriter(rowling));
        book12 = new Book("978-84-8181-012-5", "Harry Potter and the Order of the Phoenix", (short) 2003);
        System.out.println(book12.addWriter(rowling));
        book13 = new Book("978-84-8181-013-5", "Harry Potter and the Half-Blood Prince", (short) 2005);
        System.out.println(book13.addWriter(rowling));
        book14 = new Book("978-84-8181-014-5", "Harry Potter and the Deathly Hallows", (short) 2007);
        System.out.println(book14.addWriter(rowling));
        book15 = new Book("978-84-8181-015-5", "Harry Potter and the Cursed Child", (short) 2007);
        System.out.println(book15.addWriter(rowling));
        System.out.println(book15.addWriter(thorne));
        System.out.println(book15.addWriter(tiffany));
        book16 = new Book("978-034-544-488-2", "The Talisman", (short) 1984);
        System.out.println(book16.addWriter(king));
        System.out.println(book16.addWriter(straub));

        System.out.println(library.addBook(book2));
        System.out.println(library.addBook(book3));
        System.out.println(library.addBook(book4));
        System.out.println(library.addBook(book5));
        System.out.println(library.addBook(book6));
        System.out.println(library.addBook(book7));
        System.out.println(library.addBook(book8));
        System.out.println(library.addBook(book9));
        System.out.println(library.addBook(book10));
        System.out.println(library.addBook(book11));
        System.out.println(library.addBook(book12));
        System.out.println(library.addBook(book13));
        System.out.println(library.addBook(book14));
        System.out.println(library.addBook(book15));
        System.out.println(library.addBook(book16));
    }

    @Test
    void testAddBook() {
        Book newBook = new Book("978-1-56619-909-4", "New Book", (short) 2024);
        assertTrue(library.addBook(newBook));
        System.out.println(newBook.getCode());
        assertTrue(library.isBookInLibrary("0016"));
    }

//    @Test
//    void testRemoveBook() {
//        assertTrue(library.removeBook(book2));
//        assertFalse(library.isBookInLibrary(book2));
//    }

    @Test
    void testRemoveBook() {
        //System.out.println(book2.getCode());
        //library.getBooks().stream().forEach(System.out::println);
        assertTrue(library.removeBook("0047"));
        assertFalse(library.isBookInLibrary("0047"));
    }
    
/*    @Test
    void testIsBookInLibrary() {
    	//System.out.println(book3.getCode());
       // assertTrue(library.isBookInLibrary(book3));
       // assertFalse(library.isBookInLibrary(new Book("123", "Fake Book", (short) 2000)));
    }*/

    @Test
    void testGetBooksByWriter() {
        Set<Book> booksByRowling = library.getBooksByWriter("Rowling");
        assertEquals(8, booksByRowling.size());
    }

    @Test
    void testGetBooksByTitle() {
        Set<Book> books = library.getBooksByTitle("Harry Potter");
        assertEquals(8, books.size());
    }

    @Test
    void testNumberOfBooks() {
        assertEquals(15, library.numberOfBooks());
    }
}