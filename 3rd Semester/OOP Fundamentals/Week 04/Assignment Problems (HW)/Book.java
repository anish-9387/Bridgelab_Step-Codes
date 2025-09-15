public class Book{
    String title;
    String author;
    String isbn;
    boolean isAvailable;

    Book(){
        this.title="Unknown";
        this.author="Unknown";
        this.isbn="N/A";
        this.isAvailable=true;
    }

    Book(String title, String author){
        this.title=title;
        this.author=author;
        this.isbn="N/A";
        this.isAvailable=true;
    }

    Book(String title, String author, String isbn, boolean isAvailable){
        this.title=title;
        this.author=author;
        this.isbn=isbn;
        this.isAvailable=isAvailable;
    }

    void borrowBook(){
        if(isAvailable){
            isAvailable=false;
            System.out.println("You borrowed: "+title);
        }
        else{
            System.out.println("Sorry, "+title+" is already borrowed");
        }
    }

    void returnBook(){
        if(!isAvailable){
            isAvailable=true;
            System.out.println("You returned: "+title);
        }
        else{
            System.out.println(title+" was not borrowed");
        }
    }

    void displayBookInfo(){
        System.out.println("Book Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("ISBN: "+isbn);
        System.out.println("Availability: "+(isAvailable ? "Available" : "Not Available"));
        System.out.println("-------------------------");
    }

    public static void main(String[] args){
        Book b1=new Book();

        Book b2=new Book("1984","George Orwell");

        Book b3=new Book("The Alchemist","Paulo Coelho","978-0061122415",true);

        b1.borrowBook();
        b2.borrowBook();
        b2.borrowBook(); // second attempt (should fail)
        b2.returnBook();
        b3.borrowBook();

        // Display info
        b1.displayBookInfo();
        b2.displayBookInfo();
        b3.displayBookInfo();
    }
}
