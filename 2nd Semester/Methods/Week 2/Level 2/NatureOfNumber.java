import java.util.*;

// Class creation
public class NatureOfNumber{
	public boolean isPositive(int num){
		if(num >= 0)  return true;
		else  return false;
	}
	
	public boolean isEven(int num){
		if(num % 2 == 0)  return true;
		else  return false;
	}
	
	public int compare(int num1, int num2){
		if(num1 > num2)  return 1;
		else if(num1 < num2)  return -1;
		else  return 0;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		NatureOfNumber n = new NatureOfNumber();
		
		// Creating array, taking input from the user and printing the result
		int[] arr = new int[5];
		for(int i=0; i<arr.length; i++){
			System.out.print("Enter number " + (i+1) + ": ");
			arr[i] = input.nextInt();
			
			boolean isPositiveAns = n.isPositive(arr[i]);
			if(isPositiveAns == true){
				System.out.println("Positive Number");
				boolean isEvenAns = n.isEven(arr[i]);
				if(isEvenAns == true)  System.out.println("Even Number");
				else  System.out.println("Odd Number");
			}
			else{
				System.out.println("Negative Number");
			}
		}
		
		int compareAns = n.compare(arr[0], arr[4]);
		if(compareAns == 1)  System.out.println("First element is greater than the last element");
		else if(compareAns == 0)  System.out.println("First element is equal to last element");
		else  System.out.println("First element is less than the last element");
		
		input.close();
	}
}
