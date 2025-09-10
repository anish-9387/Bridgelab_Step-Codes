import java.util.*;

// Class creation
public class Calendar{
    // Method to get the name of the month
    public String getMonthName(int month){
        String[] months = {"","January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[month];
    }

    // Method to check if a year is a leap year
    public boolean isLeapYear(int year){
        if((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)){
            return true;
        }
        return false;
    }

    // Method to get number of days in a month
    public int getNumberOfDaysInMonth(int month, int year){
        int[] days = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if(month == 2 && isLeapYear(year)){
            return 29;
        }
        return days[month];
    }

    // Method to get the first day of the month using Gregorian calendar algorithm
    public int getFirstDayOfMonth(int month, int year){
        int d = 1;
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (d + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // Method to display the calendar
    public void displayCalendar(int month, int year){
        System.out.println(getMonthName(month) + " " + year);
        System.out.println("Su Mo Tu We Th Fr Sa");

        int startDay = getFirstDayOfMonth(month, year);
        int numDays = getNumberOfDaysInMonth(month, year);

        for(int i=0; i<startDay; i++){
            System.out.print("   ");
        }

        for(int day=1; day<=numDays; day++){
            System.out.printf("%3d", day);

            if((day + startDay) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		Calendar obj = new Calendar();

        // Taking input from the user
        System.out.print("Enter month (1-12): ");
        int month = input.nextInt();
        System.out.print("Enter year: ");
        int year = input.nextInt();

        // Displaying calender
        obj.displayCalendar(month, year);
        input.close();
    }
}
