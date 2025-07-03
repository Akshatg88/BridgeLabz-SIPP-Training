// Book.java
public class Book {
    protected String title;
    protected int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
}

// Author.java
public class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int year, String name, String bio) {
        super(title, year);
        this.name = name;
        this.bio = bio;
    }

    public void displayInfo() {
        System.out.printf("\"%s\" (%d) by %s%nBio: %s%n",
                          title, publicationYear, name, bio);
    }
}

// LibraryDemo.java
public class LibraryDemo {
    public static void main(String[] args) {
        Author a = new Author("Effective Java", 2018,
                              "Joshua Bloch",
                              "Former Java platform architect at Sun.");
        a.displayInfo();
    }
}
