import java.util.*;

// Class creation
class ReverseArray{
    public static void main(String[] args){
		
        Scanner input = new Scanner(System.in);
        
        // Creation of variable for number and taking input
		System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        int temp = number, count = 0;
        
        // Counting the number of digits in the number
		while(temp > 0){
            count++;
            temp /= 10;
        }
        
		// Creation of the array of digits
        int[] originalDigits = new int[count];
        temp = number;
        
        for(int i=count-1; i>=0; i--){
            originalDigits[i] = temp % 10;
            temp /= 10;
        }
        
		// Creation of the reverse array
		int[] reversedDigits = new int[count];
        for(int i=0; i<count; i++){
            reversedDigits[i] = originalDigits[count-1-i];
        }
        
		// Printing the reversed array
        System.out.print("The reversed array is: ");
        for(int digit : reversedDigits){
            System.out.print(digit + " ");
        }
        
        input.close();
    }
}
