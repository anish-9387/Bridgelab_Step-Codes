import java.util.*;

public class PasswordStrengthAnalyzer{
    public static int[] analyzePassword(String password){
        int upper=0, lower=0, digits=0, special=0;

        for(int i=0; i<password.length(); i++){
            int ascii=password.charAt(i);

            if(ascii>=65 && ascii<=90)  upper++;
            else if(ascii>=97 && ascii<=122)  lower++;
            else if(ascii>=48 && ascii<=57)  digits++;
            else if(ascii>=33 && ascii<=126)  special++;
        }
        return new int[]{upper,lower,digits,special};
    }

    public static int calculateScore(String password, int[] counts){
        int length=password.length();
        int score=0;

        if(length>8)  score+=(length-8)*2;

        if(counts[0]>0)  score+=10;
        if(counts[1]>0)  score+=10;
        if(counts[2]>0)  score+=10;
        if(counts[3]>0)  score+=10;

        String lowerPass=password.toLowerCase();
        String[] weakPatterns={"123","abc","qwerty","password"};

        for(String p : weakPatterns){
            if(lowerPass.contains(p))  score-=10;
        }
        return score;
    }

    public static String getStrengthLevel(int score){
        if(score<=20)  return "Weak";
        else if(score<=50)  return "Medium";
        else  return "Strong";
    }

    public static String generatePassword(int length){
        if(length<4)  length=8;

        Random rand=new Random();
        StringBuilder sb=new StringBuilder();

        sb.append((char)(65+rand.nextInt(26)));
        sb.append((char)(97+rand.nextInt(26)));
        sb.append((char)(48+rand.nextInt(10)));
        sb.append((char)(33+rand.nextInt(15)));

        for(int i=4; i<length; i++){
            sb.append((char)(33+rand.nextInt(94)));
        }

        List<Character> chars=new ArrayList<>();

        for(int i=0; i<sb.length(); i++){
            chars.add(sb.charAt(i));
        }
        Collections.shuffle(chars);
        StringBuilder shuffled=new StringBuilder();

        for(char c : chars)  shuffled.append(c);

        return shuffled.toString();
    }

    public static void displayResults(String[] passwords){
        System.out.printf("%-15s %-7s %-7s %-7s %-7s %-12s %-7s %-10s%n","Password","Length","Upper","Lower","Digits","SpecialChars","Score","Strength");
        System.out.println("----------------------------------------------------------------------------------");

        for(String password : passwords){
            int[] counts=analyzePassword(password);
            int score=calculateScore(password,counts);
            String strength=getStrengthLevel(score);

            System.out.printf("%-15s %-7d %-7d %-7d %-7d %-12d %-7d %-10s%n", password, password.length(), counts[0], counts[1], counts[2], counts[3], score, strength);
        }
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter number of passwords to analyze: ");
        int n=input.nextInt();
        input.nextLine();
        String[] passwords=new String[n];

        System.out.println("Enter passwords:");
        for(int i=0; i<n; i++){
            passwords[i]=input.nextLine().trim();
        }

        displayResults(passwords);

        System.out.println("\nEnter desired length for a new strong password:");
        int len=input.nextInt();
        String newPass=generatePassword(len);
        System.out.println("Generated Strong Password: "+newPass);

        input.close();
    }
}
