import java.util.*;

// Class creation
class SmallestAndLargest{
	// Method to find smallest and largest
	public static int[] findSmallestAndLargest(int number1, int number2, int number3){
		int smallest = number1;
		int largest = number1;
		
		if(number2 < smallest)  smallest = number2;
		if(number3 < smallest)  smallest = number3;		
		if(number2 > largest)  largest = number2;
		if(number3 > largest)  largest = number3;
		
		return new int[] {largest,smallest};
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for numbers
		System.out.print("Enter the number 1: ");
		int num1 = input.nextInt();
		System.out.print("Enter the number 2: ");
		int num2 = input.nextInt();
		System.out.print("Enter the number 3: ");
		int num3 = input.nextInt();
			
		// Printing the smallest and largest
		int[] result = findSmallestAndLargest(num1,num2,num3);
		System.out.println("Smallest number: " + result[1] + " and largest number: " + result[0]);
		
		input.close();
	}
}
