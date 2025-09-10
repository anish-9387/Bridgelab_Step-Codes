import java.util.*;

public class ASCIIProcessor{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str=input.nextLine();

        System.out.println("\n====== ASCII Character Analysis ======\n");

        for(char ch : str.toCharArray()){
            int ascii=(int)ch;
            System.out.println("Character: '"+ch+"' | ASCII: "+ascii);

            String type=classifyCharacter(ch);
            System.out.println("Type: "+type);

            if(Character.isLetter(ch)){
                char upper=Character.toUpperCase(ch);
                char lower=Character.toLowerCase(ch);
                System.out.println("Uppercase: "+upper+" ("+(int)upper+")");
                System.out.println("Lowercase: "+lower+" ("+(int)lower+")");
                System.out.println("Difference between cases: "+Math.abs((int)upper-(int)lower));
            }
            System.out.println();
        }

        System.out.println("====== ASCII Table (32-126) ======");
        displayASCIITable(32,126);

        int[] asciiArr=stringToASCII(str);
        System.out.println("\nASCII Array: "+Arrays.toString(asciiArr));
        String reconstructed=asciiToString(asciiArr);
        System.out.println("Reconstructed String: "+reconstructed);

        System.out.print("\nEnter shift value for Caesar Cipher: ");
        int shift=input.nextInt();
        String ciphered=caesarCipher(str,shift);
        System.out.println("Ciphered Text: "+ciphered);

        input.close();
    }

    public static String classifyCharacter(char ch){
        if(Character.isUpperCase(ch))  return "Uppercase Letter";
        else if(Character.isLowerCase(ch))  return "Lowercase Letter";
        else if(Character.isDigit(ch))  return "Digit";
        else  return "Special Character";
    }

    public static char toggleCase(char ch){
        if(Character.isUpperCase(ch)){
            return (char)(ch+32);
        }
        else if(Character.isLowerCase(ch)){
            return (char)(ch-32);
        }
        else{
            return ch;
        }
    }

    public static String caesarCipher(String text, int shift){
        StringBuilder result=new StringBuilder();

        for(char ch : text.toCharArray()){
            if(Character.isUpperCase(ch)){
                char c=(char)((ch-'A'+shift+26)%26+'A');
                result.append(c);
            }
            else if(Character.isLowerCase(ch)){
                char c=(char)((ch-'a'+shift+26)%26+'a');
                result.append(c);
            }
            else{
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void displayASCIITable(int start, int end){
        for(int i=start; i<=end; i++){
            System.out.printf("%3d : %c   ", i, (char)i);
            if((i-start+1)%8==0)  System.out.println();
        }
        System.out.println();
    }

    public static int[] stringToASCII(String text){
        int[] arr=new int[text.length()];

        for(int i=0; i<text.length(); i++){
            arr[i]=(int)text.charAt(i);
        }
        return arr;
    }

    public static String asciiToString(int[] asciiValues){
        StringBuilder sb=new StringBuilder();
        for(int val : asciiValues){
            sb.append((char)val);
        }
        return sb.toString();
    }
}
