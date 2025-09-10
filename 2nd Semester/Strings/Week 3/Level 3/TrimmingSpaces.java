import java.util.*;

// Class creation
public class TrimmingSpaces{
    // Method to find start and end indices after trimming spaces
    public int[] findTrimIndices(String str){
        int length = 0;
		
        try{
            while(true){
                str.charAt(length);
                length++;
            }
        }
		catch(IndexOutOfBoundsException e){
			
        }

        int start = 0, end = length - 1;
        while(start < length && str.charAt(start) == ' '){
            start++;
        }

        while(end >= 0 && str.charAt(end) == ' '){
            end--;
        }
        return new int[]{start,end};
    }

    // Method to get a substring from start to end index using charAt()
    public String customSubstring(String str, int start, int end){
        StringBuilder sub = new StringBuilder();

        for(int i=start; i<=end; i++){
            sub.append(str.charAt(i));
        }
        return sub.toString();
    }

    // Method to compare two strings using charAt()
    public boolean compareTwoStrings(String str1, String str2){
        if(str1.length() == str2.length()){
			for(int i=0; i<str1.length(); i++){
				if(str1.charAt(i) != str2.charAt(i))   return false;
			}
			return true;
		}
		else   return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		TrimmingSpaces obj = new TrimmingSpaces();

        System.out.print("Enter a string with leading/trailing spaces: ");
        String str = input.nextLine();

        int[] indices = obj.findTrimIndices(str);
        String manuallyTrimmed = obj.customSubstring(str,indices[0],indices[1]);

        String builtInTrimmed = str.trim();

        boolean isSame = obj.compareTwoStrings(manuallyTrimmed,builtInTrimmed);

        // Displaying the results
        System.out.println("\nManually trimmed string: '" + manuallyTrimmed + "'");
        System.out.println("Built-in trimmed string: '" + builtInTrimmed + "'");
        System.out.println("Are both strings equal? " + (isSame ? "Yes" : "No"));
        input.close();
    }
}
