package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.Cards;
import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

/**
 * Created by Parker on 3/16/2016.
 */
public class TrainCarDeck {
    // to satisfy Serializable interface
    private static final long serialVersionUID = 3216223171210121485L;

    // the cards in our deck; the last card in the ArrayList is the top card
    // in the deck
    //protected ArrayList<Cards> cards;

    protected ArrayList<TrainCards> cards;
    /**
     * constructor, creating an empty deck
     */
    public TrainCarDeck() {
        cards = new ArrayList<TrainCards>();
    }

    /** copy constructor, making an exact copy of a deck
     *
     * @param orig
     * 		the deck from which the copy should be made
     */
    public TrainCarDeck(TrainCarDeck orig) {
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
                TrainCards temp = cards.get(spot);
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
    public void moveTopCardTo(TrainCarDeck targetDeck, TrainCarDeck sourceDeck) {

        // will hold the card
        TrainCards c = null;

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
    public void moveAllCardsTo(TrainCarDeck target, TrainCarDeck source) {
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
    public void add(TrainCards c) {
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
    public Cards removeTopCard() {
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
    public Cards peekAtTopCard() {
        synchronized (this.cards) {
            if (cards.isEmpty()) return null;
            return cards.get(cards.size()-1);
        }
    }

    public ArrayList<TrainCards> getCards(){
        return cards;
    }
}
