import java.util.*;

// Class creation
public class GenerateOTP{
    // Method to generate a 6-digit OTP number
    public int generateOTP(){
        return (int)(100000 + Math.random() * 900000);
    }

    // Generate and store 10 OTPs in the form of array
    public int[] generateMultipleOTPs(int count){
        int[] otps = new int[count];
        for(int i=0; i<count; i++){
            otps[i] = generateOTP();
        }
        return otps;
    }

    // Method to ensure that the OTPs generated are unique
    public boolean areOTPsUnique(int[] otps){
        for(int i=0; i<otps.length; i++){
            for(int j=i+1; j<otps.length; j++){
                if(otps[i] == otps[j]){
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
		GenerateOTP obj = new GenerateOTP();
		
        int[] otpArray = obj.generateMultipleOTPs(10);

        System.out.println("Generated OTPs: " + Arrays.toString(otpArray));

        if(obj.areOTPsUnique(otpArray)){
            System.out.println("All OTPs are unique");
        }
		else{
            System.out.println("All OTPs are not unique");
        }
    }
}
