import java.util.regex.*;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * UC10: Validate Train ID & Cargo Code using Regex
 */
public class TrainValidationApp{
    public static boolean isValidTrainID(String trainId){
        String trainPattern="TRN-\\d{4}";
        return Pattern.matches(trainPattern, trainId);
    }

    public static boolean isValidCargoCode(String cargoCode){
        String cargoPattern="PET-[A-Z]{2}";
        return Pattern.matches(cargoPattern, cargoCode);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" UC10: Train & Cargo Validation ");
        System.out.println("=================================\n");

        System.out.print("Enter Train ID: ");
        String trainId=sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode=sc.nextLine();

        if(isValidTrainID(trainId))
            System.out.println("Valid Train ID");
        else
            System.out.println("Invalid Train ID");

        if (isValidCargoCode(cargoCode))
            System.out.println("Valid Cargo Code");
        else
            System.out.println("Invalid Cargo Code");

        sc.close();
    }
}

/* =====================================================
   JUNIT TEST CLASS (Same File)
   ===================================================== */
class TrainValidationTest{
    @Test
    void testRegex_ValidTrainID(){
        assertTrue(TrainValidationApp.isValidTrainID("TRN-1234"));
    }

    @Test
    void testRegex_InvalidTrainIDFormat(){
        assertFalse(TrainValidationApp.isValidTrainID("TRAIN12"));
        assertFalse(TrainValidationApp.isValidTrainID("TRN12A"));
        assertFalse(TrainValidationApp.isValidTrainID("1234-TRN"));
    }

    @Test
    void testRegex_ValidCargoCode(){
        assertTrue(TrainValidationApp.isValidCargoCode("PET-AB"));
    }

    @Test
    void testRegex_InvalidCargoCodeFormat(){
        assertFalse(TrainValidationApp.isValidCargoCode("PET-ab"));
        assertFalse(TrainValidationApp.isValidCargoCode("PET123"));
        assertFalse(TrainValidationApp.isValidCargoCode("AB-PET"));
    }

    @Test
    void testRegex_TrainIDDigitLengthValidation(){
        assertFalse(TrainValidationApp.isValidTrainID("TRN-123"));
        assertFalse(TrainValidationApp.isValidTrainID("TRN-12345"));
    }

    @Test
    void testRegex_CargoCodeUppercaseValidation(){
        assertFalse(TrainValidationApp.isValidCargoCode("PET-Ab"));
        assertFalse(TrainValidationApp.isValidCargoCode("PET-aB"));
    }

    @Test
    void testRegex_EmptyInputHandling(){
        assertFalse(TrainValidationApp.isValidTrainID(""));
        assertFalse(TrainValidationApp.isValidCargoCode(""));
    }

    @Test
    void testRegex_ExactPatternMatch(){
        assertFalse(TrainValidationApp.isValidTrainID("TRN-1234X"));
        assertFalse(TrainValidationApp.isValidCargoCode("PET-ABC"));
    }
}