package tickets.scacciot17.tickettooride.ttr;


import android.view.View;

import tickets.scacciot17.tickettooride.Game.GameHumanPlayer;
import tickets.scacciot17.tickettooride.Game.GameMainActivity;
import tickets.scacciot17.tickettooride.Game.infoMsg.GameInfo;
import tickets.scacciot17.tickettooride.R;

/**
 * @author Nicholas
 * @version 3/15/2016
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

    /**
     * removes cards, called whenever player can legally take a track
     * @param length references the number of tracks and thus cards, to be consumed
     */
    public void removeCards(int length) {
        //removes cards
    }

    /**
     * Used to determine what happens when a card is drawn
     * @param reference a value set by the type of action
     */
    public void drawCards(int reference) {
        if (reference == 0) {
            //draw cards from face down train cards
        } else if (reference == 1) {
            //draw cards from face up train cards
        } else if (reference == 2) {
            //draw cards from destination
        } else {
            //you did something really wrong
        }
    }

    /**
     * called when trains can legally be placed onto the "game board"
     */
    public void placeTrains() {

    }

    //required as extension of GAMEHUMANPLAYER
    public TTRHumanPlayer(String name) {
        super(name);
    }

    public View getTopView() {
        return myActivity.findViewById(R.id.activity_main);
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