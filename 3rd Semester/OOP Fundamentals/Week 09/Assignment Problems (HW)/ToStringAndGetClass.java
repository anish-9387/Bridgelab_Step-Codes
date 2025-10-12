class Employee{
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary){
        this.id=id;
        this.name=name;
        this.salary=salary;
    }

    @Override
    public String toString(){
        return "Employee [ID="+id+", Name="+name+", Salary="+salary+"]";
    }
}

public class ToStringAndGetClass{
    public static void main(String[] args){
        Employee e1=new Employee(101,"Alice",75000);
        Employee e2=new Employee(102,"Bob",68000);
        Employee e3=new Employee(103,"Charlie",72000);

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        System.out.println("Class of e1: "+e1.getClass().getName());
        System.out.println("Class of e2: "+e2.getClass().getName());
        System.out.println("Class of e3: "+e3.getClass().getName());
    }
}
