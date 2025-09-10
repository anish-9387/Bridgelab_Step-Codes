// Class creation
class CalculatingProfitLoss{
	public static void main(String[] args){
	
		// Creating variable to store cost price
		int costPrice = 129;
		
		// Creating variable to store selling price
		int sellingPrice = 191;
		
		// Calculating profit
		double profit = sellingPrice - costPrice;
		
		// Calculating profit percentage
		double profitPercentage = profit / costPrice * 100;
		
		// Displaying result
		System.out.println("The Cost Price is INR " +costPrice+ " and Selling Price is INR " +sellingPrice+ "\nThe Profit is INR " +profit+ " and the Profit Percentage is " +profitPercentage);
	}
}
	