package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.card.TrainCards;

/**
 * Created by Parker on 3/15/2016.
 */
public class FaceUpDeck extends Deck {

    private ArrayList<TrainCards> cards;
    public FaceUpDeck(){
        super();
    }

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

    public void FirstFive(FaceDownDeck source){
        for(int i = 0; i < 5; i++){
            moveTopCardTo(this,source);
        }
    }
}
