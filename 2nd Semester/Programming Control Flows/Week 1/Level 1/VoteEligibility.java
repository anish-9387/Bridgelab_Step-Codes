import java.util.*;

// Class creation
class VoteEligiblity{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable
		int age;
		
		// Taking the input
		System.out.print("Enter the age: ");
		age = input.nextInt();
		
		// Calculating the sum of natural numbers
		if(age >= 18){
			System.out.println("The person's age is " + age + " and can vote");
		}
		else{
			System.out.println("The person's age is " + age + " and cannot vote");
		}
		
		input.close();
	}
}
