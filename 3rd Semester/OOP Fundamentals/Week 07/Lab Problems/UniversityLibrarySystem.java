class LibraryUser{
    String name;

    LibraryUser(String name){
        this.name=name;
    }

    void enterLibrary(){
        System.out.println(name+" has entered the library");
    }

    void displayInfo(){
        System.out.println("Library User: "+name);
    }
}

class Student extends LibraryUser{
    Student(String name){
        super(name);
    }

    void borrowBook(){
        System.out.println(name+" borrowed a book");
    }

    void accessComputer(){
        System.out.println(name+" accessed a computer");
    }
}

class Faculty extends LibraryUser{
    Faculty(String name){
        super(name);
    }

    void reserveBook(){
        System.out.println(name+" reserved a book");
    }

    void accessResearchDatabase(){
        System.out.println(name+" accessed the research database");
    }
}

class Guest extends LibraryUser{
    Guest(String name){
        super(name);
    }

    void browseBooks(){
        System.out.println(name+" browsed the books");
    }
}

public class UniversityLibrarySystem{
    public static void main(String[] args){
        LibraryUser[] users={
            new Student("Alice"),
            new Faculty("Dr. Brown"),
            new Guest("Charlie")
        };

        System.out.println("====== Library Entry Log ======");
        for(LibraryUser user : users){
            user.enterLibrary();
            user.displayInfo();
            System.out.println();
        }

        System.out.println("====== Specialized Operations ======");
        ((Student)users[0]).borrowBook();
        ((Faculty)users[1]).reserveBook();
        ((Guest)users[2]).browseBooks();
    }
}
