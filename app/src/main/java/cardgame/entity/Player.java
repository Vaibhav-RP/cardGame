package cardgame.entity;

import java.util.ArrayList;
import java.util.List;

public class Player {
    
    private final String name;
    private  List<Card> hand;

    public Player(String name) {
        this.name = name;
        hand = new ArrayList<>();
    }

    
    @Override
    public String toString() {
        return " " +name +" ";
    }

    public void draw(Card card) {
        hand.add(card);
    }

    public void removeCardFromHand(int index) {
        hand.remove(index);
    }

    public List<Card> getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }

    public void setHand(List<Card> hand){
        this.hand = hand;
    }
}