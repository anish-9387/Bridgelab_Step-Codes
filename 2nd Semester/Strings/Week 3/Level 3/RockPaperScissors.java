import java.util.*;

// Class creation
public class RockPaperScissors{
    // Method to get computer's random choice
    public String getComputerChoice(){
        int choice = (int)(Math.random() * 3);
        switch(choice){
            case 0: return "rock";
            case 1: return "paper";
            case 2: return "scissors";
            default: return "";
        }
    }

    // Method to determine winner
    public String determineWinner(String user, String computer){
        if(user.equals(computer))   return "Draw";

        if((user.equals("rock") && computer.equals("scissors")) ||
            (user.equals("scissors") && computer.equals("paper")) ||
            (user.equals("paper") && computer.equals("rock"))){
            return "User";
        }
		else{
            return "Computer";
        }
    }

    // Method to calculate summary: user wins, computer wins, draws, percentages
    public String[][] calculateStats(int userWins, int computerWins, int draws, int totalGames){
        String[][] stats = new String[3][3];

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", (userWins * 100.0) / totalGames) + "%";

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(computerWins);
        stats[1][2] = String.format("%.2f", (computerWins * 100.0) / totalGames) + "%";

        stats[2][0] = "Draws";
        stats[2][1] = String.valueOf(draws);
        stats[2][2] = String.format("%.2f", (draws * 100.0) / totalGames) + "%";
        return stats;
    }

    // Method to display game results
    public void displayGameResults(String[][] gameResults, String[][] stats){
        System.out.println("\nGame\tUser\t\t\tComputer\t\tWinner");
        System.out.println("-------------------------------------------");
        for(int i=0; i<gameResults.length; i++){
            System.out.println((i + 1) + "\t" + gameResults[i][0] + "\t\t\t" + gameResults[i][1] + "\t\t" + gameResults[i][2]);
        }

        System.out.println("\nSummary Statistics:");
        System.out.println("Player\t\t\tWins\tWin %");
        System.out.println("---------------------------");
        for(int i=0; i<stats.length; i++){
            System.out.println(stats[i][0] + "\t\t\t" + stats[i][1] + "\t" + stats[i][2]);
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		RockPaperScissors obj = new RockPaperScissors();
		
        String[] validChoices = {"rock", "paper", "scissors"};

        System.out.print("Enter number of games to play: ");
        int totGames = input.nextInt();
        input.nextLine();

        String[][] gameResults = new String[totGames][3];
        int userWins = 0, computerWins = 0, draws = 0;

        for(int i=0; i<totGames; i++){
            System.out.print("Game " + (i + 1) + " --> Enter your choice (rock/paper/scissors): ");
            String userChoice = input.nextLine().toLowerCase();

            boolean valid = false;
            for(String choice : validChoices){
                if(userChoice.equals(choice)){
                    valid = true;
                    break;
                }
            }

            if(!valid){
                System.out.println("Invalid choice!! Next round begins");
                gameResults[i][0] = "Invalid";
                gameResults[i][1] = "-";
                gameResults[i][2] = "Skipped";
                continue;
            }

            String computerChoice = obj.getComputerChoice();
            String winner = obj.determineWinner(userChoice,computerChoice);

            gameResults[i][0] = userChoice;
            gameResults[i][1] = computerChoice;
            gameResults[i][2] = winner;

            if(winner.equals("User"))   userWins++;
            else if(winner.equals("Computer"))   computerWins++;
            else   draws++;
        }
        String[][] stats = obj.calculateStats(userWins,computerWins,draws,totGames);
        obj.displayGameResults(gameResults, stats);
        input.close();
    }
}
