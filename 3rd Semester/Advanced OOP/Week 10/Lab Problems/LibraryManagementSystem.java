import java.util.ArrayList;
import java.util.List;

class Book{
    private String title;
    private String author;
    private String ISBN;
    private boolean isIssued;

    public Book(String title, String author, String ISBN){
        this.title=title;
        this.author=author;
        this.ISBN=ISBN;
        this.isIssued=false;
    }

    public void issueBook(){
        if(!isIssued){
            isIssued=true;
            System.out.println(title+" has been issued");
        }
        else{
            System.out.println(title+" is already issued");
        }
    }

    public void returnBook(){
        if(isIssued){
            isIssued=false;
            System.out.println(title+" has been returned");
        } else {
            System.out.println(title+" was not issued");
        }
    }

    public String getTitle(){
        return title;
    }
}

class Member{
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;

    public Member(String name, int memberId){
        this.name=name;
        this.memberId=memberId;
        this.borrowedBooks=new ArrayList<>();
    }

    public void borrowBook(Book book){
        borrowedBooks.add(book);
        book.issueBook();
    }

    public void returnBook(Book book){
        borrowedBooks.remove(book);
        book.returnBook();
    }

    public void showBorrowedBooks(){
        System.out.println(name+" has borrowed:");
        for(Book b : borrowedBooks){
            System.out.println(" - "+b.getTitle());
        }
    }
}

class Librarian{
    private String name;
    private int employeeId;
    private List<Book> libraryBooks;

    public Librarian(String name, int employeeId){
        this.name=name;
        this.employeeId=employeeId;
        this.libraryBooks=new ArrayList<>();
    }

    public void addBook(Book book){
        libraryBooks.add(book);
        System.out.println(book.getTitle()+" added to library");
    }

    public void removeBook(Book book){
        libraryBooks.remove(book);
        System.out.println(book.getTitle()+" removed from library");
    }

    public void displayBooks(){
        System.out.println("Books in Library:");
        for(Book b : libraryBooks){
            System.out.println(" - "+b.getTitle());
        }
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args){
        Librarian librarian=new Librarian("Alice",1001);

        Book b1=new Book("Java Programming","James Gosling","J123");
        Book b2=new Book("Data Structures","Mark Allen","D456");

        librarian.addBook(b1);
        librarian.addBook(b2);

        Member m1=new Member("John", 201);
        m1.borrowBook(b1);
        m1.showBorrowedBooks();

        m1.returnBook(b1);
        librarian.displayBooks();
    }
}
