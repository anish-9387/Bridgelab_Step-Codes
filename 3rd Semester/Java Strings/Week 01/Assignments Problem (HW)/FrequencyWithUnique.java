import java.util.Scanner;

public class FrequencyWithUnique{
    public static char[] uniqueCharacters(String text){
        int length=text.length();
        char[] temp=new char[length];
        int uniqueCount=0;

        for(int i=0; i<length; i++){
            char c=text.charAt(i);
            boolean isUnique=true;

            for(int j=0; j<uniqueCount; j++){
                if(temp[j]==c){
                    isUnique=false;
                    break;
                }
            }

            if(isUnique){
                temp[uniqueCount]=c;
                uniqueCount++;
            }
        }

        char[] uniqueChars=new char[uniqueCount];
        for(int i=0; i<uniqueCount; i++){
            uniqueChars[i]=temp[i];
        }
        return uniqueChars;
    }

    public static String[][] findFrequency(String text){
        int[] freq=new int[256];

        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);
            freq[c]++;
        }

        char[] uniqueChars=uniqueCharacters(text);

        String[][] result=new String[uniqueChars.length][2];
        for (int i=0; i<uniqueChars.length; i++){
            result[i][0]=String.valueOf(uniqueChars[i]);
            result[i][1]=String.valueOf(freq[uniqueChars[i]]);
        }
        return result;
    }

    public static void displayFrequency(String[][] freqArr){
        System.out.println("\nCharacter Frequency:");
        System.out.println("----------------------");
        System.out.printf("%-10s %-10s%n", "Character", "Frequency");
        System.out.println("----------------------");

        for(String[] row : freqArr){
            System.out.printf("%-10s %-10s%n", row[0], row[1]);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str=input.nextLine();

        String[][] result=findFrequency(str);
        displayFrequency(result);
        input.close();
    }
}
