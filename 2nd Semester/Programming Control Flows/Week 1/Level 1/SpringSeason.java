import java.util.*;

// Class creation
class SpringSeason{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for day and month
		int day, month;
		
		// Taking the inputs from the user
		System.out.print("Enter the month and day (month day): ");		
		month = input.nextInt();
		day = input.nextInt();
		
		// Checking whether it is spring season or not
		if((month == 3 && day >= 20 && day <=31) || (month == 4 && day >= 1 && day <= 30) || (month == 5 && day >= 1 && day <= 31) || (month == 6 && day >= 1 && day <= 20)){
			System.out.println("It's a Spring Season");
		}
		else{
			System.out.println("Not a Spring Season");
		}
		
		input.close();
	}
}
