package tickets.scacciot17.tickettooride.ttr;

import android.hardware.camera2.params.Face;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.LocalGame;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;

/**
 * Controls the game, allowing actions to be performed by
 * the player with the matching ID
 * Created by Parker on 3/15/2016.
 */
public class TTRLocalGame extends LocalGame {

    private TTRState mainState;

    public TTRLocalGame(){mainState = new TTRState();}

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {}

    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == mainState.getPlayerID();
    }

    @Override
    protected String checkIfGameOver() {
        return null;
    }

    @Override
    protected boolean makeMove(GameAction action) {

        if(action instanceof DrawDestCardAction)
        {

        }
        if(action instanceof DrawDownCardAction)
        {

        }
        if(action instanceof DrawUpCardAction)
        {

        }
        if(action instanceof TrackPlaceAction)
        {

        }
        return false;
    }
}
