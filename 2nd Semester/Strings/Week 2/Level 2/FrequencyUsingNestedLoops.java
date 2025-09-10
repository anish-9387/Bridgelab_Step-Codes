import java.util.*;

// Class creation
public class FrequencyUsingNestedLoops{
    // Method to find frequency of characters using nested loops
    public String[] findFrequency(String str){
        char[] chars = str.toCharArray();
        int[] freq = new int[chars.length];

        for(int i=0; i<chars.length; i++){
            freq[i] = 1;
            for(int j=i+1; j<chars.length; j++){
                if(chars[i] == chars[j] && chars[i] != ' ' && chars[i] != '0'){
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] != ' ' && chars[i] != '0'){
                count++;
            }
        }

        String[] result = new String[count];
        int idx = 0;
        for(int i=0; i<chars.length; i++){
            if(chars[i] != ' ' && chars[i] != '0'){
                result[idx] = chars[i] + " : " + freq[i];
                idx++;
            }
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		FrequencyUsingNestedLoops obj = new FrequencyUsingNestedLoops();

        // Taking input from the user
        System.out.print("Enter a string: ");
        String str = input.nextLine();
		
        String[] frequencyData = obj.findFrequency(str);

        // Displaying the result
        System.out.println("Character : Frequency");
        System.out.println("----------------------");
        for(String s : frequencyData){
            System.out.println(s);
        }
        input.close();
    }
}
