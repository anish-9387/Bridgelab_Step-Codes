// Class creation
class CalculatingVolumeOfEarth{
	public static void main(String[] args){
		
		// Interconversion between km and miles ==> 1 km = 1.6 miles
		
		// Creating variable for storing the radius of the earth
		double radiusInKm = 6378;
		double radiusInMiles = radiusInKm * 1.6;
		
		double pi = 3.14159;
		
		// Calculating the volume of earth
		double volumeInCubicKm = 4/3 * pi * radiusInKm * radiusInKm * radiusInKm;
		double volumeInCubicMile = 4/3 * pi * radiusInMiles * radiusInMiles * radiusInMiles;
		
		// Displaying the result
		System.out.println("The volume of earth in cubic kilometers is " + volumeInCubicKm + " and cubic miles is " + volumeInCubicMile);
	}
}
