package cardgame.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import cardgame.enums.Rank;
import cardgame.enums.Suit;


public class DeckTest {
    private Deck deck;

    @BeforeEach
    public void setUp() {
        deck = new Deck();
    }

    @Test
    @DisplayName(" Test Deck size is 52 ")
    public void testDeckSize() {
        assertEquals(52, deck.getDeck().size());
    }

    @Test
    @DisplayName(" Test Deck Contains correct card ")
    public void testDeckContents() {
        List<Card> cards = deck.getDeck();
        int index = 0;
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(rank, suit);
                assertEquals(cards.get(index).toString(), card.toString());
                index++;
            }
        }
    }

    @Test
    @DisplayName(" Test compare original deck and shuffle deck ")
    public void testShuffle() {
        Deck originalDeck = new Deck();
        deck.shuffle();
        assertFalse(deck.getDeck().equals(originalDeck.getDeck()));
    }

    @Test
    @DisplayName(" Test to check the deal method removing card from deck ")
    public void testDeal() {
        Card dealtCard = deck.deal();
        assertNotNull(dealtCard);
        assertTrue(deck.getDeck().size() == 51);
    }

    @Test
    @DisplayName(" Test to check the deck is empty  ")
    public void testEmptyDeck() {
        Deck emptyDeck = new Deck();
        while (!emptyDeck.isEmpty()) {
            emptyDeck.deal();
        }
        assertNull(emptyDeck.deal());
    }
}
