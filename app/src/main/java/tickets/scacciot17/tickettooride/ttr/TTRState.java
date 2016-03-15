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
    //int used to determine which whose turn it is
    private int playerTurn;
    //private human/ai destination decks
    //allocates for max number of computer opponents regardless
    private Deck[] humanDestination;
    private Deck[] computerDestination1;
    private Deck[] ComputerDestination2;
    private Deck[] computerDestination3;
    private Deck[] computerDestination4;

    //private human/ai train decks
    //allocates for max number of computer opponents regardless
    /**
     * Could this be set up more flexibly as an ARRAYLIST?
     */
    private Deck[] humanTrain;
    private Deck[] computerTrain1;
    private Deck[] ComputerTrain2;
    private Deck[] computerTrain3;
    private Deck[] computerTrain4;

    //number of human/ai train tokens
    private int humanToken;
    private int computerToken1;
    private int ComputerToken2;
    private int computerToken3;
    private int computerToken4;
   }
