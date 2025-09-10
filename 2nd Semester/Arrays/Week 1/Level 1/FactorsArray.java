import java.util.*;

class FactorsArray{
    public static void main(String[] args){
		
        Scanner input = new Scanner(System.in);
        
        // Creation of the variable for number
        System.out.print("Enter a number: ");
        int number = input.nextInt();
        
        // Initialize array variables
        int maxFactor = 10, index = 0;
        int[] factors = new int[maxFactor];
        
        // Finding factors of number
        for(int i=1; i<=number; i++){
            if(number % i == 0){
                if(index == maxFactor){
                    maxFactor *= 2;   // Double the size of the array
                    int[] temp = new int[maxFactor];
					
                    for(int j=0; j<index; j++){
                        temp[j] = factors[j];
                    }
                    factors = temp;
                }
				
                factors[index] = i;
                index++;
            }
        }
        
        // Display the factors array
        System.out.println("The factors of " + number + " are:");
        for(int i=0; i<index; i++){
            System.out.print(factors[i] + " ");
        }
        
        input.close();
    }
}
