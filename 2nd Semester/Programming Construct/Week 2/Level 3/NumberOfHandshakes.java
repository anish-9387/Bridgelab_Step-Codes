import java.util.*;

// Class creation
class NumberOfHandshakes{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Creating the variables for number of students
		int numberOfStudents;
		
		// Taking input from the user
		System.out.print("Enter the number of students: ");
		numberOfStudents = input.nextInt();
		
		// Calculating the number of handshakes
		int numberOfHandshakes = (numberOfStudents * (numberOfStudents - 1)) / 2;
		
		// Printing the result
		System.out.println("Total number of possible handshakes is " + numberOfHandshakes);
		
		input.close();
	}
}
