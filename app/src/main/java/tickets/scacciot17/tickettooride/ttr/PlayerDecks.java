package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * Created by Parker on 3/16/2016.
 */
public class PlayerDecks {

    private TrainCarDeck playerTrains;
    private DestDeck playerDests;

    //Upon initial creation of the deck, create an ArrayList of cards
    public PlayerDecks(){
        playerTrains = new TrainCarDeck();
        playerDests = new DestDeck();
    }

    //If a deck has been created, copy it.
    public PlayerDecks(PlayerDecks orig){
        // synchronize to ensure that original is not being modified as we
        // iterate over it
        synchronized(orig.playerTrains) {
            // create a new arrayList for our new deck; add each card in it
            playerTrains = new TrainCarDeck(orig.playerTrains);
        }
        synchronized(orig.playerDests) {
            // create a new arrayList for our new deck; add each card in it
            playerDests = new DestDeck(orig.playerDests);
        }
    }
    /**
     * After a deck has been created as well as a FaceDownDeck, take the first
     * four cards from the FaceDownDeck and put them in the FaceUpDeck.
     * @param source deck "location"
     * @param destination player "hand location"
     */
    public void firstHandTrains(TrainCarDeck source, PlayerDecks destination){
        for(int i = 0; i < 4; i++){
            playerTrains.moveTopCardTo(source, destination.playerTrains);
        }
    }

    public void firstHandDests(DestDeck source, PlayerDecks destination){
        for(int i = 0; i < 3; i++){
            playerDests.moveTopCardTo(source, destination.playerDests);
        }
    }

    public TrainCarDeck getPlayerTrains(){
        return playerTrains;
    }

    public DestDeck getPlayerDests(){
        return playerDests;
    }
}
