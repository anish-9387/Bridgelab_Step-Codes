abstract class Shape{
    protected double area;
    protected double perimeter;

    public abstract void calculateArea();

    public abstract void calculatePerimeter();

    public void display(){
        System.out.println("Area: "+area);
        System.out.println("Perimeter: "+perimeter);
    }
}

interface Drawable{
    void draw();
}

class Circle extends Shape implements Drawable{
    private double radius;

    public Circle(double radius){
        this.radius=radius;
    }

    @Override
    public void calculateArea(){
        area=Math.PI*radius*radius;
    }

    @Override
    public void calculatePerimeter(){
        perimeter=2*Math.PI*radius;
    }

    @Override
    public void draw(){
        System.out.println("Drawing a Circle with radius: "+radius);
    }
}

public class GeometryTest{
    public static void main(String[] args){
        Circle circle=new Circle(5.0);

        circle.draw();

        circle.calculateArea();
        circle.calculatePerimeter();
        circle.display();
    }
}
