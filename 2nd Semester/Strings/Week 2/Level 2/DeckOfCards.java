import java.util.*;

// Class creation
public class DeckOfCards{
    // Suits and ranks
    static String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    static String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
    
    // Method to initialize the deck
    public String[] initializeDeck(){
        int numOfCards = suits.length * ranks.length;
        String[] deck = new String[numOfCards];
        int idx = 0;

        for(String suit : suits){
            for(String rank : ranks){
                deck[idx++] = rank + " of " + suit;
            }
        }
        return deck;
    }

    // Method to shuffle the deck
    public void shuffleDeck(String[] deck){
        int n = deck.length;
        for(int i=0; i<n; i++){
            int randomCardNumber = i + (int)(Math.random() * (n - i));
            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }
    }

    // Method to distribute the deck
    public String[][] distributeCards(String[] deck, int n, int players){
        if(n % players != 0){
            System.out.println("Cannot distribute cards equally among players!");
            return null;
        }
        
        int cardsPerPlayer = n / players;
        String[][] distributedCards = new String[players][cardsPerPlayer];

        int idx = 0;
        for(int i=0; i<players; i++){
            for(int j=0; j<cardsPerPlayer; j++){
                distributedCards[i][j] = deck[idx++];
            }
        }
        return distributedCards;
    }

    // Method to print the cards each player has
    public void printPlayersCards(String[][] playersCards){
        if(playersCards == null){
            return;
        }
        for(int i=0; i<playersCards.length; i++){
            System.out.println("Player " + (i + 1) + " cards:");
            for(int j=0; j<playersCards[i].length; j++){
                System.out.println("  " + playersCards[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
		DeckOfCards obj = new DeckOfCards();

        String[] deck = obj.initializeDeck();
        obj.shuffleDeck(deck);

        // Taking number of cards to distribute and number of players from the user
        System.out.print("Enter number of cards to distribute: ");
        int n = input.nextInt();
        System.out.print("Enter number of players: ");
        int players = input.nextInt();

        if(n > deck.length){
            System.out.println("Not having enough cards in deck");
        }
		else{
            String[][] playersCards = obj.distributeCards(deck,n,players);
            obj.printPlayersCards(playersCards);
        }        
        input.close();
    }
}
