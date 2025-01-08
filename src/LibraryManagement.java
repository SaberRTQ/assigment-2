import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Main Class
public class LibraryManagement {
    public static void main(String[] args) {
        // Create a Library
        Library library = new Library();

        // Add books to the library
        library.addBook(new Book("1984", "George Orwell"));
        library.addBook(new Book("To Kill a Mockingbird", "Harper Lee"));
        library.addBook(new Book("The Great Gatsby", "F. Scott Fitzgerald"));

        // Add members to the library
        library.addMember(new LibraryMember("John Doe", 1));
        library.addMember(new LibraryMember("Jane Smith", 2));
        library.addMember(new LibraryMember("Emily Johnson", 3));

        // Display all books
        System.out.println("--- All Books ---");
        library.displayBooks();

        // Search for a book by title
        System.out.println("\n--- Search Book by Title: '1984' ---");
        library.searchBookByTitle("1984");

        // Filter books by author
        System.out.println("\n--- Filter Books by Author: 'George Orwell' ---");
        library.filterBooksByAuthor("George Orwell");

        // Sort books by title
        System.out.println("\n--- Sorted Books by Title ---");
        library.sortBooksByTitle();

        // Display all members
        System.out.println("\n--- All Members ---");
        library.displayMembers();
    }
}

// Abstract Class for Entities
abstract class LibraryEntity {
    private String name;

    public LibraryEntity(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Name: " + name;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        LibraryEntity that = (LibraryEntity) obj;
        return name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}

// Book Class
class Book extends LibraryEntity {
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return super.toString() + ", Author: " + author;
    }
}

// LibraryMember Class
class LibraryMember extends LibraryEntity {
    private int memberId;

    public LibraryMember(String name, int memberId) {
        super(name);
        this.memberId = memberId;
    }

    public int getMemberId() {
        return memberId;
    }

    @Override
    public String toString() {
        return super.toString() + ", Member ID: " + memberId;
    }
}

// Library Class
class Library {
    private List<Book> books = new ArrayList<>();
    private List<LibraryMember> members = new ArrayList<>();

    // Add a book
    public void addBook(Book book) {
        books.add(book);
    }

    // Add a library member
    public void addMember(LibraryMember member) {
        members.add(member);
    }

    // Display all books
    public void displayBooks() {
        books.forEach(System.out::println);
    }

    // Display all members
    public void displayMembers() {
        members.forEach(System.out::println);
    }

    // Search for a book by title
    public void searchBookByTitle(String title) {
        books.stream()
                .filter(book -> book.getName().equalsIgnoreCase(title))
                .forEach(System.out::println);
    }

    // Filter books by author
    public void filterBooksByAuthor(String author) {
        books.stream()
                .filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .forEach(System.out::println);
    }

    // Sort books by title
    public void sortBooksByTitle() {
        books.stream()
                .sorted(Comparator.comparing(Book::getName))
                .forEach(System.out::println);
    }
}
