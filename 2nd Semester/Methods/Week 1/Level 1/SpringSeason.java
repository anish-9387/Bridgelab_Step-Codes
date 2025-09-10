import java.util.*;

// Class creation
class SpringSeason{	
	// Method to check whether it's spring season or not
	public static boolean isSpringSeason(int day, int month){
		if((day >= 20 && day <= 31 && month == 3) || (day >= 1 && day <= 30 && month == 4) ||		   
		   (day >= 1 && day <= 31 && month == 5) || (day >= 1 && day <= 20 && month == 6)){		   
			return true;
		}
		else{
			return false;
		}
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for day and month
		System.out.print("Enter the day: ");
		int day = input.nextInt();
		System.out.print("Enter the month: ");
		int month = input.nextInt();
		
		// Checking spring season and printing it
		boolean isSpring = isSpringSeason(day,month);
		if(isSpring == true)  System.out.println("It's a Spring season");
		else  System.out.println("Not a Spring Season");		
		input.close();
	}
}
