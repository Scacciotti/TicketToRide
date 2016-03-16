package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.card.DestCards;

/**
 * Created by Parker on 3/15/2016.
 */
public class DestDeck extends Deck {

    private ArrayList<DestCards> cards;

    private int[] cities1 = {1, 3, 5, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
                    1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};
    private int[] cities2 = {2, 4, 6, 8, 10, 12, 4, 15, 6, 17, 12, 19, 2, 21, 23, 25,
                    26, 28, 4, 21, 19, 23, 8, 7, 6, 15, 16, 21, 25, 5};
    private int[] scores = {4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
                    12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};
    public DestDeck(){
        super();
    }

    public DestDeck(DestDeck orig){
        // synchronize to ensure that original is not being modified as we
        // iterate over it
        synchronized(orig.cards) {
            // create a new arrayList for our new deck; add each card in it
            cards = new ArrayList<DestCards>();
            for (DestCards c: orig.cards) {
                cards.add(c);
            }
        }
    }

    public void FirstDeck(){
        for(int i = 0; i < 30; i++){
            cards.add(new DestCards(cities1[i], cities2[i], scores[i]));
        }
    }
}
