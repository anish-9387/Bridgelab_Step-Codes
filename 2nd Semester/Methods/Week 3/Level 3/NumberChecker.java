import java.util.*;

// Class creation
public class NumberChecker{	
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
	
	// Method to check if the number is a duck number
	public boolean checkDuckNumber(int[] arr){
		for(int i=0; i<arr.length; i++){
			if(arr[i] == 0)   return false;
		}
		return true;
	}
	
	// Method to check if the number is Armstrong number
	public boolean checkArmstrongNumber(int num, int[] arr){
		int sum = 0;
		for(int i=0; i<arr.length; i++){
			sum += (int)Math.pow(arr[i], arr.length);
		}
		if(num == sum)   return true;
		else   return false;
	}
	
	// Method to find the largest and second largest number
	public void findLargestAndSecondLargest(int[] arr){
		if(arr == null || arr.length < 2){
			System.out.println("Array must contain at least two elements!!!");
			return;
		}

		int largest = Integer.MIN_VALUE, secLargest = Integer.MIN_VALUE;
		for(int num : arr){
			if(num > largest){
				secLargest = largest;
				largest = num;
			}
			else if(num > secLargest && num < largest){
				secLargest = num;
			}
		}

		System.out.println("Largest number: " + largest);
		if(secLargest == Integer.MIN_VALUE){
			System.out.println("No distinct second largest number found");
		}
		else{
			System.out.println("Second largest number: " + secLargest);
		}
	}
	
	// Method to find the smallest and second smallest number
	public void findSmallestAndSecondSmallest(int[] arr){
		if(arr == null || arr.length < 2){
			System.out.println("Array must contain at least two elements!!!");
			return;
		}

		int smallest = Integer.MAX_VALUE, secSmallest = Integer.MAX_VALUE;
		for(int num : arr){
			if(num < smallest){
				secSmallest = smallest;
				smallest = num;
			}
			else if(num < secSmallest && num > smallest){
				secSmallest = num;
			}
		}

		System.out.println("Smallest number: " + smallest);
		if(secSmallest == Integer.MAX_VALUE){
			System.out.println("No distinct second smallest number found");
		}
		else{
			System.out.println("Second smallest number: " + secSmallest);
		}
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of object
		NumberChecker obj = new NumberChecker();
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		int[] arr = obj.digitsArray(num);
		
		// Displaying all the results
		System.out.println("Count of digits: " + obj.findCountOfDigits(num));
		System.out.print("Digit array is: ");
		for(int val : arr){
			System.out.print(val + " ");
		}
		System.out.println();
		System.out.println("Duck Number?: " + obj.checkDuckNumber(arr));
		System.out.println("Armstrong Number?: " + obj.checkArmstrongNumber(num,arr));
		obj.findLargestAndSecondLargest(arr);
		obj.findSmallestAndSecondSmallest(arr);	
		input.close();
	}
}
