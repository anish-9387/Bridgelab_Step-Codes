import java.util.*;

// Class creation
public class StudentsVotingEligiblity{
    // Method to generate random 2-digit ages for n students
    public int[] generateStudentAges(int n){
        int[] ages = new int[n];
        Random rand = new Random();

        for(int i=0; i<n; i++){
            ages[i] = rand.nextInt(90) + 10;
        }
        return ages;
    }

    // Method to check voting eligibility and return 2D array of age and eligibility
    public String[][] checkVoteEligibility(int[] ages){
        String[][] result = new String[ages.length][2];

        for(int i=0; i<ages.length; i++){
            int age = ages[i];
            result[i][0] = String.valueOf(age);

            if(age < 0){
                result[i][1] = "Invalid Age";
            }
			else if(age >= 18){
                result[i][1] = "true";
            }
			else{
                result[i][1] = "false";
            }
        }
        return result;
    }

    // Method to display 2D array in tabular format
    public void displayResults(String[][] data){
        System.out.println("\nStudent\tAge\t\tCan Vote");
        System.out.println("----------------------------");
        for(int i=0; i<data.length; i++){
            System.out.println((i + 1) + "\t" + data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args){
		StudentsVotingEligiblity obj = new StudentsVotingEligiblity();
		
        int numOfStudents = 10;

        int[] studentAges = obj.generateStudentAges(numOfStudents);

        String[][] eligibilityResult = obj.checkVoteEligibility(studentAges);

        // Displaying the results
        obj.displayResults(eligibilityResult);
    }
}
