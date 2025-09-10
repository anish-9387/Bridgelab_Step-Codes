class Book{
    private String bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    private static int totalBooks=0;
    private static int availableBooks=0;
    private static int bookCounter=0;

    public Book(String title, String author){
        this.bookId=generateBookId();
        this.title=title;
        this.author=author;
        this.isAvailable=true;
        totalBooks++;
        availableBooks++;
    }

    public boolean issueBook(){
        if(isAvailable){
            isAvailable=false;
            availableBooks--;
            return true;
        }
        return false;
    }

    public boolean returnBook(){
        if(!isAvailable){
            isAvailable=true;
            availableBooks++;
            return true;
        }
        return false;
    }

    public void displayBookInfo(){
        System.out.println("Book ID: "+bookId);
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Available: "+(isAvailable ? "Yes" : "No"));
        System.out.println("-------------------------");
    }

    public String getBookId(){
        return bookId;
    }

    public boolean isAvailable(){
        return isAvailable;
    }

    private static String generateBookId(){
        bookCounter++;
        return String.format("B%03d",bookCounter);
    }

    public static int getTotalBooks(){
        return totalBooks;
    }

    public static int getAvailableBooks(){
        return availableBooks;
    }
}

class Member{
    private String memberId;
    private String memberName;
    private String[] booksIssued;
    private int bookCount;

    private static int memberCounter=0;

    public Member(String memberName, int maxBooks){
        this.memberId=generateMemberId();
        this.memberName=memberName;
        this.booksIssued=new String[maxBooks];
        this.bookCount=0;
    }

    public void borrowBook(Book book){
        if(bookCount<booksIssued.length && book.isAvailable()){
            if(book.issueBook()){
                booksIssued[bookCount++]=book.getBookId();
                System.out.println(memberName+" borrowed "+book.getBookId());
            }
        }
        else{
            System.out.println(memberName+" cannot borrow "+book.getBookId());
        }
    }

    public void returnBook(String bookId, Book[] books){
        for(int i=0; i<bookCount; i++){
            if(booksIssued[i].equals(bookId)){
                for(Book b : books){
                    if(b!=null && b.getBookId().equals(bookId)){
                        if(b.returnBook()){
                            System.out.println(memberName+" returned "+bookId);
                        }
                        break;
                    }
                }
                for(int j=i; j<bookCount-1; j++){
                    booksIssued[j]=booksIssued[j+1];
                }
                booksIssued[--bookCount]=null;
                return;
            }
        }
        System.out.println(memberName+" does not have book "+bookId);
    }

    public void displayMemberInfo(){
        System.out.println("Member ID: "+memberId);
        System.out.println("Member Name: "+memberName);
        System.out.print("Books Issued: ");
        for(int i=0; i<bookCount; i++){
            System.out.print(booksIssued[i]+" ");
        }
        if(bookCount==0)  System.out.print("None");
        System.out.println("\n-------------------------");
    }

    private static String generateMemberId(){
        memberCounter++;
        return String.format("M%03d",memberCounter);
    }
}

public class LibraryManagementSystem{
    public static void main(String[] args){
        Book[] books=new Book[5];
        Member[] members=new Member[3];

        books[0]=new Book("The Alchemist","Paulo Coelho");
        books[1]=new Book("1984","George Orwell");
        books[2]=new Book("Clean Code","Robert C. Martin");

        members[0]=new Member("Alice",3);
        members[1]=new Member("Bob",2);

        System.out.println("====== Library Books ======");
        for(Book b : books){
            if(b!=null)  b.displayBookInfo();
        }

        System.out.println("====== Members ======");
        for(Member m : members){
            if(m!=null)  m.displayMemberInfo();
        }

        members[0].borrowBook(books[0]);
        members[0].borrowBook(books[1]);
        members[1].borrowBook(books[0]);

        members[0].returnBook("B001",books);
        members[1].borrowBook(books[0]);

        System.out.println("\n====== After Transactions ======");
        for(Book b : books){
            if(b!=null)  b.displayBookInfo();
        }
        for(Member m : members){
            if(m!=null)  m.displayMemberInfo();
        }

        System.out.println("Total Books: "+Book.getTotalBooks());
        System.out.println("Available Books: "+Book.getAvailableBooks());
    }
}
