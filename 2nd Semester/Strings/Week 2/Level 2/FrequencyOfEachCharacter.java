import java.util.*;

// Class creation
public class FrequencyOfEachCharacter{
    // Method to find frequency of characters
    public String[][] findCharacterFrequency(String str){
        int[] frequency = new int[256]; 

        int len = str.length();
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            frequency[c]++;
        }

        String[][] result = new String[256][2];
		
        int idx = 0;
        boolean[] visited = new boolean[256];
        for(int i=0; i<len; i++){
            char c = str.charAt(i);
            if(!visited[c]){
                result[idx][0] = String.valueOf(c);
                result[idx][1] = String.valueOf(frequency[c]);
                visited[c] = true;
                idx++;
            }
        }

        String[][] ans = new String[idx][2];
        for(int i=0; i<idx; i++){
            ans[i][0] = result[i][0];
            ans[i][1] = result[i][1];
        }
        return ans;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		FrequencyOfEachCharacter obj = new FrequencyOfEachCharacter();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();

        String[][] frequencies = obj.findCharacterFrequency(str);

        // Displaying the result
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("-------------------------");
        for(int i=0; i<frequencies.length; i++){
            System.out.printf("%-10s %-10s%n", frequencies[i][0], frequencies[i][1]);
        }
        input.close();
    }
}
