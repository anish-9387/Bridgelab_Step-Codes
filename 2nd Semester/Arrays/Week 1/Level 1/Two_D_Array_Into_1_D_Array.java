import java.util.*;

// Class creation
class Two_D_Array_Into_1_D_Array{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of a 2-D array
		System.out.print("Enter number of rows: ");
		int rows = input.nextInt();
		System.out.print("Enter number of columns: ");
		int columns = input.nextInt();
		
		int[][] matrix = new int[rows][columns];
		
		// Taking the input of 2-D array
		System.out.println("Enter the elements of the matrix:");
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				matrix[i][j] = input.nextInt();
			}
		}
		
		// Copying the elements from 2-D array into 1-D array
		int[] array = new int[rows*columns];
		
		int idx=0;
		for(int i=0; i<rows; i++){
			for(int j=0; j<columns; j++){
				array[idx] = matrix[i][j];
				idx++;
			}
		}
		
		// Printing the 1-D array
		System.out.print("Elements in 1-D array is: ");
		for(int i=0; i<idx; i++){
			System.out.print(array[i] + " ");
		}
		
		input.close();
	}
}
