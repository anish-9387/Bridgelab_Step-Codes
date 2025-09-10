import java.util.*;

// Class creation
public class NumberChecker3{	
	// Method to find the count of digits in the number
	public int findCountOfDigits(int num){
		int[] arr = digitsArray(num);
		int count = 0;
		for(int i=0; i<arr.length; i++){
			count++;
		}
		return count;
	}
	
	// Method to store the digits of the number in an array
	public int[] digitsArray(int num){
		int orgNum = num, count = 0;
		while(orgNum != 0){
			count++;
			orgNum /= 10;
		}
		int idx = count - 1;
		int[] digits = new int[count];
		while(num != 0 && idx >= 0){
			int ld = num % 10;
			digits[idx] = ld;
			num /= 10;
			idx--;
		}
		return digits;
	}
	
	// Method to reverse the digits array
	public int[] reverseDigitsArray(int[] arr){
		int[] reversedArray = new int[arr.length];
		for(int i=arr.length-1; i>=0; i--){
			reversedArray[arr.length - i - 1] = arr[i];
		}
		return reversedArray;
	}
	
	// Method to compare two arrays and check if they are equal
	public boolean compareArray(int[] arr1, int[] arr2){
		for(int i=0; i<arr1.length; i++){
			if(arr1[i] != arr2[i])  return false;
		}
		return true;
	}
	
	// Method to check if the number is palindrome or not
	public boolean checkPalindromeNumber(int[] arr1, int[] arr2){
		if(compareArray(arr1,arr2)){
			return true;
		}
		else{
			return false;
		}
	}
	
	// Method to check if the number is a duck number
	public boolean checkDuckNumber(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)   return false;
		}
		return true;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of object
		NumberChecker3 obj = new NumberChecker3();
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		int[] arr = obj.digitsArray(num);
		int[] revArr = obj.reverseDigitsArray(arr);
		
		// Displaying all the results
		System.out.println("Count of digits: " + obj.findCountOfDigits(num));
		System.out.print("Digit array is: ");
		for(int val : arr){
			System.out.print(val + " ");
		}
		System.out.println();
		
		System.out.print("Reversed digit array is: ");
		for(int val : revArr){
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("Are the two arrays equal?: " + obj.compareArray(arr,revArr));
		System.out.println("Palindrome Number?: " + obj.checkPalindromeNumber(arr,revArr));
		System.out.println("Duck Number?: " + obj.checkDuckNumber(arr));
		input.close();
	}
}
