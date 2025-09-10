import java.util.Scanner;

public class VowelConsonantType{
    public static String checkCharType(char ch){
        if(ch>='A' && ch<='Z'){
            ch=(char)(ch+32);
        }

        if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
            return "Vowel";
        }

        if(ch>='a' && ch<='z'){
            return "Consonant";
        }
        return "Not a Letter";
    }

    public static String[][] analyzeString(String str){
        int len=str.length();
        String[][] result=new String[len][2];

        for(int i=0; i<len; i++){
            char ch=str.charAt(i);
            result[i][0]=String.valueOf(ch);
            result[i][1]=checkCharType(ch);
        }
        return result;
    }

    public static void displayTable(String[][] arr){
        System.out.println("\nCharacter\tType");
        System.out.println("-------------------------");

        for(int i=0; i<arr.length; i++){
            System.out.println(arr[i][0]+"\t\t"+arr[i][1]);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a string:");
        String str=input.nextLine();
        String[][] table=analyzeString(str);

        displayTable(table);
        input.close();
    }
}
