class BasicMath{
    public int calculate(int a, int b){
        System.out.println("BasicMath: Adding two integers");
        return a+b;
    }

    public double calculate(double a, double b){
        System.out.println("BasicMath: Multiplying two doubles");
        return a*b;
    }

    public int calculate(int a, int b, int c){
        System.out.println("BasicMath: Adding three integers");
        return a+b+c;
    }
}

class AdvancedMath extends BasicMath{
    public double calculate(int base, double exponent){
        System.out.println("AdvancedMath: Calculating power");
        return Math.pow(base,exponent);
    }

    public long calculate(int n){
        System.out.println("AdvancedMath: Calculating factorial");
        long fact=1;
        for(int i=1; i<=n; i++)  fact*=i;
        return fact;
    }

    public double calculate(double radius){
        System.out.println("AdvancedMath: Calculating area of circle");
        return Math.PI*radius*radius;
    }
}

public class MethodOverloading{
    public static void main(String[] args) {
        BasicMath bm=new BasicMath();
        AdvancedMath am=new AdvancedMath();

        System.out.println("====== BasicMath Tests ======");
        System.out.println("Sum (2,3): "+bm.calculate(2,3));
        System.out.println("Product (2.5,4.0): "+bm.calculate(2.5,4.0));
        System.out.println("Sum (1,2,3): "+bm.calculate(1,2,3));

        System.out.println("\n====== AdvancedMath Tests (inherits + new) ======");
        System.out.println("Factorial (5): "+am.calculate(5));
        System.out.println("Power (2,3.0): "+am.calculate(2,3.0));
        System.out.println("Area of circle (radius 5): "+am.calculate(5.0));

        System.out.println("Sum (10,20): "+am.calculate(10,20));
    }
}
