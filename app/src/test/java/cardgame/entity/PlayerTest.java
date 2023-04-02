package cardgame.entity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cardgame.enums.Rank;
import cardgame.enums.Suit;

import java.util.ArrayList;
import java.util.List;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Vaibhav");
    }

    @Test
    @DisplayName(" Test will check card is added to the players hand ")
    void testDraw() {
        Card card = new Card(Rank.ACE, Suit.HEARTS);
        player.draw(card);
        List<Card> hand = player.getHand();
        Assertions.assertTrue(hand.contains(card));
    }

    @Test
    @DisplayName("Test will check the card is remove from hand ")
    void testRemoveCardFromHand() {
        Card card = new Card(Rank.TWO, Suit.CLUBS);
        player.draw(card);
        int index = 0;
        player.removeCardFromHand(index);
        List<Card> hand = player.getHand();
        Assertions.assertFalse(hand.contains(card));
    }

    @Test
    @DisplayName("Test will check list of card is allocated to player ")
    void testSetHand() {
        List<Card> hand = new ArrayList<>();
        hand.add(new Card(Rank.KING, Suit.SPADES));
        hand.add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        player.setHand(hand);
        Assertions.assertEquals(hand, player.getHand());
    }

    @Test
    @DisplayName("Test to get the name of the player")
    void testGetName() {
        Assertions.assertEquals("Vaibhav", player.getName());
    }

    @Test
    @DisplayName("Test to check to String result ")
    void testToString() {
        Assertions.assertEquals(" Vaibhav ", player.toString());
    }
}
