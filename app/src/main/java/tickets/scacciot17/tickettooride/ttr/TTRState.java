package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.infoMsg.GameState;

/**
 * Created by Nicka on 3/14/2016.
 */
public class TTRState extends GameState {

    private FaceDownDeck allDown;
    private FaceUpDeck fiveUp;
    private DestDeck destinations;
    private int turn;

    public TTRState(){
        allDown = new FaceDownDeck();
        allDown.StartDeck();
        allDown.shuffle();
        fiveUp = new FaceUpDeck();
        fiveUp.FirstFive(allDown);
        destinations = new DestDeck();
        destinations.shuffle();

        turn = 0;
    }

    public TTRState(TTRState original){
        allDown = new FaceDownDeck(original.allDown);
        fiveUp = new FaceUpDeck(original.fiveUp);
        destinations = new DestDeck(original.destinations);
        turn = original.getTurn();
    }


    public int getTurn() {
        return turn;
    }
}
