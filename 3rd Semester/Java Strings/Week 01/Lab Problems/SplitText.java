import java.util.Scanner;

public class SplitText{
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

    public static String[] manualSplit(String text){
        int len=findLength(text);

        int spaceCount=0;
        for(int i=0; i<len; i++){
            if(text.charAt(i)==' '){
                spaceCount++;
            }
        }
        int wordCount=spaceCount+1;

        int[] spaceIndexes=new int[wordCount+1];
        int idx=0;
        spaceIndexes[idx++]=-1;

        for(int i=0; i<len; i++){
            if(text.charAt(i)==' '){
                spaceIndexes[idx++]=i;
            }
        }
        spaceIndexes[idx]=len;

        String[] words=new String[wordCount];

        for(int i=0; i<wordCount; i++){
            int start=spaceIndexes[i]+1;
            int end=spaceIndexes[i+1];

            StringBuilder word=new StringBuilder();

            for(int j=start; j<end; j++){
                word.append(text.charAt(j));
            }
            words[i]=word.toString();
        }
        return words;
    }

    public static boolean compareArrays(String[] arr1, String[] arr2){
        if(arr1.length!=arr2.length)  return false;

        for(int i=0; i<arr1.length; i++){
            if(!arr1[i].equals(arr2[i]))  return false;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.println("Enter a line of text: ");
        String line=input.nextLine();

        String[] manualWords=manualSplit(line);

        String[] builtInWords=line.split(" ");

        boolean same=compareArrays(manualWords,builtInWords);

        System.out.println("\n------ MANUAL SPLIT ------");
        for(String w : manualWords)  System.out.print("[" + w + "] ");

        System.out.println("\n\n------ BUILT-IN SPLIT ------");
        for(String w : builtInWords)  System.out.print("[" + w + "] ");

        System.out.println("\n\nArrays are equal? --> " + same);

        input.close();
    }
}
