import java.util.Scanner;

public class LengthOfString{
    public static int findLength(String str){
        int count=0;

        try{
            while(true){
                str.charAt(count);
                count++;
            }
        }
        catch(IndexOutOfBoundsException e){

        }
        return count;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str=input.next();

        int userDefinedLength=findLength(str);

        int builtInLength=str.length();

        System.out.println("\n------ STRING LENGTH ------");
        System.out.println("User-defined method length: " + userDefinedLength);
        System.out.println("Built-in length(): " + builtInLength);

        input.close();
    }
}
