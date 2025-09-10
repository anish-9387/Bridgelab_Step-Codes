import java.util.*;

// Class creation
public class FrequencyUsingUniqueCharacters{
    // Method to find unique characters
    public char[] findUniqueCharacters(String str){
        int len = str.length();
        char[] unique = new char[len];
        int uniqueCount = 0;

        for(int i=0; i<len; i++){
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

    // Method to find frequencies using unique characters
    public String[][] findFrequency(String str){
        int[] frequency = new int[256];
        int len = str.length();
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            frequency[c]++;
        }

        char[] uniqueChars = findUniqueCharacters(str);
        String[][] result = new String[uniqueChars.length][2];
		for(int i=0; i<uniqueChars.length; i++){
            result[i][0] = String.valueOf(uniqueChars[i]);
            result[i][1] = String.valueOf(frequency[uniqueChars[i]]);
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		FrequencyUsingUniqueCharacters obj = new FrequencyUsingUniqueCharacters();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String[][] frequencyTable = obj.findFrequency(str);

        // Displaying the result
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("-------------------------");
        for(int i=0; i<frequencyTable.length; i++){
            System.out.printf("%-10s %-10s%n", frequencyTable[i][0], frequencyTable[i][1]);
        }
        input.close();
    }
}
