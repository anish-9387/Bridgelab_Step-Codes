// Class creation
public class StringIndexOutOfBoundsExceptionEg{
	// Method to generate the StringIndexOutOfBoundsException
    public void generateException(){
        String str= "Elephant";
		for(int i=0; i<=str.length(); i++){
			System.out.print(str.charAt(i) + " ");
		}
    }

    // Method to handle NullPointerException with try and catch
    public void handleException(){
        String str = "Elephant";
        try{
            for(int i=0; i<=str.length(); i++){
				System.out.print(str.charAt(i) + " ");
			}
        }
		catch(StringIndexOutOfBoundsException e){
            System.out.println("Caught a StringIndexOutOfBoundsException! Message: " + e.getMessage());
        }
    }

    public static void main(String[] args){
		StringIndexOutOfBoundsExceptionEg obj = new StringIndexOutOfBoundsExceptionEg();
		
        System.out.println("Calling method to generate exception (no handling):");
        try{
            obj.generateException();
        }
		catch(StringIndexOutOfBoundsException e){
            System.out.println("Exception caught in main: " + e.getMessage());
        }

        System.out.println("\nCalling method with exception handling: ");
        obj.handleException();
    }
}
