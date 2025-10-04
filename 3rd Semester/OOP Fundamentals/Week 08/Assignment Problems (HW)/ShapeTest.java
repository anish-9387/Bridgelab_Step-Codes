abstract class Shape{
    public abstract double area();
    public abstract double perimeter();

    public void displayInfo(){
        System.out.println("This is a geometric shape");
    }
}

class Circle extends Shape{
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public double area(){
        return Math.PI*radius*radius;
    }

    @Override
    public double perimeter(){
        return 2*Math.PI*radius;
    }

    public void showDetails(){
        displayInfo();
        System.out.println("Shape: Circle");
        System.out.println("Radius: "+radius);
        System.out.println("Area: "+area());
        System.out.println("Perimeter: "+perimeter());
    }
}

class Rectangle extends Shape{
    private double length;
    private double width;

    public Rectangle(double length, double width){
        this.length=length;
        this.width=width;
    }

    @Override
    public double area(){
        return length*width;
    }

    @Override
    public double perimeter(){
        return 2*(length+width);
    }

    public void showDetails(){
        displayInfo();
        System.out.println("Shape: Rectangle");
        System.out.println("Length: "+length);
        System.out.println("Width: "+width);
        System.out.println("Area: "+area());
        System.out.println("Perimeter: "+perimeter());
    }
}

public class ShapeTest{
    public static void main(String[] args){
        Circle circle=new Circle(5);
        circle.showDetails();

        System.out.println();

        Rectangle rectangle=new Rectangle(8,4);
        rectangle.showDetails();
    }
}
