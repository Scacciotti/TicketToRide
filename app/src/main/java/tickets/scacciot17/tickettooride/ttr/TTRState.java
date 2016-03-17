package tickets.scacciot17.tickettooride.ttr;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.TrainCards;
import tickets.scacciot17.tickettooride.Game.infoMsg.GameState;

/**
 * Created by Nicka on 3/14/2016.
 */
public class TTRState extends GameState {

    private FaceDownDeck allDown;
    private FaceUpDeck fiveUp;
    private DestDeck destinations;
    private Deck discard;
    private PlayerDecks[] playerDecks;
    private int playerID; //ID of the player whose turn it is
    private int numPlayers; //number of players for this game
    private int[] scores; //scores of all players
    private Boolean trackSelect; //if player is placing train
    private Boolean cardSelect; //if player is drawing cards
    private Boolean destinationClick; //If players needs to select 1-3 destination cards
    private Boolean trainCardClick;
    private Boolean trainPlaceClick;
    //private Tracks tracks; //all tracks in game
    protected int[] trainTokens; //train tokens availible to player

    public TTRState(){
        numPlayers = 2;
        allDown = new FaceDownDeck();
        allDown.startDeck();
        allDown.shuffle();
        fiveUp = new FaceUpDeck();
        fiveUp.firstFive(allDown);
        destinations = new DestDeck();
        destinations.firstDeck();
        destinations.shuffle();
        discard = new Deck();
        scores = new int[numPlayers];
        playerID = 0;
        //tracks = new Tracks();
        trainTokens = new int[numPlayers];
        playerDecks = new PlayerDecks[numPlayers];
        for(int i =0; i < trainTokens.length; i++){
            trainTokens[i] = 45;
            scores[i] = 0;
        }
        for(int i = 0; i < playerDecks.length; i++){
            playerDecks[i].firstHand(allDown);
        }
        trackSelect = false;
        cardSelect = true;
        destinationClick = false;
        trainCardClick = false;
        trainPlaceClick = false;
    }
      //TODO
    /**
     * Copy constructor to create an identical version of the given game state
     * @param copyState gamestate to copy
     */
    public TTRState(TTRState copyState){
        allDown = new FaceDownDeck(copyState.allDown);
        fiveUp = new FaceUpDeck(copyState.fiveUp);
        destinations = new DestDeck(copyState.destinations);
        if(!copyState.discard.cards.isEmpty()){
            discard = new Deck(copyState.discard);
        }
        else{
            discard = new Deck(copyState.discard);
        }
        playerID = copyState.getPlayerID();
    }

    /**
     * Deselects
     * @param action
     */
    public void changeMode(ChangeModeAction action){
        if(this.getCardSelect()) {
            this.setCardSelect(!this.getCardSelect());
            this.setTrackSelect(!this.getTrackSelect());
        } else if(this.getTrackSelect()){
            this.setCardSelect(!this.getCardSelect());
            this.setTrackSelect(!this.getTrackSelect());
        }
    }

    /**
     * highlights selected face down cards that the user selects
     * @param action is user event
     */
    public void highlightDownCard(DrawDownCardAction action) {
        if (this.getCardSelect() && !this.getDestinationClick()) {
            int size = this.getAllDown().size();
            TrainCards c = this.getAllDown().getCards().get(size - 1);
            TrainCards c2 = this.getAllDown().getCards().get(size - 2);
            if (c.getHighlight() && c2.getHighlight()) {
                return;
            } else if (c.getHighlight()) {
                c2.setHighlight(true);
            } else {
                c.setHighlight(true);
            }
        }
    }

    /**
     * highlights selected face up cards, while also checking to see if face
     * down deck has had any highlighted cards
     * @param action user action
     * @param spot location of click/ item selection
     */
    public void highlightUpCard(DrawUpCard1Action action, int spot){
    public void highlightUpCard(DrawUpCardAction action, int spot){
        if(this.getCardSelect() && !this.getDestinationClick()) {
            int highlightCount = 0;
            FaceUpDeck tempDeck = this.getFiveUp();
            ArrayList<TrainCards> tempCards = tempDeck.getCards();
            for (int i = 0; i < tempDeck.size(); i++) {
                if (tempCards.get(i).getHighlight()) {
                    highlightCount++;
                }
            }
            FaceDownDeck tempDeck2 = this.getAllDown();
            ArrayList<TrainCards> tempCards2 = tempDeck2.getCards();
            for (int i = 0; i < tempDeck2.size(); i++) {
                if (tempCards2.get(i).getHighlight()) {
                    highlightCount++;
                }
            }
            if (tempCards.get(spot).getHighlight()) {
                tempCards.get(spot).setHighlight(false);
                highlightCount--;
                if(highlightCount == 0){
                    this.setTrainCardClick(false);
                }
            } else if (highlightCount >= 2) {
                this.setTrainCardClick(true);
            } else {
                tempCards.get(spot).setHighlight(true);
                this.setTrainCardClick(true);
            }
        }
    }
    public void highlightDestCard( DrawDestCardAction action){
        if(this.getCardSelect() && !this.getTrainCardClick()){
            if(this.destinations.getHighlight()){
                this.destinations.setHighlight(false);
                this.setDestinationClick(false);
            }
            else if(!this.destinations.getHighlight()){
                this.destinations.setHighlight(true);
                this.setDestinationClick(true);
            }
        }
    }
    public void placeTrack( TrackPlaceAction action){

    }
    public void confirmSelection( ConfirmSelectionAction action){

    }

   public FaceDownDeck getAllDown() {
        return allDown;
    }

    public void setAllDown(FaceDownDeck allDown) {
        this.allDown = allDown;
    }

    public FaceUpDeck getFiveUp() {
        return fiveUp;
    }

    public void setFiveUp(FaceUpDeck fiveUp) {
        this.fiveUp = fiveUp;
    }

    public DestDeck getDestinations() {
        return destinations;
    }

    public void setDestinations(DestDeck destinations) {
        this.destinations = destinations;
    }

    public Deck getDiscard() {
        return discard;
    }

    public void setDiscard(Deck discard) {
        this.discard = discard;
    }

    public int getPlayerID() {
        return playerID;
    }

    public void setPlayerID(int playerID) {
        this.playerID = playerID;
    }

    public int getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(int numPlayers) {
        this.numPlayers = numPlayers;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public Boolean getTrackSelect() {
        return trackSelect;
    }

    public void setTrackSelect(Boolean trackSelect) {
        this.trackSelect = trackSelect;
    }

    public Boolean getCardSelect() {
        return cardSelect;
    }

    public void setCardSelect(Boolean cardSelect) {
        this.cardSelect = cardSelect;
    }

    public Boolean getDestinationClick() {
        return destinationClick;
    }

    public void setDestinationClick(Boolean destinationClick) {
        this.destinationClick = destinationClick;
    }

    public Boolean getTrainCardClick() {
        return trainCardClick;
    }

    public void setTrainCardClick(Boolean destinationClick) {
        this.trainCardClick = destinationClick;
    }

    public Boolean getTrainPlaceClick() {
        return trainPlaceClick;
    }

    public void setTrainPlaceClick(Boolean destinationClick) {
        this.trainPlaceClick = destinationClick;
    }

    public int[] getTrainTokens() {
        return trainTokens;
    }

    public void setTrainTokens(int[] trainTokens) {
        this.trainTokens = trainTokens;
    }
}
