import java.util.*;

// Class creation
class NumberOfHandshakes{	
	// Method to calculate the max number of possible handshakes
	public static int possibleHandshakes(int n){
		return (n * (n - 1)) / 2;
	}
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for number of students
		System.out.print("Enter the number of students: ");
		int numberOfStudents = input.nextInt();
		
		// Calculating number of handshakes and printing it
		int handshakes = possibleHandshakes(numberOfStudents);
		System.out.println("Max number of possible handshakes: " + handshakes);
		
		input.close();
	}
}
