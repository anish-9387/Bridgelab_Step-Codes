public class StringManipulation{
    public static void main(String[] args){
        String str1="Java Programming";
        String str2=new String("Java Programming");
        char[] str3={'J','a','v','a',' ','P','r','o','g','r','a','m','m','i','n','g'};

        System.out.println("Comparing str1 and str2 using '==': "+(str1==str2));
        System.out.println("Comparing str1 and str2 using '.equals()': "+str1.equals(str2));

        System.out.print("Character array: ");
        for(int i=0; i<str3.length; i++){
            System.out.print(str3[i]+" ");
        }

        String string="Programmin Quote: \"Code is poetry\"";
        System.out.println("\nString with escape sequence: "+string);
    }
}