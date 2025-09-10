import java.util.*;

// Class creation
class VoteEligibility{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation and taking input to the array
		int[] arr = new int[10];
		
		System.out.print("Enter the age of all 10 students: ");
		for(int i=0; i<10; i++){
			arr[i] = input.nextInt();
		}
		
		for(int i=0; i<10; i++){
			if(arr[i] < 0){
				System.out.println("Invalid Age");
			}
			else if(arr[i] >= 18){
				System.out.println("The student with the age " + arr[i] + " can vote");
			}
			else if(arr[i] >= 0 && arr[i] < 18){
				System.out.println("The student with the age " + arr[i] + " cannot vote");
			}
		}
		
		input.close();
	}
}
