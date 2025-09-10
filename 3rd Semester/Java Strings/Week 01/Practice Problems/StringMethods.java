import java.util.Scanner;

public class StringMethods{
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name=input.nextLine();
        System.out.print("Enter your favourite programming language: ");
        String language=input.next();
        input.nextLine();
        System.out.print("Enter your programming experience: ");
        String experience=input.nextLine();

        System.out.println("--------Formatted Summary--------");
        System.out.println("First name: "+name.split(" ")[0]);
        System.out.println("Last name: "+name.split(" ")[1]);

        int count=0;
        for(int i=0; i<experience.length(); i++){
            if(experience.charAt(i)==' ')  continue;
            else  count++;
        }
        System.out.println("Count of characters in sentence: "+count);
        System.out.println("Programming language in upper case: "+language.toUpperCase());
        input.close();
    }
}