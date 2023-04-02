package cardgame.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import cardgame.entity.Deck;
import cardgame.entity.Player;

public class GameServiceTest {
    private List<Player> players;
    private Deck deck;
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        players = new ArrayList<Player>(Arrays.asList(
            new Player("Alice"),
            new Player("Bob"),
            new Player("Charlie")
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
}


