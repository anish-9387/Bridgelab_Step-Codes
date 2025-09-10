import java.util.*;

// Class creation
class NatureOfNumber{	
	// Method to check whether the number is +ve, -ve or 0
	public static int checkNature(int n){
		if(n > 0)  return 1;
		else if(n < 0)  return -1;
		else  return 0;
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for number
		System.out.print("Enter the number: ");
		int num = input.nextInt();
		
		// Checking the nature of number and printing it
		int nature = checkNature(num);
		System.out.println("Number is " + ((nature == 0) ? "Zero" : ((nature == 1) ? "Positive" : "Negative")));
		
		input.close();
	}
}
