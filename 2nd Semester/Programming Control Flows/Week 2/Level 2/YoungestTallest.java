import java.util.*;

// Class creation
class YoungestTallest{
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		// Creation of the variables for the ages and heights of the 3 people
		int AmarAge, AkbarAge, AnthonyAge;
		double AmarHeight, AkbarHeight, AnthonyHeight;
		
		// Taking the inputs from the user
		System.out.print("Enter the ages of the three: ");
		AmarAge = input.nextInt();
		AkbarAge = input.nextInt();
		AnthonyAge = input.nextInt();
		
		System.out.print("Enter the heights (in cm) of the three: ");
		AmarHeight = input.nextDouble();
		AkbarHeight = input.nextDouble();
		AnthonyHeight = input.nextDouble();
		
		// Finding and printing the results
		int minAge = AmarAge;
        String youngest = "Amar";
        if(AkbarAge < minAge){
            minAge = AkbarAge;
            youngest = "Akbar";
        }
        if(AnthonyAge < minAge){
            minAge = AnthonyAge;
            youngest = "Anthony";
        }
        
        double maxHeight = AmarHeight;
        String tallest = "Amar";
        if(AkbarHeight > maxHeight){
            maxHeight = AkbarHeight;
            tallest = "Akbar";
        }
        if(AnthonyHeight > maxHeight){
            maxHeight = AnthonyHeight;
            tallest = "Anthony";
        }
		
		System.out.println("The youngest friend is " + youngest + " with age " + minAge + " years");
        System.out.println("The tallest friend is " + tallest + " with height " + maxHeight + " cm");
		
		input.close();
	}
}
