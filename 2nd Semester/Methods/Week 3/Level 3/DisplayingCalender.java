import java.util.*;

// Class creation
public class DisplayingCalender{
    // Array for months
    static String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};

    // Array for number of days in each month
    static int[] daysInEachMonth = {31,28,31,30,31,30,31,31,30,31,30,31};

    // Method to get the name of month
    public static String getMonthName(int month){
        return months[month - 1];
    }

    // Method to get the number of days in the month
    public static int getNumberOfDays(int month, int year){
        if(month == 2 && isLeapYear(year)){
            return 29;
        }
		else{
            return daysInEachMonth[month - 1];
        }
    }

    // Method to check for leap year
    public static boolean isLeapYear(int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Method to get the first day of the month using Gregorian calendar algorithm
    public static int getStartDay(int day, int month, int year){
        int y0 = year - (14 - month) / 12;
        int x = y0 + y0 / 4 - y0 / 100 + y0 / 400;
        int m0 = month + 12 * ((14 - month) / 12) - 2;
        int d0 = (day + x + (31 * m0) / 12) % 7;
        return d0;
    }

    // Method to display the calender
    public void displayCalendar(int month, int year){
        String monthName = getMonthName(month);
        int days = getNumberOfDays(month,year);
        int startDay = getStartDay(1,month,year);

        System.out.printf("%s %d\n", monthName,year);
        System.out.println("Sun Mon Tue Wed Thu Fri Sat");

        // Indentation for the first day
        for(int i=0; i<startDay; i++){
            System.out.print("    ");
        }

        // Printing all days of the month
        for(int day=1; day<=days; day++){
            System.out.printf("%3d ",day);
            if((day + startDay) % 7 == 0){
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		DisplayingCalender obj = new DisplayingCalender();

        System.out.print("Enter month (MM): ");
        int month = input.nextInt();
        System.out.print("Enter year (YYYY): ");
        int year = input.nextInt();
		
        obj.displayCalendar(month, year);
		input.close();
    }
}
