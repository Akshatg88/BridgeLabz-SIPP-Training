class Book {
    // static
    static String libraryName = "City Central Library";

    // final
    private final String isbn;
    private String title;
    private String author;

    // this
    Book(String title, String author, String isbn) {
        this.title  = title;
        this.author = author;
        this.isbn   = isbn;
    }

    static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }

    void display() {
        if (this instanceof Book) {
            System.out.printf("(%s) %s by %s%n", isbn, title, author);
        }
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book.displayLibraryName();
        Book b1 = new Book("Effective Java", "Joshua Bloch", "9780134685991");
        Book b2 = new Book("Clean Code",      "Robert C. Martin", "9780132350884");
        b1.display();
        b2.display();
    }
}
