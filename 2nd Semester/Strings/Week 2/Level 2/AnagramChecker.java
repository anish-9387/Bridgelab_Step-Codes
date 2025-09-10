import java.util.*;

// Class creation
public class AnagramChecker{
    // Method to check if two texts are anagrams
    public boolean isAnagram(String str1, String str2){
        if(str1.length() != str2.length()){
            return false;
        }

        int[] freq1 = new int[256];
        int[] freq2 = new int[256];

        for(int i=0; i<str1.length(); i++){
            freq1[str1.charAt(i)]++;
        }

        for(int i=0; i<str2.length(); i++){
            freq2[str2.charAt(i)]++;
        }

        for(int i=0; i<256; i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }
        return true;
	}

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		AnagramChecker obj = new AnagramChecker();

        // Taking inputs from the user
        System.out.print("Enter first text: ");
        String str1 = input.nextLine();

        System.out.print("Enter second text: ");
        String str2 = input.nextLine();

        boolean result = obj.isAnagram(str1,str2);

        // Displaying the result
        if(result){
            System.out.println("The two texts are anagrams");
        }
		else{
            System.out.println("The two texts are not anagrams");
        }
        input.close();
    }
}
