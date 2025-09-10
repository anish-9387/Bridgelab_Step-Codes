import java.util.Scanner;

public class ASCIICaseConverter{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a text:");
        String text=input.nextLine();

        String upperManual=toUpperCaseManual(text);
        String lowerManual=toLowerCaseManual(text);
        String titleManual=toTitleCaseManual(text);

        String upperBuiltIn=text.toUpperCase();
        String lowerBuiltIn=text.toLowerCase();
        String titleBuiltIn=toTitleCaseBuiltIn(text);

        System.out.println("\n====== CASE CONVERSION RESULTS ======");
        System.out.printf("%-20s %-40s %-40s\n", "Conversion", "Manual Result", "Built-in Result");
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("%-20s %-40s %-40s\n", "UPPERCASE", upperManual, upperBuiltIn);
        System.out.printf("%-20s %-40s %-40s\n", "lowercase", lowerManual, lowerBuiltIn);
        System.out.printf("%-20s %-40s %-40s\n", "Title Case", titleManual, titleBuiltIn);

        input.close();
    }

    public static char toUpperChar(char c){
        if(c>='a' && c<='z'){
            return (char)(c-32);
        }
        return c;
    }

    public static char toLowerChar(char c){
        if(c>='A' && c<='Z'){
            return (char)(c+32);
        }
        return c;
    }

    public static String toUpperCaseManual(String text){
        StringBuilder sb=new StringBuilder();

        for(char c : text.toCharArray()){
            sb.append(toUpperChar(c));
        }
        return sb.toString();
    }

    public static String toLowerCaseManual(String text){
        StringBuilder sb=new StringBuilder();

        for(char c : text.toCharArray()){
            sb.append(toLowerChar(c));
        }
        return sb.toString();
    }

    public static String toTitleCaseManual(String text){
        StringBuilder sb=new StringBuilder();
        boolean newWord=true;

        for(char c : text.toCharArray()){
            if(c==' ') {
                sb.append(c);
                newWord=true;
            }
            else{
                if(newWord){
                    sb.append(toUpperChar(c));
                    newWord=false;
                }
                else{
                    sb.append(toLowerChar(c));
                }
            }
        }
        return sb.toString();
    }

    public static String toTitleCaseBuiltIn(String text){
        String[] words=text.toLowerCase().split(" ");
        StringBuilder sb=new StringBuilder();

        for(String word : words){
            if(word.length()>0){
                sb.append(Character.toUpperCase(word.charAt(0)));
                sb.append(word.substring(1));
            }
            sb.append(" ");
        }
        return sb.toString().trim();
    }
}
