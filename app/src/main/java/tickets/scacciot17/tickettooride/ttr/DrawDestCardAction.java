package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;

/**
 * Selects which destination cards user wants
 *
 *@author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class DrawDestCardAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public DrawDestCardAction(GamePlayer player) {
        super(player);
    }
}
