import java.util.*;

// Class creation
public class UniqueCharactersInString{
    // Method to find the length of a String without using length() method
    public int calculateLength(String str){
		char[] chars = str.toCharArray();
		int count = 0;
		for(char c : chars){
			count++;
		}
		return count;
	}

    // Method to find unique characters using charAt()
    public char[] findUniqueCharacters(String str){
        int length = calculateLength(str);
        char[] unique = new char[length];
        int uniqueCount = 0;

        for(int i=0; i<length; i++){
            char currentChar = str.charAt(i);
            boolean isUnique = true;
            for(int j=0; j<i; j++){
                if(currentChar == str.charAt(j)){
                    isUnique = false;
                    break;
                }
            }

            if(isUnique){
                unique[uniqueCount] = currentChar;
                uniqueCount++;
            }
        }

        char[] result = new char[uniqueCount];
        for(int i=0; i<uniqueCount; i++){
            result[i] = unique[i];
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		UniqueCharactersInString obj = new UniqueCharactersInString();
		
        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        char[] ans = obj.findUniqueCharacters(str);

        // Displaying the result
        System.out.print("Unique characters are: ");
        for(char c : ans){
            System.out.print(c + " ");
        }        
        input.close();
    }
}
