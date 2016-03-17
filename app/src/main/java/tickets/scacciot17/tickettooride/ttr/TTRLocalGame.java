package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.Game.LocalGame;
import tickets.scacciot17.tickettooride.Game.actionMsg.GameAction;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

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
        if (action instanceof ChangeModeAction){
            mainState.setCardSelect(!mainState.getCardSelect());
            mainState.setTrackSelect(!mainState.getTrackSelect());
        }
        else if(action instanceof DrawDownCardAction && mainState.getCardSelect()){
            int size = mainState.getAllDown().size();
            TrainCards c = mainState.getAllDown().getCards().get(size - 1);
            TrainCards c2 = mainState.getAllDown().getCards().get(size-2);
            if(c.getHighlight() && c2.getHighlight()){
                return false;
            }
            else if(c.getHighlight()){
                c2.setHighlight(true);
                return true;
            }
            else{
                c.setHighlight(true);
                return true;
            }
        }
        else if(action instanceof DrawUpCard1Action && mainState.getCardSelect()){
            int highlightCount = 0;
            FaceUpDeck tempDeck = mainState.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++){
                if(tempCards.get(i).getHighlight()){
                    highlightCount++;
                }
            }
            if(tempCards.get(0).getHighlight()){
                tempCards.get(0).setHighlight(false);
                return true;
            }
            else if(highlightCount >= 2){
                return false;
            }
            else{
                tempCards.get(0).setHighlight(true);
                return true;
            }
        }
        else if(action instanceof DrawUpCard2Action && mainState.getCardSelect()){
            int highlightCount = 0;
            FaceUpDeck tempDeck = mainState.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++){
                if(tempCards.get(i).getHighlight()){
                    highlightCount++;
                }
            }
            if(tempCards.get(1).getHighlight()){
                tempCards.get(1).setHighlight(false);
                return true;
            }
            else if(highlightCount >= 2){
                return false;
            }
            else{
                tempCards.get(1).setHighlight(true);
                return true;
            }
        }
        else if(action instanceof DrawUpCard3Action && mainState.getCardSelect()){
            int highlightCount = 0;
            FaceUpDeck tempDeck = mainState.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++){
                if(tempCards.get(i).getHighlight()){
                    highlightCount++;
                }
            }
            if(tempCards.get(2).getHighlight()){
                tempCards.get(2).setHighlight(false);
                return true;
            }
            else if(highlightCount >= 2){
                return false;
            }
            else{
                tempCards.get(2).setHighlight(true);
                return true;
            }
        }
        else if(action instanceof DrawUpCard4Action && mainState.getCardSelect()){
            int highlightCount = 0;
            FaceUpDeck tempDeck = mainState.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++){
                if(tempCards.get(i).getHighlight()){
                    highlightCount++;
                }
            }
            if(tempCards.get(3).getHighlight()){
                tempCards.get(3).setHighlight(false);
                return true;
            }
            else if(highlightCount >= 2){
                return false;
            }
            else{
                tempCards.get(3).setHighlight(true);
                return true;
            }
        }
        else if(action instanceof DrawUpCard5Action && mainState.getCardSelect()){
            int highlightCount = 0;
            FaceUpDeck tempDeck = mainState.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++){
                if(tempCards.get(i).getHighlight()){
                    highlightCount++;
                }
            }
            if(tempCards.get(4).getHighlight()){
                tempCards.get(4).setHighlight(false);
                return true;
            }
            else if(highlightCount >= 2){
                return false;
            }
            else{
                tempCards.get(4).setHighlight(true);
                return true;
            }
        }
        else if (action instanceof DrawDestCardAction && mainState.getCardSelect()){

        }
        else if (action instanceof TrackPlaceAction && mainState.getTrackSelect()){

        }
        else if(action instanceof ConfirmSelectionAction){

        }
        return false;
    }
}
