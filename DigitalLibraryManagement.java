import java.util.*;
class Book {
    int BookId;
    String Title;
    String Author;
    boolean IsIssued;
    public Book(int bookId, String title, String author) {
        this.BookId = bookId;
        this.Title = title;
        this.Author = author;
        this.IsIssued = false;
    }
    @Override
    public String toString() {
        return "Book ID: " + BookId + ", Title: " + Title + ", Author: " + Author + ", Issued: " + (IsIssued ? "Yes" : "No");
    }
}
class User {
    int UserId;
    String name;
    public User(int UserId, String name) {
        this.UserId = UserId;
        this.name = name;
    }
    @Override
    public String toString() {
        return "User ID: " + UserId + ", Name: " + name;
    }
}
public class DigitalLibraryManagement {
    private static Map<Integer, Book> books = new HashMap<>();
    private static Map<Integer, User> users = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("\nWelcome to Digital Library Management System:");
        while (true) {
            System.out.println("----------------------------");
            System.out.println("\n1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Add User");
            System.out.println("4. Remove User");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. View All Books");
            System.out.println("8. View All Users");
            System.out.println("9. Exit");
            System.out.println("----------------------------");
            System.out.print("\nSelect an option: ");
            int choice = scan.nextInt();
            scan.nextLine();
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    addUser();
                    break;
                case 4:
                    removeUser();
                    break;
                case 5:
                    issueBook();
                    break;
                case 6:
                    returnBook();
                    break;
                case 7:
                    viewAllBooks();
                    break;
                case 8:
                    viewAllUsers();
                    break;
                case 9:
                    System.out.println("--------------------");
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option! Try again.");
            }
        }
    }
    private static void addBook() {
        System.out.print("Enter Book ID: ");
        int bookId = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Title: ");
        String title = scan.nextLine();
        System.out.print("Enter Author: ");
        String author = scan.nextLine();
        books.put(bookId, new Book(bookId, title, author));
        System.out.println("-------------------------");
        System.out.println("Book added successfully!");
        System.out.println("----------------------------");
    }

    private static void removeBook() {
        System.out.print("Enter Book ID to remove: ");
        int bookId = scan.nextInt();
        if (books.remove(bookId) != null) {
            System.out.println("-------------------------");
            System.out.println("Book removed successfully!");
            System.out.println("----------------------------");
        } else {
            System.out.println("Book not found!");
        }
    }

    private static void addUser() {
        System.out.print("Enter User ID: ");
        int userId = scan.nextInt();
        scan.nextLine();
        System.out.print("Enter Name: ");
        String name = scan.nextLine();
        users.put(userId, new User(userId, name));
        System.out.println("--------------------------");
        System.out.println("User added successfully!");
        System.out.println("----------------------------");
    }

    private static void removeUser() {
        System.out.print("Enter User ID to remove: ");
        int userId = scan.nextInt();
        if (users.remove(userId) != null) {
            System.out.println("----------------------------");
            System.out.println("User removed successfully!");
            System.out.println("----------------------------");
        } else {
            System.out.println("User not found!");
        }
    }

    private static void issueBook() {
        System.out.print("Enter Book ID to issue: ");
        int bookId = scan.nextInt();
        Book book = books.get(bookId);
        if (book != null && !book.IsIssued) {
            book.IsIssued = true;
            System.out.println("----------------------------");
            System.out.println("Book issued successfully!");
            System.out.println("----------------------------");
        } else {
            System.out.println("Book not available for issuing!");
        }
    }

    private static void returnBook() {
        System.out.println("----------------------------");
        System.out.print("Enter Book ID to return: ");
        int bookId = scan.nextInt();
        Book book = books.get(bookId);
        if (book != null && book.IsIssued) {
            book.IsIssued = false;
            System.out.println("----------------------------");
            System.out.println("Book returned successfully!");
            System.out.println("----------------------------");
        } else {
            System.out.println("Book not found or not issued!");
        }
    }
    private static void viewAllBooks() {
        System.out.println("----------------------------");
        System.out.println("All Books:");
        System.out.println("----------------------------");
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    private static void viewAllUsers() {
        System.out.println("----------------------------");
        System.out.println("All Users:");
        System.out.println("----------------------------");
        for (User user : users.values()) {
            System.out.println(user);
        }
    }
}
