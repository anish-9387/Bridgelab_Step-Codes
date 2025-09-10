import java.util.*;

// Class creation
public class StudentReport{
    // Method to generate 2-digit PCM marks and return them as an array
    public int[][] generateMarks(int numOfStudents){
        int[][] marks = new int[numOfStudents][3];

        for(int i=0; i<numOfStudents; i++){
            marks[i][0] = (int)(Math.random() * 90) + 10;
            marks[i][1] = (int)(Math.random() * 90) + 10;
            marks[i][2] = (int)(Math.random() * 90) + 10;
        }
        return marks;
    }

    // Method to calculate the total, average, and percentages for each student
    public double[][] calculateScores(int[][] marks){
        int n = marks.length;
        double[][] results = new double[n][3];

        for(int i=0; i<n; i++){
            int total = marks[i][0] + marks[i][1] + marks[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            // Round to 2 decimal places
            results[i][0] = Math.round(total * 100.0) / 100.0;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to display the scorecard
    public void displayScorecard(int[][] marks, double[][] results){
        System.out.println("ID\tPhysics\tChemistry\tMaths\tTotal\tAverage\tPercentage");
        System.out.println("---------------------------------------------------------------");

        for(int i=0; i<marks.length; i++){
            System.out.printf("%d\t%d\t%d\t\t%d\t%.2f\t%.2f\t%.2f\n",(i + 1),marks[i][0],marks[i][1],marks[i][2],results[i][0],results[i][1],results[i][2]);
        }
    }
	
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		
		StudentReport obj = new StudentReport();

        // Taking number of students from the user
        System.out.print("Enter number of students: ");
        int n = input.nextInt();

        int[][] marks = obj.generateMarks(n);
        double[][] results = obj.calculateScores(marks);

        obj.displayScorecard(marks, results);
		input.close();
    }
}
