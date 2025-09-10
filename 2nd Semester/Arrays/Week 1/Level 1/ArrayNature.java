import java.util.*;

// Class creation
class ArrayNature{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Creation of the integer array
		int[] nums=new int[5];
		
		// Taking the input from the user
		System.out.print("Enter the numbers: ");
		for(int i=0; i<5; i++){
			nums[i] = input.nextInt();
		}
		
		// Checking for odd and even
		for(int i=0; i<5; i++){
			if(nums[i] > 0){
				if(nums[i] % 2 == 0){
					System.out.println(nums[i] + " is an even number");
				}
				else{
					System.out.println(nums[i] + " is a odd number");
				}
			}
			else if(nums[i] < 0){
				System.out.println(nums[i] + " is a negative number");
			}
			else{
				System.out.println(nums[i] + " is equal to zero");
			}
		}
		
		// Comparing the first and last numbers of the array
		if(nums[0] > nums[4]){
			System.out.println("First element is greater than the last");
		}
		else if(nums[0] < nums[4]){
			System.out.println("First element is smaller than the last");
		}
		else{
			System.out.println("First element is equal to the last");
		}
		
		input.close();
	}
}
