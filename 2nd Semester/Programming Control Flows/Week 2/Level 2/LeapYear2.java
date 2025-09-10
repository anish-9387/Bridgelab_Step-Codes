import java.util.*;

// Class creation
class LeapYear2{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variable for the year
		int year;
		System.out.print("Enter the year: ");
		year = input.nextInt();
		
		// Logic for the leap year
		if(year >= 1582){
			if(year % 4 == 0 || (year % 100 == 0 && year % 400 == 0)){
					System.out.println("The year " + year + " is a leap year");
			}
			else{
				System.out.println("The year " + year + " is not a leap year");
			}
		}
		else{
			System.out.println("Invalid!! Enter the year after 1582");
		}
		
		input.close();
	}
}
