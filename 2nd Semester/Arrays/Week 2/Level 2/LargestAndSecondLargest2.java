import java.util.*;

// Class creation
class LargestAndSecondLargest2{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        
        // Creation of variable for number and taking input
        long num;
        System.out.print("Enter a number: ");
        num = input.nextLong();
        
        // Creation of the array for digits
        int maxDigit = 10, idx = 0;
        int[] arr = new int[maxDigit];
        
        while(num != 0){
            if(idx == maxDigit){
                // Increase size dynamically
                maxDigit += 10;
                int[] temp = new int[maxDigit];
                System.arraycopy(arr, 0, temp, 0, arr.length);
                arr = temp;
            }
            
            int lastDigit = (int)num % 10;
            arr[idx] = lastDigit;
            num /= 10;
            idx++;
        }
        
        // Finding the largest and second largest number
        int largest = 0, secLargest = 0;
        
        for(int i=0; i<idx; i++){
            if(arr[i] > largest){
                secLargest = largest;
                largest = arr[i];
            }
			else if(arr[i] > secLargest && arr[i] != largest){
                secLargest = arr[i];
            }
        }
        
        // Printing the result
        System.out.println("Largest number is: " + largest);
        System.out.println("Second largest number is: " + secLargest);
        
        input.close();
    }
}
