import java.util.*;

// Class creation
public class StringLength{
    // Method to find the length of a string without using length()
    public int getStringLength(String str){
        int count = 0;
        try{
            while(true){
                str.charAt(count);
                count++;
            }
        }
		catch(IndexOutOfBoundsException e){
			
        }
        return count;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		StringLength obj = new StringLength();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.next();

        int userDefinedLength = obj.getStringLength(str);

        int builtInLength = str.length();

        // Displaying the results
        System.out.println("Length (without using length() function): " + userDefinedLength);
        System.out.println("Length (using length() function): " + builtInLength);
        input.close();
    }
}
