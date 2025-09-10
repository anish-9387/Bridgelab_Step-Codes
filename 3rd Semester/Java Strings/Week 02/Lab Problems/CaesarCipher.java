import java.util.Scanner;

public class CaesarCipher{    
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);

        System.out.print("Enter text to encrypt: ");
        String text=input.nextLine();
        System.out.print("Enter shift value: ");
        int shift=input.nextInt();

        String encryptedText=encrypt(text,shift);

        String decryptedText=decrypt(encryptedText,shift);

        System.out.println("\n====== Caesar Cipher Encryption System ======");
        System.out.println("Original Text : "+text);
        displayAscii(text);

        System.out.println("\nEncrypted Text: "+encryptedText);
        displayAscii(encryptedText);

        System.out.println("\nDecrypted Text: "+decryptedText);
        displayAscii(decryptedText);

        if(validate(text,decryptedText)){
            System.out.println("\nValidation: Decryption successful (matches original text)");
        }
        else{
            System.out.println("\nValidation: Decryption failed (does not match original text)");
        }
        input.close();
    }

    public static String encrypt(String text, int shift){
        StringBuilder encrypted=new StringBuilder();

        for(int i=0; i<text.length(); i++){
            char ch=text.charAt(i);

            if(ch>='A' && ch<='Z'){
                ch=(char)((ch-'A'+shift)%26+'A');
            }
            else if(ch>='a' && ch<='z'){
                ch=(char)((ch-'a'+shift)%26+'a');
            }
            encrypted.append(ch);
        }
        return encrypted.toString();
    }

    public static String decrypt(String text, int shift){
        return encrypt(text, 26-(shift%26));
    }

    public static void displayAscii(String text){
        System.out.println("Character | ASCII Value");
        System.out.println("------------------------");

        for(int i=0; i<text.length(); i++){
            System.out.printf("    %c     |     %d\n", text.charAt(i), (int) text.charAt(i));
        }
    }

    public static boolean validate(String original, String decrypted){
        return original.equals(decrypted);
    }
}
