import java.util.*;

// Class creation
public class StudentScoreCard{
    public int[][] generateScores(int n){
        int[][] scores = new int[n][3];
        Random rand = new Random();

        for(int i=0; i<n; i++){
            scores[i][0] = rand.nextInt(41) + 60;
            scores[i][1] = rand.nextInt(41) + 60;
            scores[i][2] = rand.nextInt(41) + 60;
        }
        return scores;
    }

    // Calculate total, average, and percentage for each student
    public double[][] calculateResults(int[][] scores){
        int n = scores.length;
        double[][] results = new double[n][3];

        for(int i=0; i<n; i++){
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            results[i][0] = total;
            results[i][1] = Math.round(average * 100.0) / 100.0;
            results[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return results;
    }

    // Method to assign grade based on percentage
    public String[] assignGrades(double[][] results){
        int n = results.length;
        String[] grades = new String[n];

        for(int i=0; i<n; i++){
            double percentage = results[i][2];

            if(percentage >= 90)   grades[i] = "A";
            else if(percentage >= 80)   grades[i] = "B";
            else if(percentage >= 70)   grades[i] = "C";
            else if(percentage >= 60)   grades[i] = "D";
            else if(percentage >= 50)   grades[i] = "E";
            else   grades[i] = "F";
        }
        return grades;
    }

    // Display the scorecard in tabular format
    public void displayScorecard(int[][] scores, double[][] results, String[] grades){
        System.out.println("Stu\tPhy\tChem\tMath\tTotal\tAvg\t%\tGrade");
        System.out.println("---------------------------------------------------------------");

        for(int i=0; i<scores.length; i++){
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f\t%s\n",(i + 1),scores[i][0],scores[i][1],scores[i][2],results[i][0],results[i][1],results[i][2],grades[i]);
        }
    }

    public static void main(String[] args){
		StudentScoreCard obj = new StudentScoreCard();
		
        int numOfStudents = 10;

        int[][] scores = obj.generateScores(numOfStudents);
        double[][] results = obj.calculateResults(scores);
        String[] grades = obj.assignGrades(results);

		// Displaying the results
        obj.displayScorecard(scores, results, grades);
    }
}
