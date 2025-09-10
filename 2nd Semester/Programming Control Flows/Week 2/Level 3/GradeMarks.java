import java.util.*;

// Class creation
class GradeRemarks{
	public static void main(String[] args){		
		Scanner input = new Scanner(System.in);
		
		// Creation of variables for marks of 3 subjects
		double phyMarks, chemMarks, mathsMarks;
		
		// Taking inputs from the user
		System.out.print("Enter marks of physics: ");
		phyMarks = input.nextDouble();
		System.out.print("Enter marks of chemistry: ");
		chemMarks = input.nextDouble();
		System.out.print("Enter marks of maths: ");
		mathsMarks = input.nextDouble();
		
		// Calculating the average marks and the grade and marks
		double avgMarks = (phyMarks + chemMarks + mathsMarks) / 3;
		double percentage = (phyMarks + chemMarks + mathsMarks) / 100 * 100;
		
		System.out.println("Average marks: " + avgMarks);		
		if(percentage >= 80){
			System.out.println("Grade: A");
			System.out.println("Remarks: Level 4, above agency-normalised standards");
		}
		else if(percentage >= 70){
			System.out.println("Grade: B");
			System.out.println("Remarks: Level 3, at agency-normalised standards");
		}
		else if(percentage >= 60){
			System.out.println("Grade: C");
			System.out.println("Remarks: Level 2, below agency-normalised standards");
		}
		else if(percentage >= 50){
			System.out.println("Grade: D");
			System.out.println("Remarks: Level 1, well below agency-normalised standards");
		}
		else if(percentage >= 40){
			System.out.println("Grade: E");
			System.out.println("Remarks: Level 1, too below agency-normalised standards");
		}
		else{
			System.out.println("Grade: R");
			System.out.println("Remarks: Remedial standards");
		}
		
		input.close();
	}
}
