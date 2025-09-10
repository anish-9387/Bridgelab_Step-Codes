import java.util.*;

// Class creation
public class VowelConsonantClassification{
    // Method to classify character as Vowel, Consonant, or Not a Letter
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

    // Method to return a 2D array with character and its type
    public String[][] analyzeCharacters(String str){
        int length = 0;
        try{
            while(true){
                str.charAt(length);
                length++;
            }
        }
		catch(IndexOutOfBoundsException e){
			
        }

        String[][] result = new String[length][2];
        for(int i=0; i<length; i++){
            char ch = str.charAt(i);
            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacterNature(ch);
        }
        return result;
    }

    // Method to display the 2D array in tabular format
    public void displayCharacterNatureData(String[][] data){
        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");
        for(int i=0; i<data.length; i++){
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		VowelConsonantClassification obj = new VowelConsonantClassification();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String[][] data = obj.analyzeCharacters(str);

        // Displaying the result
        obj.displayCharacterNatureData(data);
        input.close();
    }
}
