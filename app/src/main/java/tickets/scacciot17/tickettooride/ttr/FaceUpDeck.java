package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.Cards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * represents the collection of face up train cards
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class FaceUpDeck extends TrainCarDeck {


    //Upon initial creation of the deck, create an ArrayList of cards
    public FaceUpDeck(){
        super();
    }

    //If a deck has been created, copy it.
    /**
     * External Citation
     *  Date: 14 March 2016
     *  Problem: Need to copy a deck
     *  Resource: SJProj (SlapJack game supplied by Dr. Nuxoll)
     *  Solution: We used a modified version of the code to copy a deck
     */
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
    public void firstFive(FaceDownDeck source){
        for(int i = 0; i < 5; i++){
            moveTopCardTo(this, source);
        }
    }

    public void renewDeck(FaceDownDeck source){
        int cardsNeeded = 5 - this.size();
        for(int i = 0; i < cardsNeeded; i++){
            moveTopCardTo(this, source);
        }
    }

    /**
     *
     * @return - Returns the TrainCards Arraylist
     */
    public ArrayList<TrainCards> getCards(){
        return cards;
    }
}
