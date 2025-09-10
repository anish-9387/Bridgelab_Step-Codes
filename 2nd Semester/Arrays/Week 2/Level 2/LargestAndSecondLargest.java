import java.util.*;

// Class creation
class LargestAndSecondLargest{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of variable for number and taking input
		int num;
		System.out.print("Enter a number: ");
		num = input.nextInt();
		
		// Creation of the array to store digits
		int maxDigit = 10, idx = 0;
		int[] arr = new int[maxDigit];
		while(num != 0){
			if(idx == maxDigit)  break;
			int lastDigit = num % 10;
			arr[idx] = lastDigit;
			num /= 10;
			idx++;
		}
		
		// Finding the largest and second largest number
		int largest=0;
		int secLargest = 0;
		for(int i=0; i<10; i++){
			if(arr[i] > largest){
				secLargest = largest;
				largest = arr[i];
			}
		}
		
		// Printing the result
		System.out.println("Largest number is: " + largest);
		System.out.println("Second largest number is: " + secLargest);
		
		input.close();
	}
}
