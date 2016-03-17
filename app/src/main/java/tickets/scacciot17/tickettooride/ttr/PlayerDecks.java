package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * Created by Parker on 3/16/2016.
 */
public class PlayerDecks extends Deck {

    private ArrayList<TrainCards> playerTrains;
    private ArrayList<DestCards> playerDests;

    //Upon initial creation of the deck, create an ArrayList of cards
    public PlayerDecks(){
        playerTrains = new ArrayList<TrainCards>();
        playerDests = new ArrayList<DestCards>();
    }

    //If a deck has been created, copy it.
    public PlayerDecks(PlayerDecks orig){
        // synchronize to ensure that original is not being modified as we
        // iterate over it
        synchronized(orig.playerTrains) {
            // create a new arrayList for our new deck; add each card in it
            playerTrains = new ArrayList<TrainCards>();
            for (TrainCards c: orig.playerTrains) {
                cards.add(c);
            }
        }
        synchronized(orig.playerDests) {
            // create a new arrayList for our new deck; add each card in it
            playerDests = new ArrayList<DestCards>();
            for (DestCards c: orig.playerDests) {
                cards.add(c);
            }
        }
    }

    //After a deck has been created as well as a FaceDownDeck, take the first
    //five cards from the FaceDownDeck and put them in the FaceUpDeck.
    public void firstHand(FaceDownDeck source){
        for(int i = 0; i < 4; i++){
            moveTopCardTo(this,source);
        }
    }

    public ArrayList<TrainCards> getPlayerTrains(){
        return playerTrains;
    }

    public ArrayList<DestCards> getPlayerDests(){
        return playerDests;
    }
}
