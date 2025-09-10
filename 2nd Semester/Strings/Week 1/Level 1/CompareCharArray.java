import java.util.*;

// Class creation
public class CompareCharArray{
    // Method to return characters in a string without using toCharArray()
    public char[] getCharsFromString(String str){
        char[] arr = new char[str.length()];
        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i);
        }
        return arr;
    }

    // Method to compare two string arrays
    public boolean compareCharArrays(char[] arr1, char[] arr2){
        if(arr1.length == arr2.length){
			for(int i=0; i<arr1.length; i++){
				if(arr1[i] != arr2[i])   return false;
			}
			return true;
		}
		else   return false;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		CompareCharArray obj = new CompareCharArray();

        // Taking string from user
        System.out.print("Enter a string: ");
        String str = input.next();

        char[] userDefinedCharArray = obj.getCharsFromString(str);
        char[] builtInCharArray = str.toCharArray();

        System.out.print("Character array using user-defined method: ");
        for(char i : userDefinedCharArray){
            System.out.print(i + " ");
        }

        System.out.print("\nCharacter array using built-in method: ");
        for(char i : builtInCharArray){
            System.out.print(i + " ");
        }
        System.out.println("\nAre both character arrays equal? " + obj.compareCharArrays(userDefinedCharArray,builtInCharArray));
		input.close();
    }
}
