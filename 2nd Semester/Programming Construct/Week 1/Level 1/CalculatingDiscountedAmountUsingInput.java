import java.util.*;

// Class creation
class CalculatingDiscountedAmountUsingInput{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Taking fee input from user
		double fee;
		fee = input.nextDouble();
		
		// Taking discount percent input from user
		double discountPercent;
		discountPercent = input.nextDouble();
		
		// Calculating the discount
		double discount = discountPercent / 100 * fee;
		
		// Displaying the result
		System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + (fee-discount));
	}
}
