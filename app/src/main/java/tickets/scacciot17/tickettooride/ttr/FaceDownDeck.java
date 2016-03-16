package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.card.TrainCards;

/**
 * Created by Parker on 3/15/2016.
 */
public class FaceDownDeck extends Deck {

    private ArrayList<TrainCards> cards;

    public FaceDownDeck(){
       super();
    }

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

    public void StartDeck(){
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
