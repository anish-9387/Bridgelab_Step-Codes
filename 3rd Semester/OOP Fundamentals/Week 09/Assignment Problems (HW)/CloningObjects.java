import java.util.ArrayList;
import java.util.List;

class Book implements Cloneable{
    String title;
    String author;

    public Book(String title, String author){
        this.title=title;
        this.author=author;
    }

    @Override
    protected Book clone() throws CloneNotSupportedException{
        return (Book)super.clone();
    }

    @Override
    public String toString(){
        return "["+title+" by "+author+"]";
    }
}

class Library implements Cloneable{
    List<Book> books;

    public Library(){
        books=new ArrayList<>();
    }

    public void addBook(Book b){
        books.add(b);
    }

    @Override
    protected Library clone() throws CloneNotSupportedException{
        return (Library)super.clone();
    }

    public Library deepClone() throws CloneNotSupportedException{
        Library copy=(Library)super.clone();
        copy.books=new ArrayList<>();
        for(Book b : books){
            copy.books.add(b.clone());
        }
        return copy;
    }

    @Override
    public String toString(){
        return books.toString();
    }
}

public class CloningObjects{
    public static void main(String[] args) throws CloneNotSupportedException{
        Library lib1=new Library();
        lib1.addBook(new Book("1984","George Orwell"));
        lib1.addBook(new Book("Brave New World","Aldous Huxley"));

        Library shallowLib=lib1.clone();

        Library deepLib=lib1.deepClone();

        System.out.println("Original Library: "+lib1);
        System.out.println("Shallow Clone: "+shallowLib);
        System.out.println("Deep Clone: "+deepLib);

        shallowLib.books.get(0).title="Animal Farm";

        deepLib.books.get(1).title="Island";

        System.out.println("\nAfter modifications:");
        System.out.println("Original Library: "+lib1);
        System.out.println("Shallow Clone: "+shallowLib);
        System.out.println("Deep Clone: "+deepLib);
    }
}
