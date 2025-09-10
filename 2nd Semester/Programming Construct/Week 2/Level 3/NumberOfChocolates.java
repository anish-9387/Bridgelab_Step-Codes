import java.util.*;

// Class creation
class NumberOfChocolates{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for number of chocolates and children
		int numberOfChocolates, numberOfChildren;
		
		// Taking the unputs from the user
		System.out.print("Enter the number of chocolates: ");
		numberOfChocolates = input.nextInt();
		System.out.print("Enter the number of children: ");
		numberOfChildren = input.nextInt();
		
		// Calculating the number of chocolates divided equally and number of remaining chocolates
		int numberOfChocolatesGet = numberOfChocolates / numberOfChildren;
		int numberOfChocolatesRemaining = numberOfChocolates % numberOfChildren;
		
		// Printing the result
		System.out.println("The number of chocolates each child gets is " + numberOfChocolatesGet + " and the number of remaining chocolates is " + numberOfChocolatesRemaining);
		
		input.close();
	}
}
		