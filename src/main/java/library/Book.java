package library;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Book {
    private static int idNext = 1;
    private String code;
    private String isbn;
    private String title;
    private Set<Writer> writers;
    private short year;

    public Book(String isbn, String title, Set<Writer> writers, short year) {
        this.code = String.format("%04d", idNext++);
        this.isbn = isbn;
        this.title = title;
        this.writers = writers;
        this.year = year;
    }

    // Constructor chaining
    public Book(String isbn, String title, short year) {
//        this.code = String.format("%04d", idNext++);
//        this.isbn = isbn;
//        this.title = title;
//        this.writers = new HashSet<>();
//        this.year = year;
        this(isbn, title, new HashSet<>(), year);
    }

    public String getCode() { return code; }
    public String getIsbn() { return isbn; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public Set<Writer> getWriters() { return writers; }
    public void setWriters(Set<Writer> writers) { this.writers = writers; }
    public short getYear() { return year; }
    public void setYear(short year) { this.year = year; }

    public boolean addWriter(Writer writer) {
        return writers.add(writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book book = (Book) obj;
        return code.equals(book.code);
    }

    @Override
    public String toString() {
        String authors = String.join(", ", writers.stream().map(Writer::getName).toArray(String[]::new));
        
        //StringBuilder authorBuilder = new StringBuilder();
        //for (Writer writer : writers) {
        //    if (authorBuilder.length() > 0) {
        //        authorBuilder.append(", ");
        //    }
        //    authorBuilder.append(writer.getName());
        //}
        //String authors = authorBuilder.toString();
        
        return String.format("%-6S%-20S%-45S%-40S%-5d", code, isbn, title, authors, year);
    }
}
