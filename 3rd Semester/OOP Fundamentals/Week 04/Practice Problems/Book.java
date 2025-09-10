public class Book{
    String title;
    String author;
    double price;

    // Default constructor
    public Book(){
        this.title="Unknown";
        this.author="Unknown";
        this.price=0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    // Display method
    public void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: $"+price);
        System.out.println("------------------------");
    }

    public static void main(String[] args){
        // Create book1 using default constructor
        Book book1=new Book();

        // Create book2 using parameterized constructor
        Book book2=new Book("The Alchemist","Paulo Coelho",499.99);

        // Display both books
        book1.display();
        book2.display();
    }
}
