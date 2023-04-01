package cardgame.entity;

import cardgame.enums.Rank;
import cardgame.enums.Suit;

public class Card {
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(rank.toString());
        sb.append(" of ");
        sb.append(suit.toString());
        return sb.toString();
    }
}


