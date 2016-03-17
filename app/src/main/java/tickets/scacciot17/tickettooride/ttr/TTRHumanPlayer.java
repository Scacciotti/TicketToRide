package tickets.scacciot17.tickettooride.ttr;


import android.view.View;

import tickets.scacciot17.tickettooride.Game.GameHumanPlayer;
import tickets.scacciot17.tickettooride.Game.GameMainActivity;
import tickets.scacciot17.tickettooride.Game.infoMsg.GameInfo;

/**
 * class for human player
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TTRHumanPlayer extends GameHumanPlayer {

    // the android activity that we are running
    private GameMainActivity myActivity;
    //instance variables
    private int trainTokens = 45; //default starting number of tokens

    /**
     * updates the number of train tokens
     *
     * @param length int referencing the length of the claimed track
     * @return the new value for players tokens
     */
    public int updateTrainTokens(int length) {
        int updateTokens = 0;
        for (int i = length; i > 0; i--) {
            updateTokens--;
        }
        return updateTokens;
    }
    //required as extension of GAMEHUMANPLAYER
    public TTRHumanPlayer(String name) {
        super(name);
    }

    public View getTopView() {
        return null;
    }

    public void setAsGui(GameMainActivity activity) {

    }
    /**
     * callback method when we get a message (e.g., from the game)
     *
     * @param info the message
     */
    @Override
    public void receiveInfo(GameInfo info) {

    }
}