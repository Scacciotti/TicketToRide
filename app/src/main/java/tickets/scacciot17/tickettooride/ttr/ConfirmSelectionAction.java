package tickets.scacciot17.tickettooride.ttr;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;

/**
 * Created by Parker on 3/16/2016.
 */
public class ConfirmSelectionAction extends GameAction {
    /**
     * constructor for GameAction
     *
     * @param player the player who created the action
     */
    public ConfirmSelectionAction(GamePlayer player) {
        super(player);
    }
}