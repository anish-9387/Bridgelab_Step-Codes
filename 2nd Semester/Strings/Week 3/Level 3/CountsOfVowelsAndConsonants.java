import java.util.*;

// Class creation
public class CountsOfVowelsAndConsonants{
    // Method to check if a character is a vowel, consonant, or not a letter
    public String checkCharacterNature(char ch){
        if(ch >= 'A' && ch <= 'Z'){
            ch = (char)(ch + 32);
        }

        if(ch >= 'a' && ch <= 'z'){
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'){
                return "Vowel";
            }
			else{
                return "Consonant";
            }
        }
		else{
            return "Not a Letter";
        }
    }

    // Method to find and count vowels and consonants
    public int[] countOfVowelsAndConsonants(String str){
        int vowelCount = 0;
        int consonantCount = 0;

        int i = 0;
        try{
            while(true){
                char ch = str.charAt(i);
                String result = checkCharacterNature(ch);

                if(result.equals("Vowel")){
                    vowelCount++;
                }
				else if(result.equals("Consonant")){
                    consonantCount++;
                }
                i++;
            }
        }
		catch(IndexOutOfBoundsException e){

        }
        return new int[]{vowelCount,consonantCount};
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		CountsOfVowelsAndConsonants obj = new CountsOfVowelsAndConsonants();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        int[] counts = obj.countOfVowelsAndConsonants(str);

        // Displaying the results
        System.out.println("\nTotal Vowels: " + counts[0]);
        System.out.println("Total Consonants: " + counts[1]);
        input.close();
    }
}
