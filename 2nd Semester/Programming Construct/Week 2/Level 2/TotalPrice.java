import java.util.*;

// Class creation
class TotalPrice{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating variables for unit price and quantity
		double unitPrice;
		int quantity;
		
		// Taking the input from the user
		System.out.print("Enter the unit price: ");
		unitPrice = input.nextDouble();
		System.out.print("Enter the quantity: ");
		quantity = input.nextInt();
		
		// Calculating the total price
		double totalPrice = unitPrice * quantity;
		
		// Printing the result
		System.out.println("The total purchase price is INR " + totalPrice + " if the quantity is " + quantity + " and unit price is INR " + unitPrice);
		
		input.close();
	}
}
