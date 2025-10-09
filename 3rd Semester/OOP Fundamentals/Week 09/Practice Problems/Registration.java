class ContactInfo implements Cloneable{
    String email;
    String phone;

    public ContactInfo(String email, String phone){
        this.email=email;
        this.phone=phone;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    @Override
    public String toString(){
        return "Email: "+email+", Phone: "+phone;
    }
}

class Student implements Cloneable{
    String id;
    String name;
    ContactInfo contact;

    public Student(String id, String name, ContactInfo contact){
        this.id=id;
        this.name=name;
        this.contact=contact;
    }

    protected Object cloneShallow() throws CloneNotSupportedException{
        return super.clone();
    }

    protected Object cloneDeep() throws CloneNotSupportedException{
        Student copy=(Student)super.clone();
        copy.contact=(ContactInfo)contact.clone();
        return copy;
    }

    @Override
    public String toString(){
        return "Student ID: "+id+", Name: "+name+", "+contact;
    }
}

public class Registration{
    public static void main(String[] args) throws CloneNotSupportedException{
        ContactInfo c1=new ContactInfo("ritika@gmail.com","9999999999");
        Student s1=new Student("S101","Ritika",c1);

        Student shallowCopy=(Student)s1.cloneShallow();
        Student deepCopy=(Student)s1.cloneDeep();

        s1.contact.email="changed@gmail.com";
        s1.contact.phone="8888888888";

        System.out.println("Original:     "+s1);
        System.out.println("Shallow Copy: "+shallowCopy);
        System.out.println("Deep Copy:    "+deepCopy);
    }
}
