import java.util.*;

// Class creation
public class LeapYear{
	// Method to check whether year is leap year or not
	public void isLeapYear(int year){
		if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println("The year " + year + " is a leap year");
		}
		else{
			System.out.println("The year " + year + " is not a leap year");
		}
	}
	
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		LeapYear yr = new LeapYear();
		
		System.out.print("Enter a year (>= 1582): ");
		int year = input.nextInt();
		
		// Checking whether year is leap year or not
		if(year >= 1582)  yr.isLeapYear(year);
		else{
			System.out.println("Enter year greater than or equal to 1582");
			System.exit(1);
		}
		input.close();
	}
}
