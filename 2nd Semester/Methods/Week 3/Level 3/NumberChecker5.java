import java.util.*;

// Class creation
public class NumberChecker5{
    // Method to find factors of a number and return them as an array
    public int[] findFactors(int num){
        int count = 0;
        for(int i=1; i<=num; i++){
            if(num% i == 0)  count++;
        }

        int[] factors = new int[count];
        int idx = 0;
        for(int i=1; i<=num; i++){
            if(num % i == 0){
                factors[idx++] = i;
            }
        }
        return factors;
    }

    // Method to find the greatest factor of the number
    public int findGreatestFactor(int[] factors, int num){
        int greatest = 1;
        for(int factor : factors){
            if(factor != num && factor > greatest){
                greatest = factor;
            }
        }
        return greatest;
    }

    // Method to find the sum of factors of the number
    public int sumOfFactors(int[] factors){
        int sum = 0;
        for(int factor : factors){
            sum += factor;
        }
        return sum;
    }

    // Method to find the product of factors of the number
    public long productOfFactors(int[] factors){
        long product = 1;
        for(int factor : factors){
            product *= factor;
        }
        return product;
    }

    // Method to find product of cube of the factors
    public long productOfCubeOfFactors(int[] factors){
        long product = 1;
        for(int factor : factors){
            product *= (long)Math.pow(factor, 3);
        }
        return product;
    }

    // Method to Check if a number is a perfect number
    public boolean isPerfectNumber(int num){
        int sum = 0;
        for(int i=1; i<num; i++){
            if(num % i == 0)   sum += i;
        }
        return sum == num;
    }

    // Method to find the number is an abundant number
    public boolean isAbundantNumber(int num){
        int sum = 0;
        for(int i=1; i<num; i++){
            if(num % i == 0)   sum += i;
        }
        return sum > num;
    }

    // Method to find the number is a deficient number
    public boolean isDeficientNumber(int num){
        int sum = 0;
        for(int i=1; i<num; i++){
            if(num % i == 0)   sum += i;
        }
        return sum < num;
    }

    // Method to check if a number is a strong number
    public boolean isStrongNumber(int num){
        int sum = 0, orgNum = num;
        while(orgNum > 0){
            int digit = orgNum % 10;
            sum += factorial(digit);
            orgNum /= 10;
        }
        return sum == num;
    }
	
	public static int factorial(int num){
		int fact = 1;
		for(int i=1; i<=num; i++){
			fact *= i;
		}
		return fact;
	}
	
    public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		NumberChecker5 obj = new NumberChecker5();
		
        System.out.print("Enter a number: ");
		int num = input.nextInt();
        int[] factors = obj.findFactors(num);

        System.out.println("Factors of " + num + ": " + Arrays.toString(factors));
        System.out.println("Greatest factor: " + obj.findGreatestFactor(factors, num));
        System.out.println("Sum of factors: " + obj.sumOfFactors(factors));
        System.out.println("Product of factors: " + obj.productOfFactors(factors));
        System.out.println("Product of cubes of factors: " + obj.productOfCubeOfFactors(factors));
        System.out.println("Is Perfect Number?: " + obj.isPerfectNumber(num));
        System.out.println("Is Abundant Number?: " + obj.isAbundantNumber(num));
        System.out.println("Is Deficient Number?: " + obj.isDeficientNumber(num));
        System.out.println("Is Strong Number?: " + obj.isStrongNumber(num));
		
		input.close();
    }
}
