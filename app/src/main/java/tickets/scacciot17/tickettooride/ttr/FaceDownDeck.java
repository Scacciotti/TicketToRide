package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.card.TrainCards;

/**
 * Created by Parker on 3/15/2016.
 */
public class FaceDownDeck extends Deck {

    private ArrayList<TrainCards> cards;

    //Upon initial creation of the deck, create an ArrayList of cards
    public FaceDownDeck(){
        cards = new ArrayList<TrainCards>();
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

}
