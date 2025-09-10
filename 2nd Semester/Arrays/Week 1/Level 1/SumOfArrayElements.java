import java.util.*;

// Class creation
class SumOfArrayElements{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the array
		double[] arr = new double[10];
		double sum = 0.0;
		
		// Taking the numbers from the user and printing the sum
		int index = 0;
		System.out.print("Enter the number 1: ");
		arr[index] = input.nextDouble();
		while(true){
			if(index > 8){
				break;
			}
			if(arr[index] <= 0){
				break;
			}
			else{
				index++;
				System.out.print("Enter the number " + (index+1) + ": ");
				arr[index] = input.nextDouble();
			}
		}
		
		for(int i=0; i<10; i++){
			sum += arr[i];
		}
		
		System.out.println("Sum of all the elements of the array: " + sum);
		input.close();
	}
}
