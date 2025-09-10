import java.util.Scanner;

public class FirstNonRepeatingChar{
    public static char findFirstNonRepeating(String text){
        int[] freq=new int[256];

        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);
            freq[c]++;
        }

        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);

            if(freq[c]==1){
                return c;
            }
        }
        return '\0';
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str=input.nextLine();

        char result=findFirstNonRepeating(str);

        if(result!='\0'){
            System.out.println("First Non-Repeating Character: "+result);
        }
        else{
            System.out.println("No non-repeating character found");
        }
        input.close();
    }
}
