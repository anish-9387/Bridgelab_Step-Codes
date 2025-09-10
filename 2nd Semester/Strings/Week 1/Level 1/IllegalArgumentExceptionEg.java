import java.util.*;

// Class creation
public class IllegalArgumentExceptionEg{
    // Method to generate IllegalArgumentException
    public void generateException(String str){
        System.out.println("Substring: " + str.substring(5,2));
    }

    // Method to handle IllegalArgumentException with try-catch
    public static void handleException(String str){
        try{
            System.out.println("Substring: " + str.substring(5,2));
        }
		catch(IllegalArgumentException e){
            System.out.println("Caught IllegalArgumentException: " + e.getMessage());
        }
		catch(RuntimeException e){
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		IllegalArgumentExceptionEg obj = new IllegalArgumentExceptionEg();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.next();

        System.out.println("\nCalling method to generate exception (no handling):");
        try{
            obj.generateException(str);
        }
		catch(IllegalArgumentException e){
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        System.out.println("\nCalling method with exception handling:");
        obj.handleException(str);
    }
}
