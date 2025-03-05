package library;

import java.util.HashSet;
import java.util.Set;

public class Library {
    private String name;
    private Set<Book> books;

    public Library(String name) {
        this.name = name;
        this.books = new HashSet<>();
    }

    public boolean addBook(Book book) {
        return books.add(book);
    }

    public boolean removeBook(String code) {
        for (Book book : books) {
            if (book.getCode().equals(code)) {
                books.remove(book);
                return true;
            }
        }
        return false;
    }

    public boolean isBookInLibrary(String code) {
        for (Book book : books) {
            if (book.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    public int numberOfBooks() {
        return books.size();
    }

    public Book getBookFromLibrary(String param, boolean isCode) {
        for (Book book : books) {
            if (isCode && book.getCode().equals(param)) {
                return book;
            } else if (!isCode && book.getIsbn().equals(param)) {
                return book;
            }
        }
        return null;
    }

    public Set<Book> getBooksByWriter(String writer) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            for (Writer w : book.getWriters()) {
                if (w.getName().toLowerCase().contains(writer.toLowerCase())) {
                    result.add(book);
                    break; // don't need to search any further in this book
                }
            }
        }
        return result;
    }

    public Set<Book> getBooksByTitle(String title) {
        Set<Book> result = new HashSet<>();
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(book);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("NAME: " + name + "\n");
        sb.append("CODE  ISBN                TITLE                                         WRITERS                              YEAR\n");
        sb.append("--------------------------------------------------------------------------------------------------------------------\n");
        for (Book book : books) {
            sb.append(book).append("\n");
        }
        return sb.toString();
    }
}
