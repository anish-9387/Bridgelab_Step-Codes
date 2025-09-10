import java.util.Scanner;

public class ShortestLongestWord{
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

    public static String[][] wordsWithLengths(String[] words){
        int n=words.length;
        String[][] result=new String[n][2];

        for(int i=0; i<n; i++){
            result[i][0]=words[i];
            result[i][1]=String.valueOf(findLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestLongest(String[][] arr){
        int shortestIdx=0, longestIdx=0;
        int shortestLen=Integer.parseInt(arr[0][1]);
        int longestLen=Integer.parseInt(arr[0][1]);

        for(int i=1; i<arr.length; i++){
            int length=Integer.parseInt(arr[i][1]);

            if(length<shortestLen){
                shortestLen=length;
                shortestIdx=i;
            }
            if(length>longestLen){
                longestLen=length;
                longestIdx=i;
            }
        }
        return new int[]{shortestIdx,longestIdx};
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        System.out.println("Enter a line of text:");
        String line=input.nextLine();

        String[] words=manualSplit(line);

        String[][] table=wordsWithLengths(words);

        int[] result=findShortestLongest(table);

        System.out.println("\nWord\t\tLength");
        System.out.println("-------------------------");

        for(int i=0; i<table.length; i++){
            System.out.println(table[i][0]+"\t\t"+Integer.parseInt(table[i][1]));
        }

        System.out.println("\nShortest word: "+table[result[0]][0]+" (Length = "+table[result[0]][1]+")");
        System.out.println("Longest word: "+table[result[1]][0]+" (Length = "+table[result[1]][1]+")");

        input.close();
    }
}
