class Phone{
    protected String brand;
    protected String model;

    public Phone(){
        System.out.println("Phone: Default constructor called");
    }

    public Phone(String brand, String model){
        this.brand=brand;
        this.model=model;
        System.out.println("Phone: Parameterized constructor called -> "+brand+" "+model);
    }
}

class SmartPhone extends Phone{
    private String operatingSystem;

    public SmartPhone(){
        super();
        System.out.println("SmartPhone: Default constructor called");
    }

    public SmartPhone(String brand, String model, String operatingSystem){
        super(brand,model);
        this.operatingSystem=operatingSystem;
        System.out.println("SmartPhone: Parameterized constructor called -> OS: "+operatingSystem);
    }

    public void showDetails(){
        System.out.println("Brand: "+brand+", Model: "+model+", OS: "+operatingSystem);
    }
}

public class PhoneTest{
    public static void main(String[] args){
        System.out.println("Creating first smartphone with default constructor:");
        SmartPhone sp1=new SmartPhone();

        System.out.println("\nCreating second smartphone with parameterized constructor:");
        SmartPhone sp2=new SmartPhone("Samsung","Galaxy S24","Android");
        sp2.showDetails();
    }
}
