import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student{
    private int rollNo;
    private String name;

    public Student(int rollNo, String name){
        this.rollNo=rollNo;
        this.name=name;
    }

    @Override
    public boolean equals(Object obj){
        if(this==obj)  return true;
        if(obj==null || getClass()!=obj.getClass())  return false;
        Student other=(Student)obj;
        return this.rollNo==other.rollNo;
    }

    @Override
    public int hashCode(){
        return Objects.hash(rollNo);
    }

    @Override
    public String toString(){
        return "Student[rollNo="+rollNo+", name="+name+"]";
    }
}

public class HashCodeAndEquals{
    public static void main(String[] args){
        Set<Student> students=new HashSet<>();

        Student s1=new Student(1,"Alice");
        Student s2=new Student(2,"Bob");
        Student s3=new Student(1,"Charlie");

        students.add(s1);
        students.add(s2);
        students.add(s3);

        System.out.println("Students in HashSet:");
        for(Student s : students){
            System.out.println(s);
        }
    }
}
