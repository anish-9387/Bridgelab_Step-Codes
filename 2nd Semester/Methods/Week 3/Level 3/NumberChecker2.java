import java.util.*;

// Class creation
public class NumberChecker2{	
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
		int orgNum = num, count = 0, idx = 0;
		while(orgNum != 0){
			count++;
			orgNum /= 10;
		}
		int[] digits = new int[count];
		while(num != 0 && idx < count){
			int ld = num % 10;
			digits[idx] = ld;
			num /= 10;
			idx++;
		}
		return digits;
	}
	
	// Method to find the sum of digits of a number
	public int findSumOfDigits(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += arr[i];
		}
		return sum;
	}
	
	// Method to find the sum of squares of the digits of a number
	public int findSumOfSquares(int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += (int)Math.pow(arr[i], 2);
		}
		return sum;
	}
	
	// Method to check if a number is Harshad number
	public boolean checkHarshadNumber(int num){
		int originalNumber = num, sum = 0;
		while(originalNumber != 0){
			int lastDigit = originalNumber % 10;
			sum += lastDigit;
			originalNumber /= 10;
		}
		
		if(num % sum == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	// Method to find frequency of each digit in the number
	public int[][] digitFrequency(int num){
		int[] freq = new int[10];

		if(num == 0){
			freq[0] = 1;
		}
		else{
			while(num > 0){
				int ld = num % 10;
				freq[ld]++;
				num /= 10;
			}
		}
		
		int[][] result = new int[10][2];
		for(int i=0; i<10; i++){
			result[i][0] = i;
			result[i][1] = freq[i];
		}
		return result;
	}	
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of object
		NumberChecker2 obj = new NumberChecker2();
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		int[] arr = obj.digitsArray(num);
		int[][] ans = obj.digitFrequency(num);
		
		// Displaying all the results
		System.out.println("Count of digits: " + obj.findCountOfDigits(num));
		System.out.print("Digit array is: ");
		for(int val : arr){
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("Sum of digits of number: " + obj.findSumOfDigits(arr));
		System.out.println("Sum of squares of digits of number: " + obj.findSumOfSquares(arr));
		System.out.println("Harshad Number?: " + obj.checkHarshadNumber(num));
		System.out.println("Frequency of each digit of number: ");
		for(int i=0; i<10; i++){
			for(int j=0; j<2; j++){
				System.out.print(ans[i][j] + " ");
			}
			System.out.println();
		}
		input.close();
	}
}
