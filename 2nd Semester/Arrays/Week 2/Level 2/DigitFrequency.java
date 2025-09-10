import java.util.*;

// Class creation
class DigitFrequency{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        // Creation of variable for number
		System.out.print("Enter a number: ");
        int number = input.nextInt();

        // Calculating frequency of each digit in number
		int[] freq = new int[10];

        if(number < 0){
            number = -number;
        }

        while(number > 0){
            int digit = number % 10;
            freq[digit]++;
            number /= 10;
        }

        // Printing the frequency of each digit
		System.out.println("Digit Frequency:");
        for(int i=0; i<10; i++){
            if(freq[i] > 0){
                System.out.println("Digit " + i + " appears " + freq[i] + " times");
            }
        }

        input.close();
    }
}
