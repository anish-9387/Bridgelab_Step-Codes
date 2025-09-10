import java.util.*;

// Class creation
public class FirstNonRepeatingCharacter{
    // Method to find the first non-repeating character
    public char findFirstNonRepeatingChar(String str){
        int[] frequency = new int[256];

        int len = str.length();
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            frequency[c]++;
        }

        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(frequency[c] == 1){
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		FirstNonRepeatingCharacter obj = new FirstNonRepeatingCharacter();

        // Taking input from user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        char result = obj.findFirstNonRepeatingChar(str);

        // Displaying the result
        if(result == '\0'){
            System.out.println("Non-repeating character not found");
        }
		else{
            System.out.println("First non-repeating character: " + result);
        }
        input.close();
    }
}
