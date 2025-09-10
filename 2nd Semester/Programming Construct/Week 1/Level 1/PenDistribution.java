// Class creation
class PenDistribution{
	public static void main(String[] args){
		
		// Creating variable to store number of pens and students
		int pens = 14, students = 3;
		
		// Calculating number of pens that each student will get
		int numberOfPens = pens / students;
		
		// Calculating the number of non-distributed pens
		int nonDistributedPens = pens % students;
		
		// Displaying result
		System.out.println("The Pen Per Student is " + numberOfPens + " and the remaining pen not distributed is " + nonDistributedPens);
	}
}
