/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package cardgame;

import java.util.ArrayList;
import java.util.Scanner;

import cardgame.entity.Card;
import cardgame.entity.Deck;
import cardgame.entity.Player;
import cardgame.service.GameService;

public class App {
   

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        // Create a new deck of cards and shuffle it
        Deck deck = new Deck();
        deck.shuffle();

        //System.out.println("\n    List of 52 Shuffle cards :\n");
        //deck.getDeck().forEach(c -> System.out.println("    "+c));
        //System.out.println(deck.getDeck().size());
        

        ArrayList<Player> players = new ArrayList<>();
        System.out.print("\n    Enter the number of players (2-4): \n");  // Get the number of players from the user
        int numPlayers = scanner.nextInt();

        // Create the players and deal them each 5 cards  
        for (int i = 1; i <= numPlayers; i++) {
            System.out.println("    Enter Player"+ i +" name : ");
            String name = scanner.next();

            Player player = new Player("Player "+name);
            for (int j = 0; j < 5; j++) {
                Card card = deck.deal();
                player.draw(card);
            }
            players.add(player);
        }

        //System.out.println(players);


        GameService game = new GameService(players, deck);
        game.playGame();
        
        scanner.close();
            
    }
}
