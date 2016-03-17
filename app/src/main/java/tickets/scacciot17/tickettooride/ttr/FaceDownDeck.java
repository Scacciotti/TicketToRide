package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.Cards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * Creates the pile of face down train cards
 *
 * Created by Parker on 3/15/2016.
 */
public class FaceDownDeck extends TrainCarDeck {
    //instance variable for highlighted when selected
    private boolean highlight;

    //Upon initial creation of the deck, create an ArrayList of cards
    public FaceDownDeck(){
        super();
        highlight = false;
    }

    //If a deck has been created, copy it.
    public FaceDownDeck(FaceDownDeck orig){
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

    //Called when creating the deck for the first time. Initializes all of the
    //train cards with their respective colors
    public void startDeck(){
        for (int i = 0; i < 9; i++){
            if(i == 8){
                for(int j = 0; j < 14; j++){
                    cards.add(new TrainCards(i));
                }
            }
            else {
                for (int k = 0; k < 12; k++){
                    cards.add(new TrainCards(i));
                }
            }
        }
    }

    /**
     *
     * @return - Retruns the deck
     */
    public ArrayList<TrainCards> getCards(){
        return cards;
    }

    /**
     *
     * @param value - Sets the new highlighted value
     */
    public void setHighlight(boolean value){
        highlight = value;
    }

    public boolean getHighlight(){
        return highlight;
    }
}
