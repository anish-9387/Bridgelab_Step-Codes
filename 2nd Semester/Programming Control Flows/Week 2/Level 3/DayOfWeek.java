import java.util.*;

// Class creation
class DayOfWeek{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for month, day and year
		int day, month, year;
		
		// Taking the inputs from the user
		System.out.print("Enter the date in format (day-month-year): ");
		day = input.nextInt();
		month = input.nextInt();
		year = input.nextInt();
		
		// Calculating and printing the day of the week
		int y0 = year-(14-month)/12;
		int x = y0+y0/4-y0/100+y0/400;
		int m0 = month+12*((14-month)/12)-2;
		int d0 = (day+x+31*m0/12) % 7;
		
		System.out.println("Day on the given date is: " + d0);
		
		input.close();
	}
}
