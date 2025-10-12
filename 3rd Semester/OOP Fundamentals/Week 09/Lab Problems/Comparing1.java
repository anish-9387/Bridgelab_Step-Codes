class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title=title;
        this.author=author;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)  return true;
        if(obj==null || getClass()!=obj.getClass())  return false;
        Book other=(Book)obj;
        return title.equals(other.title) && author.equals(other.author);
    }
}

public class Comparing1{
    public static void main(String[] args){
        Book book1=new Book("1984","George Orwell");
        Book book2=new Book("1984","George Orwell");
        Book book3=book1;

        System.out.println("book1==book2: "+(book1==book2));
        System.out.println("book1==book3: "+(book1==book3));

        System.out.println("book1.equals(book2): "+book1.equals(book2));
        System.out.println("book1.equals(book3): "+book1.equals(book3));
    }
}
