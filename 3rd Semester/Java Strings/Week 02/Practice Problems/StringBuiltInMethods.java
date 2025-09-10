public class StringBuiltInMethods{
    public static void main(String[] args){
        String sampleText=" Java Programming is Fun and Challenging! ";

        System.out.println("====== String Built-in Methods Demo ======\n");

        System.out.println("1. Original length (with spaces): "+sampleText.length());

        String trimmedText=sampleText.trim();
        System.out.println("2. After trim: \""+trimmedText+"\" (length = "+trimmedText.length()+")");

        System.out.println("3. Character at index 5: "+sampleText.charAt(5));

        String substring=sampleText.substring(6,17);
        System.out.println("4. Substring (Programming): "+substring);

        System.out.println("5. Index of 'Fun': "+sampleText.indexOf("Fun"));

        System.out.println("6. Contains 'Java': "+sampleText.contains("Java"));

        System.out.println("7. Starts with 'Java' after trimming: "+trimmedText.startsWith("Java"));

        System.out.println("8. Ends with '!': "+sampleText.endsWith("!"));

        System.out.println("9. Uppercase: "+sampleText.toUpperCase());

        System.out.println("10. Lowercase: "+sampleText.toLowerCase());

        int vowelCount=countVowels(sampleText);
        System.out.println("\nExtra 1: Vowel count = "+vowelCount);

        System.out.print("Extra 2: Occurrences of 'a' at positions: ");
        findAllOccurrences(sampleText,'a');
    }

    public static int countVowels(String text){
        int count=0;
        String vowels="AEIOUaeiou";

        for(int i=0; i<text.length(); i++){
            char c=text.charAt(i);
            if(vowels.indexOf(c)!=-1){
                count++;
            }
        }
        return count;
    }

    public static void findAllOccurrences(String text, char target){
        boolean found=false;

        for(int i=0; i<text.length(); i++){
            if(text.charAt(i)==target){
                System.out.print(i+" ");
                found=true;
            }
        }
        if(!found){
            System.out.print("None");
        }
        System.out.println();
    }
}
