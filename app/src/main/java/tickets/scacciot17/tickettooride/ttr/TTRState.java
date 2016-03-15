package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.infoMsg.GameState;

/**
 * Created by Nicka on 3/14/2016.
 */
public class TTRState extends GameState {

    //present in slapjack; added it here
    private static final long serialVersionUID = -8269749892027578792L;
    //INSTANCE VARIABLES
    //assumes deck setup as used by slapjack

    //public decks
    public Deck[] destination;
    public Deck[] trainCards;
    public Deck[] faceUpCards;
    //private human/ai decks
    //allocates for max number of computer opponents regardless
    private Deck[] human;
    private Deck[] computer1;
    private Deck[] computer2;
    private Deck[] computer3;
    private Deck[] computer4;
    //int used to determine which whose turn it is
    private int playerTurn;


}
