import java.util.*;

// CLass creation
public class ArrayIndexOutOfBoundsExceptionEg{
    // Method to generate ArrayIndexOutOfBoundsException
    public void generateException(String[] names){
        System.out.println("Accessing index 9: " + names[9]);
    }

    // Method to handle ArrayIndexOutOfBoundsException with try-catch
    public void handleException(String[] names){
        try{
            System.out.println("Accessing index 9: " + names[9]);
        }
		catch (ArrayIndexOutOfBoundsException e){
            System.out.println("Caught ArrayIndexOutOfBoundsException: " + e.getMessage());
        }
		catch (RuntimeException e){
            System.out.println("Caught RuntimeException: " + e.getMessage());
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		ArrayIndexOutOfBoundsExceptionEg obj = new ArrayIndexOutOfBoundsExceptionEg();

        // Taking input of array of names from the user
        System.out.print("Enter number of names: ");
        int n = input.nextInt();
        String[] names = new String[n];

        for(int i=0; i<n; i++){
            System.out.print("Enter name " + (i + 1) + ": ");
            names[i] = input.next();
        }

        System.out.println("\nCalling method to generate exception (no handling):");
        try{
            obj.generateException(names);
        }
		catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        System.out.println("\nCalling method with exception handling:");
        obj.handleException(names);
    }
}
