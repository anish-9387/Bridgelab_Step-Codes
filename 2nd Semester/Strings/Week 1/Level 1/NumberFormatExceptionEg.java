import java.util.*;

public class NumberFormatExceptionEg{
    // Method to generate NumberFormatException
    public void generateException(String str){
        int num = Integer.parseInt(str);
        System.out.println("Parsed number: " + num);
    }

    // Method to handle NumberFormatException with try-catch
    public void handleException(String str){
        try{
            int num = Integer.parseInt(str);
            System.out.println("Parsed number: " + num);
        }
		catch(NumberFormatException e){
            System.out.println("Caught NumberFormatException: " + e.getMessage());
        }
		catch (RuntimeException e){
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		NumberFormatExceptionEg obj = new NumberFormatExceptionEg();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.next();

        System.out.println("\nCalling method to generate exception (no handling):");
        try{
            obj.generateException(str);
        }
		catch(NumberFormatException e){
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        System.out.println("\nCalling method with exception handling:");
        obj.handleException(str);
    }
}
