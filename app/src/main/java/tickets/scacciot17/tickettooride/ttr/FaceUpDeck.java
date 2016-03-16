package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.card.TrainCards;

/**
 * represents the collection of face up train cards
 * Created by Parker on 3/15/2016.
 */
public class FaceUpDeck extends Deck {

    private ArrayList<TrainCards> cards;

    //Upon initial creation of the deck, create an ArrayList of cards
    public FaceUpDeck(){
        super();
    }

    //If a deck has been created, copy it.
    public FaceUpDeck(FaceUpDeck orig){
        // synchronize to ensure that original is not being modified as we
        // iterate over it
        synchronized(orig.cards) {
            // create a new arrayList for our new deck; add each card in it
            cards = new ArrayList<TrainCards>();
            for (TrainCards c: orig.cards) {
                cards.add(c);
            }
        }
    }
    //After a deck has been created as well as a FaceDownDeck, take the first
    //five cards from the FaceDownDeck and put them in the FaceUpDeck.
    public void firstFive(FaceDownDeck source){
        for(int i = 0; i < 5; i++){
            moveTopCardTo(this,source);
        }
    }
}
