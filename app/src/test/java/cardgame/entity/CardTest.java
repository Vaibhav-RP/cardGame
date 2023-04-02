package cardgame.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cardgame.enums.Rank;
import cardgame.enums.Suit;

@DisplayName(" Card Class Test ")
public class CardTest {
    
    @Test
    @DisplayName(" Card Class constructor test")
    public void testConstructor() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.getRank());
        assertEquals(Suit.SPADES, card.getSuit());
    }

    @Test
    public void testGetRank() {
        Card card = new Card(Rank.ACE, Suit.SPADES);
        assertEquals(Rank.ACE, card.getRank());
    }

    @Test
    public void testGetSuit() {
        Card card = new Card(Rank.KING, Suit.HEARTS);
        assertEquals(Suit.HEARTS, card.getSuit());
    }
    
    @Test
    @DisplayName(" Card class toString() result test ")
    public void testToString() {
        Card card = new Card(Rank.KING, Suit.HEARTS);
        assertEquals("KING of HEARTS", card.toString());
    }
}
