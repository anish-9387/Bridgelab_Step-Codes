class Student{
    String name;
    int id;

    Student(String name, int id){
        this.name=name;
        this.id=id;
    }

    void display(){
        System.out.println("Student Name: "+name+", ID: "+id);
    }
}

class Teacher{
    String name;
    int teacherId;
    Student student1;
    Student student2;

    Teacher(String name, int teacherId, Student student1, Student student2){
        this.name=name;
        this.teacherId=teacherId;
        this.student1=student1;
        this.student2=student2;
    }

    void display(){
        System.out.println("Teacher Name: "+name+", ID: "+teacherId);
        System.out.println("Guides:");
        student1.display();
        student2.display();
        System.out.println();
    }
}

public class ObjectDiagramDemo{
    public static void main(String[] args){
        Student student1=new Student("Karthik",101);
        Student student2=new Student("Priya",102);
        Student student3=new Student("Ravi",103);
        Student student4=new Student("Neha",104);

        Teacher teacher1=new Teacher("Mr. Sharma",1,student1,student2);
        Teacher teacher2=new Teacher("Mrs. Verma",2,student3,student4);

        teacher1.display();
        teacher2.display();
    }
}
