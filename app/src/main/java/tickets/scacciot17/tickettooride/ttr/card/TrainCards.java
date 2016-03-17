package tickets.scacciot17.tickettooride.ttr.card;

/**
 *  Train Card class. Contains the train card colors and sets the card to a specific type.
 *
 * Created by Parker on 3/15/2016.
 */
public class TrainCards extends Cards {
    //String of names of the different train card colors
    private final String[] trainCarNames = {"Yellow", "Blue", "Orange", "White",
                                            "Pink", "Black", "Red", "Green",
                                            "Rainbow"};

    //instance variables for what color type and if highlighted
    private String type;
    private boolean highlight;

    /**
     * Constructor for TrainCards class
     *
     * @param typeNum the int value for the color type in the
     *                trainCarNames array     *
     */
    public TrainCards(int typeNum){
        type = trainCarNames[typeNum];
    }

    /**
     * Gives the color type of the Train Card
     *
     * @return
     *      Returns the type of card
     */
    public String toString(){
        return this.type;
    }

    /**
     * Sets the highlight variable to the new variable
     *
     * @param highlighted- new boolean value for if highlighted or not
     */
    public void setHighlight(boolean highlighted){
        this.highlight = highlighted;
    }

    /**
     * Tells whether the Destination ticket is highlighted or not
     *
     * @return
     *      Returns true or false
     */
    public boolean getHighlight(){
        return highlight;
    }

    /**
     * Gives the color type of the Train Card
     *
     * @return
     *      Returns the card type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the Train card type to a new color type
     *
     * @param type - new color type
     */
    public void setType(String type) {
        this.type = type;
    }
}
