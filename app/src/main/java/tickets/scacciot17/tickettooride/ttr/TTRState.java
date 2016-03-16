package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.infoMsg.GameState;

/**
 * Created by Nicka on 3/14/2016.
 */
public class TTRState extends GameState {

    private FaceDownDeck allDown;
    private FaceUpDeck fiveUp;
    private DestDeck destinations;
    private Deck discard;
    private int turn;

    public TTRState(){
        allDown = new FaceDownDeck();
        allDown.startDeck();
        allDown.shuffle();
        fiveUp = new FaceUpDeck();
        fiveUp.firstFive(allDown);
        destinations = new DestDeck();
        destinations.firstDeck();
        destinations.shuffle();
        discard = new Deck();

        turn = 0;
    }

    public TTRState(TTRState original){
        allDown = new FaceDownDeck(original.allDown);
        fiveUp = new FaceUpDeck(original.fiveUp);
        destinations = new DestDeck(original.destinations);
        if(!original.discard.cards.isEmpty()){
            discard = new Deck(discard);
        }
        else{
            discard = new Deck();
        }
        turn = original.getTurn();
    }


    public int getTurn() {
        return turn;
    }
}
