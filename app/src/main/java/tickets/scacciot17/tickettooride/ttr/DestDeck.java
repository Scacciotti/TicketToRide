package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.Cards;
import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * Creates the destination deck
 * @author Parker
 * @version 3/15/2016.
 */
public class DestDeck{

    private ArrayList<DestCards> cards;
    private boolean highlight;

    //The first locations labeled on the destination cards
    private int[] cities1 = {1, 3, 5, 7, 9, 11, 13, 14, 16, 14, 18, 7, 13, 20, 22, 24,
                    1, 27, 27, 29, 30, 9, 16, 12, 31, 22, 30, 12, 12, 18};

    //The second locations labeled on the destination cards
    private int[] cities2 = {2, 4, 6, 8, 10, 12, 4, 15, 6, 17, 12, 19, 2, 21, 23, 25,
                    26, 28, 4, 21, 19, 23, 8, 7, 6, 15, 16, 21, 25, 5};

    //The score values for each of the destination cards
    private int[] scores = {4, 5, 6, 7, 7, 8, 8, 8, 9, 9, 9, 9, 10, 10, 11, 11, 11, 11,
                    12, 12, 13, 13, 13, 16, 17, 17, 20, 20, 21, 22};

    //Upon initial creation of the deck, create an ArrayList of cards
    public DestDeck(){
        cards = new ArrayList<DestCards>();
        highlight = false;
    }

    /**
     *     If a deck has been created, copy it.
     */
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
        highlight = orig.highlight;
    }

    /**
     * Called when creating the deck for the first time. Initializes all of the
     * destination cards
     */
    public void firstDeck(){
        for(int i = 0; i < 30; i++){
            cards.add(new DestCards(cities1[i], cities2[i], scores[i]));
        }
    }

    public ArrayList<DestCards> getCards(){
        return cards;
    }

    public void setHighlight(boolean value){
        this.highlight = value;
    }
    public boolean getHighlight(){
        return highlight;
    }



    /**
     * adds one of each card, increasing the size of the deck by 52. Cards are added
     * spades first (King to Ace), then similarly with hearts, diamonds and clubs.
     *
     * @return
     * 		the deck
     */
    public void shuffle() {
        // synchronize so that we don't have someone trying to modify the
        // deck as we're modifying it
        synchronized (cards) {
            // go through a loop that randomly rearranges the cards
            for (int i = cards.size(); i > 1; i--) {
                int spot = (int)(i* Math.random());
                DestCards temp = cards.get(spot);
                cards.set(spot, cards.get(i-1));
                cards.set(i-1, temp);
            }
        }
    }

    /**
     * Moves the top card the current deck to the top of another; does nothing if
     * the first deck is empty
     *
     * @param targetDeck
     * 		the deck to which the card should be moved
     */
    public void moveTopCardTo(DestDeck targetDeck, DestDeck sourceDeck) {

        // will hold the card
        DestCards c = null;

        // size of the first deck
        int size;

        // indivisibly check the deck for empty, and remove the card, to
        // avoid a race condition
        size = sourceDeck.cards.size();
        if (size > 0) {
            c = sourceDeck.cards.get(size-1);
            sourceDeck.cards.remove(size-1);
            targetDeck.add(c);
        }
    }

    /**
     * move all cards in the current deck to a another deck by repeated moving
     * a single card from top to top
     *
     * @param target
     * 		the deck that will get the cards
    */
    public void moveAllCardsTo(DestDeck target, DestDeck source) {
    // if the source and target are the same, ignore
    if (source == target) {
    return;
    }

    // keep moving cards until the current deck is empty
    while (size() > 0) {
    moveTopCardTo(target,source);
    }
    }


    /**
     * add a card to the top of a deck
     *
     * @param c
     * 		the card to add
     */
    public void add(DestCards c) {
        // synchronize so that the underlying ArrayList is not accessed
        // inconsistently
        synchronized(this.cards) {
            cards.add(c);
        }
    }


    /**
     * @return
     * 		the number of cards in the deck
     */
    public int size() {
        return cards.size();
    }

    /**
     * replace each element in the deck with a null card; does not change
     * the size of the deck, but rather causes the deck to yield null for
     * when accessed with a valid index. A null card might represent that
     * there is a card in that position, but that it is face-down.
     */
    public void nullifyDeck() {
        // synchronize so that we don't get any race conditions (e.g., with
        // shuffle()
        synchronized (this.cards) {
            // null out each card
            for (int i = 0; i < cards.size(); i++) {
                cards.set(i, null);
            }
        }
    }

    /**
     * remove the top card from the deck
     *
     * @return
     * 		the top card in the deck, which is also removed,
     * 		or null if the deck was empty
     */
    public DestCards removeTopCard() {
        synchronized (this.cards) {
            if (cards.isEmpty()) return null;
            return cards.remove(cards.size()-1);
        }
    }

    /**
     * @return
     * 		the top card in the deck, without removing it; null
     * 		if the deck was empty
     */
    public DestCards peekAtTopCard() {
        synchronized (this.cards) {
            if (cards.isEmpty()) return null;
            return cards.get(cards.size() - 1);
        }
    }

    public void createPool(DestDeck source){
        for(int i = 0; i < 3; i++){
            moveTopCardTo(this, source);
        }
    }

    public void clearPool(DestDeck source){
        int size = source.size();
        for(int i = 0; i < size; i++){
            moveTopCardTo(this, source);
        }
    }
}
