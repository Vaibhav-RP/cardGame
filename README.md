# Card Game
Multiplayer card game that supports multiple players (up to 4) and different types of cards (e.g. number cards, action cards, etc.). The game should follow the following rules:

1.Each player starts with a hand of 5 cards.

2.The game starts with a deck of 52 cards ( a standard deck of playing cards).

3.Players take turns playing cards from their hand, following a set of rules that define what cards can be played when.

4.A player can only play a card if it matches either the suit or the rank of the top card on the discard pile.

5.If a player cannot play a card, they must draw a card from the draw pile. If the draw pile is empty, the game ends in a draw and no player is declared a winner..

6.The game ends when one player runs out of cardswho is declared the winner.

BONUS: Aces, Kings, Queens and Jack are action cards. When one of these is played the following actions occur:

Ace(A): Skip the next player in turn

Kings(K): Reverse the sequence of who plays next 

Queens(Q): +2

Jacks(J): +4

NOTE: actions are not stackable i.e. if Q is played by player 1 then player two draws two cards and cannot play a Q from his hand on that turn even if available

# Prerequisite
    Java 1.8/1.11/1.15
    Gradle
    
# How to run a code :
 To run this code rum main method from App.class  cardGame/app/src/main/java/cardgame/App.java
 
# How to run all test cases :
 To run test cases use this command :  ./gradlew test 

# Sample Input :

![Screenshot from 2023-04-02 14-54-11](https://user-images.githubusercontent.com/54895294/229344281-3141cf6a-877a-44ff-b797-f6493b7c43cc.png)

# Smaple Output :

![Screenshot from 2023-04-02 14-55-06](https://user-images.githubusercontent.com/54895294/229344299-b78e842b-374b-49db-ab93-8b0f0fc0526f.png)
