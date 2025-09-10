import java.util.*;

// Class creation
public class StudentVoteChecker{
	// Method to check whether the student can vote or not
	public boolean canStudentVote(int age){
		if(age < 0){
			System.out.println("Error! Age can't be negative");
			return false;
		}		
		else if(age >= 18)  return true;		
		else  return false;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		StudentVoteChecker sc = new StudentVoteChecker();
		
		// Taking the age from user and checks whether he/she can vote or not
		int[] age = new int[10];
		for(int i=0; i<10; i++){
			System.out.print("Enter age of " + (i + 1) + " student: ");
			age[i] = input.nextInt();
			
			boolean canVote = sc.canStudentVote(age[i]);
			if(canVote == true)  System.out.println("Can vote");
			else  System.out.println("Cannot vote");
		}		
		input.close();
	}
}
