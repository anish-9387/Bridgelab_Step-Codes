// Class creation
class CalculatingDiscountedAmount{
	public static void main(String[] args){
		
		// Creating the variable for fee
		double fee = 125000;
		
		// Creating the variable of percent discount
		double discountPercent = 10;
		
		// Calculating the discount
		double discount = discountPercent / 100 * fee;
		
		// Displaying the result
		System.out.println("The discount amount is INR " + discount + " and final discounted fee is INR " + (fee-discount));
	}
}
