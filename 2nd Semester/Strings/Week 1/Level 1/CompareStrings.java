import java.util.*;

// Class creation
public class CompareStrings{
	// Method to compare 2 strings using charAt() method
	public boolean areStringsEqual(String str1, String str2){
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
		CompareStrings obj = new CompareStrings();
		
		// Taking 2 strings from the user
		System.out.print("Enter the 1st string: ");
		String str1 = input.next();
		System.out.print("Enter the 2nd string: ");
		String str2 = input.next();
		
		// Comparing the results from both methods
		System.out.println("Are two strings same?: " + (obj.areStringsEqual(str1,str2)));
		System.out.println("Are two results same?: " + (obj.areStringsEqual(str1,str2) == str1.equals(str2)));
		input.close();
	}
}
