import java.util.Scanner;

public class FinallyDivisionExample{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int num1, num2, result;

        try{
            System.out.print("Enter first number: ");
            num1=scanner.nextInt();
            System.out.print("Enter second number: ");
            num2=scanner.nextInt();

            result=num1/num2;
            System.out.println("Result: "+result);
        }
        catch(ArithmeticException e){
            System.out.println("Error: Cannot divide by zero!!");
        }
        finally{
            System.out.println("Operation completed");
        }

        scanner.close();
    }
}