public class Book{
    String title;
    String author;
    double price;

    public Book(){
        this.title="Unknown";
        this.author="Unknown";
        this.price=0.0;
    }

    public Book(String title, String author, double price){
        this.title=title;
        this.author=author;
        this.price=price;
    }

    public void display(){
        System.out.println("Title: "+title);
        System.out.println("Author: "+author);
        System.out.println("Price: $"+price);
        System.out.println("------------------------");
    }

    public static void main(String[] args){
        Book book1=new Book();

        Book book2=new Book("The Alchemist","Paulo Coelho",499.99);

        book1.display();
        book2.display();
    }
}
