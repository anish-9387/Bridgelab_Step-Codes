// Class creation
class PercentageCalculator{
	public static void main(String[] args){
	
		// Creating the variables of marks
		double mathsMarks = 94.0;
		
		double physicsMarks = 95.0;
		
		double chemistryMarks = 96.0;
		
		// Calculating percentage
		double percentage = (mathsMarks + physicsMarks + chemistryMarks) / 300 * 100;
		
		// Displaying result
		System.out.println("Sam's average mark in PCM is " + percentage);
	}
}
