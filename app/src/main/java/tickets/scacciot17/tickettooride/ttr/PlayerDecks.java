package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * The decks owned by the players
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class PlayerDecks {
    //instance variables for players' TrainCar and Destination decks
    private TrainCarDeck playerTrains;
    private DestDeck playerDests;

    //Upon initial creation of the deck, create an ArrayList of cards
    public PlayerDecks(){
        playerTrains = new TrainCarDeck();
        playerDests = new DestDeck();
    }

    //If a deck has been created, copy it.
    /**
     * External Citation
     *  Date: 14 March 2016
     *  Problem: Need to copy a deck
     *  Resource: SJProj (SlapJack game supplied by Dr. Nuxoll)
     *  Solution: We used a modified version of the code to copy a deck
     */
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
    /**
     * External Citation
     *  Date: 14 March 2016
     *  Problem: Need to move cards between decks
     *  Resource: SJProj (SlapJack game supplied by Dr. Nuxoll)
     *  Solution: We used a modified version of the code to move cards from one deck
     *              to another
     */
    public void firstHandTrains(TrainCarDeck source, PlayerDecks destination){
        for(int i = 0; i < 4; i++){
            playerTrains.moveTopCardTo(source, destination.playerTrains);
        }
    }

    /**
     * After a deck has been created as well as a FaceDownDeck, take the first
     * three cards from the destination FaceDownDeck and put them in the
     * destination FaceUpDeck.
     *
     * @param source deck "location"
     * @param destination player "hand location"
     */
    /**
     * External Citation
     *  Date: 14 March 2016
     *  Problem: Need to move cards between decks
     *  Resource: SJProj (SlapJack game supplied by Dr. Nuxoll)
     *  Solution: We used a modified version of the code to move cards from one deck
     *              to another
     */
    public void firstHandDests(DestDeck source, PlayerDecks destination){
        for(int i = 0; i < 3; i++){
            playerDests.moveTopCardTo(source, destination.playerDests);
        }
    }

    /**
     * Gives the player's deck
     *
     * @return - Returns the players TrainCarDeck
     */
    public TrainCarDeck getPlayerTrains(){
        return playerTrains;
    }

    /**
     * Gives the player's deck
     *
     * @return - Returns the players DestDeck
     */
    public DestDeck getPlayerDests(){
        return playerDests;
    }
}
