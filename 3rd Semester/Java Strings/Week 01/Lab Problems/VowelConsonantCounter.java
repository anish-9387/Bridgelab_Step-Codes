import java.util.Scanner;

public class VowelConsonantCounter{
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

    public static int[] countVowelsConsonants(String str){
        int vowels=0, consonants=0;

        for(int i=0; i<str.length(); i++){
            char ch=str.charAt(i);
            String type=checkCharType(ch);

            if(type.equals("Vowel")){
                vowels++;
            }
            else if(type.equals("Consonant")){
                consonants++;
            }
        }
        return new int[]{vowels,consonants};
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a string:");
        String str=input.nextLine();
        int[] result=countVowelsConsonants(str);

        System.out.println("\n------ RESULT ------");
        System.out.println("Vowels: "+result[0]);
        System.out.println("Consonants: "+result[1]);
        input.close();
    }
}
