import java.util.*;

// Class creation
public class NumberChecker4{	
	// Method to check if the number is prime or not
	public boolean checkPrimeNumber(int num){
		for(int i=2; i*i<num; i++){
			if(num % i == 0){
				return false;
			}
		}
		return true;
	}
	
	// Method to check if the number is neon or not
	public boolean checkNeonNumber(int num){
		int squareOfNum = num * num, sum = 0;
		while(squareOfNum != 0){
			int ld = squareOfNum % 10;
			sum += ld;
			squareOfNum /= 10;
		}
		if(sum == num)  return true;
		else  return false;
	}
	
	// Method to check if the number is spy or not
	public boolean checkSpyNumber(int num){
		int sum = 0, product = 1;
		while(num != 0){
			int ld = num % 10;
			sum += ld;
			product *= ld;
			num /= 10;
		}
		if(sum == product)  return true;
		else  return false;
	}
	
	// Method to check if the number is automorphic or not
	public boolean checkAutomorphicNumber(int num){
		int squareOfNum = num * num;
		if(squareOfNum % 10 == num)  return true;
		else  return false;
	}
	
	// Method to check if the number is buzz or not
	public boolean checkBuzzNumber(int num){
		if(num % 7 == 0 || num % 10 == 7)  return true;
		else  return false;
	}
	
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		
		// Instantiation of object
		NumberChecker4 obj = new NumberChecker4();
		
		System.out.print("Enter a number: ");
		int num = input.nextInt();
		
		// Displaying all the results
		System.out.println("Prime Number?: " + obj.checkPrimeNumber(num));
		System.out.println("Neon Number?: " + obj.checkNeonNumber(num));
		System.out.println("Spy Number?: " + obj.checkSpyNumber(num));
		System.out.println("Automorphic Number?: " + obj.checkAutomorphicNumber(num));
		System.out.println("Buzz Number?: " + obj.checkBuzzNumber(num));
		input.close();
	}
}
