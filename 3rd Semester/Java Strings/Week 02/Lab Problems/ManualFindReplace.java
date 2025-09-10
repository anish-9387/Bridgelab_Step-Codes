import java.util.ArrayList;
import java.util.Scanner;

public class ManualFindReplace{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter the main text:");
        String text=input.nextLine();

        System.out.println("Enter the substring to find:");
        String find=input.nextLine();

        System.out.println("Enter the substring to replace with:");
        String replace=input.nextLine();

        ArrayList<Integer> positions=findAllOccurrences(text,find);
        System.out.println("Found at positions: "+positions);

        String manualResult=manualReplace(text,find,replace);

        String builtInResult=text.replace(find,replace);
        boolean isSame=compareResults(manualResult,builtInResult);

        System.out.println("\n====== RESULTS ======");
        System.out.println("Original text:   "+text);
        System.out.println("Manual result:   "+manualResult);
        System.out.println("Built-in result: "+builtInResult);
        System.out.println("Both are same?   "+isSame);
        input.close();
    }

    public static ArrayList<Integer> findAllOccurrences(String text, String find){
        ArrayList<Integer> positions=new ArrayList<>();
        int index=text.indexOf(find);

        while(index!=-1){
            positions.add(index);
            index=text.indexOf(find,index+1);
        }
        return positions;
    }

    public static String manualReplace(String text, String find, String replace){
        StringBuilder result=new StringBuilder();
        int i=0;

        while(i<text.length()){
            if(i<=text.length()-find.length() && text.substring(i,i+find.length()).equals(find)){
                result.append(replace);
                i+=find.length();
            }
            else{
                result.append(text.charAt(i));
                i++;
            }
        }
        return result.toString();
    }

    public static boolean compareResults(String manual, String builtin){
        return manual.equals(builtin);
    }
}
