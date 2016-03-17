package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;

/**
 * action to place train tokens on track
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class TrackPlaceAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public TrackPlaceAction(GamePlayer player) {
        super(player);
    }
}
