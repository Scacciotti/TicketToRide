package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;

/**
 * Changes the GameAction made to the new player
 *
 * Created by Parker on 3/16/2016.
 */
public class ChangeModeAction extends GameAction {

    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public ChangeModeAction(GamePlayer player) {
        super(player);
    }
}
