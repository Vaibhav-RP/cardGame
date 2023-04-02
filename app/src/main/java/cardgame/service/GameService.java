package cardgame.service;

import java.util.ArrayList;
import java.util.List;

import cardgame.entity.Card;
import cardgame.entity.Deck;
import cardgame.entity.Player;
import cardgame.enums.Rank;

public class GameService {
    private List<Player> players;
    private Deck deck;
    private ArrayList<Card> discardPile;
    private int currentPlayerIndex;
    private int direction;

    public GameService(List<Player> players, Deck deck) {
        
        this.players = players;
        this.deck = deck;

        discardPile = new ArrayList<Card>();
        Card firstCard = deck.deal();
        discardPile.add(firstCard);
        currentPlayerIndex = 0;
        direction = 1;
    }
  

    public Deck getDeck(){
        return deck;
    }
    public int getDirection(){
        return direction;
    }

    public List<Card> getDiscardPile(){
        return discardPile;
    }

    public void drawCard(Player currentPlayer) {
        Card drawnCard = deck.deal();
        currentPlayer.draw(drawnCard);
    }
    
    public Player getCurrentPlayer(){
        return players.get(currentPlayerIndex);
    }


    public Player getNextPlayer() {
        int nextPlayerIndex = currentPlayerIndex + this.direction;
        if (nextPlayerIndex == players.size()) {
            nextPlayerIndex = 0;
        } else if (nextPlayerIndex < 0) {
            nextPlayerIndex = players.size() - 1;
        }
        return players.get(nextPlayerIndex);
    }



    public int getNextPlayerIndex() {
        int nextPlayerIndex = currentPlayerIndex + this.direction;
        if (nextPlayerIndex == players.size()) {
            nextPlayerIndex = 0;
        } else if (nextPlayerIndex < 0) {
            nextPlayerIndex = players.size() - 1;
        }
        return nextPlayerIndex;
    }

    public void handleSpecialCards(Player currentPlayer, Card card) {
        if (card.getRank().equals(Rank.ACE)) {
            System.out.println("    Skipping next player");
            currentPlayerIndex = getNextPlayerIndex();
        } else if (card.getRank().equals(Rank.KING)) {
            System.out.println("    Reversing direction");
            this.direction *= -1;
            currentPlayerIndex = getNextPlayerIndex();
        } else if (card.getRank().equals(Rank.QUEEN)) {
            Player nextPlayer = getNextPlayer();
            System.out.println(String.format("    Drawing 2 cards for %s (next player)", nextPlayer.getName()));

            for (int j = 0; j < 2; j++) {
                Card drawnCard = deck.deal();
                if(drawnCard != null)
                    nextPlayer.draw(drawnCard);
            }

        } else if (card.getRank().equals(Rank.JACK)) {
            Player nextPlayer = getNextPlayer();
            System.out.println(String.format("    Drawing 4 cards for %s (next player)", nextPlayer.getName()));
            for (int j = 0; j < 4; j++) {
                Card drawnCard = deck.deal();
                if(drawnCard != null)
                    nextPlayer.draw(drawnCard);
            }
        }
    }

    public boolean playCards(Player currentPlayer) {
        boolean playedCard = false;
        for (int i = 0; i < currentPlayer.getHand().size(); i++) {
            Card card = currentPlayer.getHand().get(i);
            if (card.getSuit().equals(discardPile.get(discardPile.size() - 1).getSuit()) ||
                    card.getRank().equals(discardPile.get(discardPile.size() - 1).getRank())) {
                discardPile.add(card);
                currentPlayer.removeCardFromHand(i);
                System.out.println(String.format("    %s played %s", currentPlayer.getName(), card));
                playedCard = true;
    
                handleSpecialCards(currentPlayer, card);
    
                break;
            }
        }
        return playedCard;
    }
    
    public void playGame() {
        while (true) {
            System.out.println();
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println(String.format("    It's %s's turn", currentPlayer));
            System.out.println(String.format("    Top card on discard pile :- %s", discardPile.get(discardPile.size() - 1)));
            System.out.println(String.format("    Your hand :- %s", currentPlayer.getHand()));
    
            boolean playedCard = playCards(currentPlayer);
    
            if (!playedCard) {
                System.out.println("    No cards to play. Drawing a card from the draw pile.");
                drawCard(currentPlayer);
                if (deck.isEmpty()) {
                    System.out.println("\n<<<< ---- @@@@@@@@@@@@@@@@@@@@@@@ ---- >>>>  Ohhhh, Draw pile is empty. Game over  <<<< ---- @@@@@@@@@@@@@@@@@@@@@@@ ---- >>>>");
                    return;
                }
            }
            if (currentPlayer.getHand().isEmpty()) {
                System.out.println(String.format("\n<<<< ---- @@@@@@@@@@@@@@@@@@@@@@@ ---- >>>>  Yehhhh, %s has won the game!  <<<< ---- @@@@@@@@@@@@@@@@@@@@@@@ ---- >>>>", currentPlayer));
                return;
            }

            System.out.println(String.format("    Your hand after card played :- %s", currentPlayer.getHand()));
    
            currentPlayerIndex = getNextPlayerIndex();
        }
    }
    

    
}
