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
    private boolean noMoreTrains;
    private int turnsLeft;
    private int topScorePlayer = 0;
    public TTRLocalGame(){
        noMoreTrains = false;
        mainState = new TTRState();
        turnsLeft = mainState.getNumPlayers();
    }

    @Override
    protected void sendUpdatedStateTo(GamePlayer p) {
        TTRState copy = new TTRState(mainState);
        p.sendInfo(copy);
    }

    @Override
    protected boolean canMove(int playerIdx) {
        return playerIdx == mainState.getPlayerID();
    }

    @Override
    protected String checkIfGameOver() {
        for(int i = 0; i < mainState.trainTokens.length; i++){
            if(mainState.trainTokens[i] <=2){
                noMoreTrains = true;
            }
        }
        if(noMoreTrains){
            turnsLeft--;
        }
        if(turnsLeft == 0){
            for(int j = 0; j < mainState.getScores().length; j++){
                if(mainState.getScores()[j] > mainState.getScores()[topScorePlayer]){
                    topScorePlayer = j;
                }
            }
            return ("Player Wins");
        }
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
        if (action instanceof ChangeModeAction){
            mainState.setCardSelect(!mainState.getCardSelect());
            mainState.setTrackSelect(!mainState.getTrackSelect());
        }
        return true;
    }
}
