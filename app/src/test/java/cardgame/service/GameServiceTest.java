package cardgame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardgame.entity.Card;
import cardgame.entity.Deck;
import cardgame.entity.Player;
import cardgame.enums.Suit;
import cardgame.enums.Rank;

public class GameServiceTest {
    private List<Player> players;
    private Deck deck;
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<Player>(Arrays.asList(
            new Player("vaibhav"),
            new Player("Tushar"),
            new Player("Mayur")
        ));
        deck = new Deck();
        gameService = new GameService(players, deck);
    }

    @Test
    public void testGetDirection() {
        int expected = 1;
        int actual = gameService.getDirection();
        assertEquals(expected, actual);
    }

    @Test
    public void testDrawCard() {
        Player currentPlayer = players.get(0);
        int expectedHandSize = currentPlayer.getHand().size() + 1;
        gameService.drawCard(currentPlayer);
        int actualHandSize = currentPlayer.getHand().size();
        assertEquals(expectedHandSize, actualHandSize);
    }

    @Test
    public void testGetCurrentPlayer() {
        Player expected = players.get(0);
        Player actual = gameService.getCurrentPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNextPlayer() {
        Player expected = players.get(1);
        Player actual = gameService.getNextPlayer();
        assertEquals(expected, actual);
    }

    @Test
    public void testGetNextPlayerIndex() {
        int expected = 1;
        int actual = gameService.getNextPlayerIndex();
        assertEquals(expected, actual);
    }

    @Test
    public void testPlayCards() {
        // Create an instance of the GameService class with mock data
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        Deck deck = new Deck();
        GameService game = new GameService(players, deck);
    
        // Set up test scenario
        Card topCard = new Card(Rank.ACE, Suit.SPADES);
        game.getDiscardPile().add(topCard);
        Player currentPlayer = players.get(0);
        currentPlayer.draw(new Card(Rank.KING, Suit.CLUBS));
        currentPlayer.draw(new Card(Rank.ACE, Suit.CLUBS));
        currentPlayer.draw(new Card(Rank.TEN, Suit.HEARTS));
        
        // Call the playCards method
        boolean playedCard = game.playCards(currentPlayer);
    
        // Verify that a card was played and removed from the currentPlayer's hand
        assertTrue(playedCard);
        assertEquals(2, currentPlayer.getHand().size());
    
        // Verify that the discardPile has been updated correctly
        assertEquals(Rank.ACE, game.getDiscardPile().get(game.getDiscardPile().size() - 1).getRank());
        assertEquals(Suit.CLUBS, game.getDiscardPile().get(game.getDiscardPile().size() - 1).getSuit());
    }



    @Test
    public void testHandleSpecialCards_reverseDirection() {
        // Arrange
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        Deck deck = new Deck();
        deck.shuffle();
        GameService gameService = new GameService(players, deck);
        Card card = new Card(Rank.KING, Suit.SPADES);
        Player currentPlayer = players.get(0);
        int originalDirection = gameService.getDirection();

        // Act
        gameService.handleSpecialCards(currentPlayer, card);

        // Assert
        assertEquals(-1 * originalDirection, gameService.getDirection());
    }




   

    @Test
    public void testAceCard() {
        // create test player and card
        Player p1 = new Player("Vaibhav");
        Card aceCard = new Card(Rank.ACE, Suit.HEARTS);

        // create game service instance
        GameService gameService = new GameService(Arrays.asList(p1), new Deck());

        // call handleSpecialCards() with ace card
        gameService.handleSpecialCards(p1, aceCard);

        // assert that currentPlayerIndex is updated correctly
        assertEquals(1, gameService.getNextPlayerIndex()+1);
    }

    @Test
    public void testKingCard() {
        // create test player and card
        Player p1 = new Player("Vaibhav");
        Card kingCard = new Card(Rank.KING, Suit.HEARTS);

        // create game service instance
        GameService gameService = new GameService(Arrays.asList(p1), new Deck());

        // call handleSpecialCards() with king card
        gameService.handleSpecialCards(p1, kingCard);

        // assert that direction and currentPlayerIndex are updated correctly
        assertEquals(-1, gameService.getDirection());
        assertEquals(1, gameService.getNextPlayerIndex() + 1 );
    }

    @Test
    public void testQueenCard() {
        // create test players and card
        Player p1 = new Player("Vaibhav");
        Player p2 = new Player("Tushar");
        Card queenCard = new Card(Rank.QUEEN, Suit.HEARTS);

        // create game service instance
        GameService gameService = new GameService(Arrays.asList(p1, p2), new Deck());

        //gameService.getDeck().addCards(Arrays.asList(new Card(Rank.TWO, Suit.CLUBS), new Card(Rank.THREE, Suit.SPADES)));

        // call handleSpecialCards() with queen card
        gameService.handleSpecialCards(p1, queenCard);

        // assert that next player draws two cards
        assertEquals(2, p2.getHand().size());
    }
    
}


