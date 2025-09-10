import java.util.Scanner;

public class UniqueCharacters{
    public static int findLength(String text){
        int count=0;

        try{
            while(true){
                text.charAt(count);
                count++;
            }
        }
        catch(Exception e){

        }
        return count;
    }

    public static char[] findUniqueChars(String text){
        int len=findLength(text);
        char[] temp=new char[len];
        int uniqueCount=0;

        for(int i=0; i<len; i++){
            char current=text.charAt(i);
            boolean isUnique=true;

            for(int j=0; j<uniqueCount; j++){
                if(temp[j]==current){
                    isUnique=false;
                    break;
                }
            }

            if(isUnique){
                temp[uniqueCount]=current;
                uniqueCount++;
            }
        }

        char[] result=new char[uniqueCount];
        for(int i=0; i<uniqueCount; i++){
            result[i]=temp[i];
        }
        return result;
    }

    public static void displayUniqueChars(char[] arr){
        System.out.print("Unique Characters: ");

        for(char c : arr){
            System.out.print(c+" ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str=input.nextLine();

        char[] unique=findUniqueChars(str);

        displayUniqueChars(unique);
        input.close();
    }
}
