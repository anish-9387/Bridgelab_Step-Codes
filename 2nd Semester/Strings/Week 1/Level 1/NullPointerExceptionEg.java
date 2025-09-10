// Class creation
public class NullPointerExceptionEg{
    // Method to generate NullPointerException
    public void generateException(){
        String str = null;
        System.out.println("Length of text: " + str.length());
    }

    // Method to handle NullPointerException with try and catch
    public void handleException(){
        String str = null;
        try{
            System.out.println("Length of text: " + str.length());
        }
		catch(NullPointerException e){
            System.out.println("Caught a NullPointerException! Message: " + e.getMessage());
        }
    }

    public static void main(String[] args){
		NullPointerExceptionEg obj = new NullPointerExceptionEg();
		
        System.out.println("Calling method to generate exception (no handling):");
        try{
            obj.generateException();
        }
		catch(NullPointerException e){
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        System.out.println("\nCalling method with exception handling: ");
        obj.handleException();
    }
}
