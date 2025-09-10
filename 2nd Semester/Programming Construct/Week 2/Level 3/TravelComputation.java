import java.util.*;

// Class creation
class TravelComputation{   
    public static void main(String[] args){
	   
		Scanner input = new Scanner(System.in);

		// Creating variables for name, fromCity, viaCity and toCity
        String name, fromCity, viaCity, toCity;

		// Taking inputs from the user
		System.out.print("Enter the name: ");
		name = input.nextLine();
		System.out.print("Enter the source city: ");
		fromCity = input.nextLine();
		System.out.print("Enter the via city: ");
		viaCity = input.nextLine();
		System.out.print("Enter the destination city: ");
		toCity = input.nextLine();	  

		// Creating variables for distance between fromCity and viaCity, viaCity and toCity
		double fromToVia, viaToFinalCity;

		// Taking inputs from the user
		System.out.print("Enter the distance between fromCity and viaCity: ");
		fromToVia = input.nextDouble();
		System.out.print("Enter the distance between viaCity and toCity: ");
		viaToFinalCity = input.nextDouble();

		// Creating variables for time taken between fromCity and viaCity, viaCity and toCity
        int timeFromToVia, timeViaToFinalCity;

        // Taking inputs from the user
        System.out.print("Enter the time taken between fromCity and viaCity: ");
	    timeFromToVia = input.nextInt();
	    System.out.print("Enter the time taken between viaCity and toCity: ");
	    timeViaToFinalCity = input.nextInt();

		// Creating variables for total distance travelled and total time taken
		double totalDistance = fromToVia + viaToFinalCity;
		int totalTime = timeFromToVia + timeViaToFinalCity;

		// Printing the travelling result
		System.out.println("The Total Distance travelled by " + name + " from " + fromCity + " to " + toCity + " via " + viaCity + " is " +totalDistance + " km and " + "the Total Time taken is " + totalTime + " minutes");
		
		input.close();
   }
}
