import java.util.regex.*;
import java.util.Scanner;

public class TrainConsistentManagementApp{
    public static boolean validateTrainID(String trainId){
        Pattern pattern=Pattern.compile("TRN-\\d{4}");
        Matcher matcher=pattern.matcher(trainId);
        return matcher.matches();
    }

    public static boolean validateCargoCode(String cargoCode){
        Pattern pattern=Pattern.compile("PET-[A-Z]{2}");
        Matcher matcher=pattern.matcher(cargoCode);
        return matcher.matches();
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter Train ID: ");
        String trainId=sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode=sc.nextLine();

        if (validateTrainID(trainId)){
            System.out.println("Train ID is VALID");
        }
	else{
            System.out.println("Train ID is INVALID");
        }

        if(validateCargoCode(cargoCode)){
            System.out.println("Cargo Code is VALID");
        }
	else{
            System.out.println("Cargo Code is INVALID");
        }

        sc.close();
    }
}