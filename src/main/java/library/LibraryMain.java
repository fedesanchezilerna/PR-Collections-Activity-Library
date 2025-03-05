package library;

import java.util.Scanner;
import java.util.Set;
import java.util.HashSet;

public class LibraryMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // data.txt
        Library library = new Library("Library");

        Writer tolkien = new Writer("J.R.R. Tolkien", "03/02/1892", "South-Africa");
        // System.out.println(writer1);
        Writer rowling = new Writer("J.K. Rowling", "31/07/1965", "UK");
        Writer thorne = new Writer("J. Thorne", "31/07/1965", "UK");
        Writer tiffany = new Writer("J. Tiffany", "31/07/1965", "UK");
        Writer king = new Writer("Stephen King", "21/09/1947", "US");
        Writer straub = new Writer("Peter Straub", "02/04/1947", "US");
        Writer straub2 = new Writer("Peter Straub", "02/04/1947", "US");

        Book book2 = new Book("978-84-8181-002-5", "The Hobbit", (short) 1934);
        System.out.println(book2.addWriter(tolkien));

        Book book3 = new Book("978-84-8181-003-5", "The Fellowship of the Ring", (short) 1954);
        System.out.println(book3.addWriter(tolkien));

        Book book4 = new Book("978-84-8181-004-5", "The Two Towers", (short) 1957);
        System.out.println(book4.addWriter(tolkien));

        Book book5 = new Book("978-84-8181-005-5", "The Return of the king", (short) 1959);
        System.out.println(book5.addWriter(tolkien));

        Book book6 = new Book("978-84-8181-006-5", "The Silmarillion", (short) 1960);
        System.out.println(book6.addWriter(tolkien));

        Book book7 = new Book("978-84-8181-007-5", "The Children of H�rin", (short) 1965);
        System.out.println(book7.addWriter(tolkien));

        Book book8 = new Book("978-84-8181-008-5", "Harry Potter and the Sorcerer's Stone", (short) 1997);
        System.out.println(book8.addWriter(rowling));

        Book book9 = new Book("978-84-8181-009-5", "Harry Potter and the Chamber of Secrets", (short) 1998);
        System.out.println(book9.addWriter(rowling));

        Book book10 = new Book("978-84-8181-010-5", "Harry Potter and the Prisoner of Azkaban", (short) 1999);
        System.out.println(book10.addWriter(rowling));

        Book book11 = new Book("978-84-8181-011-5", "Harry Potter and the Goblet of Fire", (short) 2000);
        System.out.println(book11.addWriter(rowling));

        Book book12 = new Book("978-84-8181-012-5", "Harry Potter and the Order of the Phoenix", (short) 2003);
        System.out.println(book12.addWriter(rowling));

        Book book13 = new Book("978-84-8181-013-5", "Harry Potter and the Half-Blood Prince", (short) 2005);
        System.out.println(book13.addWriter(rowling));

        Book book14 = new Book("978-84-8181-014-5", "Harry Potter and the Deathly Hallows", (short) 2007);
        System.out.println(book14.addWriter(rowling));

        Book book15 = new Book("978-84-8181-015-5", "Harry Potter and the Cursed Child", (short) 2007);
        System.out.println(book15.addWriter(rowling));
        System.out.println(book15.addWriter(thorne));
        System.out.println(book15.addWriter(tiffany));

        Book book16 = new Book("978-034-544-488-2", "The Talisman", (short) 1984);
        System.out.println(book16.addWriter(king));
        System.out.println(book16.addWriter(straub));

        // library.addBook(book1);
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

        int option;
        do {
            System.out.println("\nMENU" +
                               "\n1. LIST ALL BOOKS" +
                               "\n2. ADD BOOK" +
                               "\n3. REMOVE BOOK" +
                               "\n4. SEARCH BOOK" +
                               "\n5. NUMBER OF BOOKS" +
                               "\n6. GET BOOK FROM LIBRARY" +
                               "\n7. GET BOOKS BY TITLE" +
                               "\n8. GET BOOKS BY WRITER" +
                               "\n0. QUIT");
            System.out.print("CHOOSE MENU OPTION: ");
            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    // List all books.
                    System.out.println(library);
                    break;
                case 2:
                    // Add a book to the bookstore, ask how many writers it contains to know how
                    // many writers you have to enter by keyboard.
                    System.out.print("ENTER ISBN: ");
                    String isbn = scanner.nextLine();
                    System.out.print("ENTER TITLE: ");
                    String title = scanner.nextLine();
                    System.out.print("ENTER YEAR: ");
                    short year = scanner.nextShort();
                    scanner.nextLine();

                    Set<Writer> writers = new HashSet<>();
                    System.out.print("ENTER NUMBER OF WRITERS: ");
                    int numWriters = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < numWriters; i++) {
                        System.out.print("ENTER NAME OF WRITER: ");
                        String name = scanner.nextLine();
                        System.out.print("ENTER BIRTH DATE: ");
                        String birthDate = scanner.nextLine();
                        System.out.print("ENTER COUNTRY: ");
                        String country = scanner.nextLine();
                        writers.add(new Writer(name, birthDate, country));
                    }

                    Book book = new Book(isbn, title, writers, year);
                    System.out.println("BOOK ADDED: " + library.addBook(book));
                    break;
                case 3:
                    // Delete a book.
                    System.out.print("ENTER CODE TO REMOVE: ");
                    String code = scanner.nextLine();
                    System.out.println("BOOK REMOVED: " + library.removeBook(code));
                    break;
                case 4:
                    // Search for a book by its code.
                    System.out.print("ENTER CODE BOOK: ");
                    String codeBook = scanner.nextLine();
                    System.out.println("BOOK IS IN THE LIBRARY: " + library.isBookInLibrary(codeBook));
                    break;
                case 5:
                    System.out.println("NUMBER OF BOOKS");
                    System.out.println("NUMBER OF BOOKS IN LIBRARY: " + library.numberOfBooks());
                    break;
                case 6:
                    // Search for a book by code or isbn . If found, display it to the console.
                    System.out.println("1: SEARCH BY CODE, 2: SEARCH BY ISBN ? 1");
                    int searchOption = scanner.nextInt();
                    scanner.nextLine();
                    if (searchOption == 1) {
                        System.out.print("ENTER CODE BOOK: ");
                        String codeBook2 = scanner.nextLine();
                        System.out.println("BOOK FOUND: " + library.getBookFromLibrary(codeBook2, true));
                    } else if (searchOption == 2) {
                        System.out.print("ENTER ISBN BOOK: ");
                        String isbnBook = scanner.nextLine();
                        System.out.println("BOOK FOUND: " + library.getBookFromLibrary(isbnBook, false));
                    } else {
                        // System.out.println(1);
                        System.out.println("INVALID OPTION");
                    }
                    break;
                case 7:
                    // Search all books by title (considers that the user can enter the incomplete
                    // book title, in lowercase or uppercase).
                    System.out.println("GET BOOKS BY TITLE");
                    System.out.print("ENTER TITLE: ");
                    String titleBook = scanner.nextLine();
                    Set<Book> matchBooksByTitle = library.getBooksByTitle(titleBook);
                    if (matchBooksByTitle.isEmpty()) {
                        System.out.println("NO BOOKS FOUND");
                    } else {
                        for (Book matchBook : matchBooksByTitle) {
                            System.out.println(matchBook);
                        }
                    }
                    break;
                case 8:
                    // Search all books by title (considers that the user can enter the incomplete
                    // book title, in lowercase or uppercase).
                    System.out.print("ENTER THE NAME OF THE WRITER: ");
                    String writerName = scanner.nextLine();
                    Set<Book> matchBooksByWriter = library.getBooksByWriter(writerName);
                    if (matchBooksByWriter.isEmpty()) {
                        System.out.println("NO BOOKS FOUND");
                    } else {
                        for (Book matchBook : matchBooksByWriter) {
                            System.out.println(matchBook);
                        }
                    }
                    break;
                case 0:
                    System.out.println("EXITING...");
                    break;
                default:
                    System.out.println("INVALID OPTION.");
            }
        } while (option != 0);

        scanner.close();
    }
}
