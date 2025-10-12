class Address{
    String city;
    String street;

    public Address(String city, String street){
        this.city=city;
        this.street=street;
    }

    @Override
    public String toString(){
        return city+", "+street;
    }
}

class Person implements Cloneable{
    String name;
    Address address;

    public Person(String name, Address address){
        this.name=name;
        this.address=address;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException{
        return super.clone();
    }

    public Person deepClone(){
        Address newAddress=new Address(address.city,address.street);
        return new Person(name,newAddress);
    }

    @Override
    public String toString(){
        return "Person[name="+name+", address="+address+"]";
    }
}

public class ObjectCloning{
    public static void main(String[] args) throws CloneNotSupportedException{
        Address addr=new Address("New York","5th Avenue");
        Person p1=new Person("Alice",addr);

        Person shallowClone=(Person)p1.clone();

        Person deepClone=p1.deepClone();

        System.out.println("Original: "+p1);
        System.out.println("Shallow Clone: "+shallowClone);
        System.out.println("Deep Clone: "+deepClone);

        p1.address.city="Los Angeles";

        System.out.println("\nAfter modifying original's address:");
        System.out.println("Original: "+p1);
        System.out.println("Shallow Clone: "+shallowClone);
        System.out.println("Deep Clone: "+deepClone);
    }
}
