package tickets.scacciot17.tickettooride.ttr;

import java.lang.reflect.Array;
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
    private TrainCarDeck discardTrain;
    private DestDeck discardDest;
    private PlayerDecks[] playerDecks;
    private int playerID; //ID of the player whose turn it is
    private int numPlayers; //number of players for this game
    private int[] scores; //scores of all players
    private Boolean trackSelect; //if player is placing train
    private Boolean cardSelect; //if player is drawing cards
    private Boolean destinationClick; //If players needs to select 1-3 destination cards
    private Boolean trainCardClick;
    private Boolean trainPlaceClick;
    private Track[] testTracks;
    protected int[] trainTokens; //train tokens available to player
    private int trackSpot = -1;

    public Track[] getTestTracks() {
        return testTracks;
    }

    public void setTestTracks(Track[] testTracks) {
        this.testTracks = testTracks;
    }

    /**
     *
     */
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
        discardTrain = new FaceDownDeck();
        discardDest = new DestDeck();
        scores = new int[numPlayers];
        playerID = 0;
        trainTokens = new int[numPlayers];
        playerDecks = new PlayerDecks[numPlayers];
        for(int i =0; i < trainTokens.length; i++){
            trainTokens[i] = 45;
            scores[i] = 0;
        }
        for(int i = 0; i < playerDecks.length; i++){
            playerDecks[i] = new PlayerDecks();
            playerDecks[i].firstHandTrains(allDown,playerDecks[i]);
            playerDecks[i].firstHandDests(destinations, playerDecks[i]);
        }
        trackSelect = false;
        cardSelect = true;
        destinationClick = false;
        trainCardClick = false;
        trainPlaceClick = false;
        testTracks = new Track[8];
        testTracks[0] = new Track(2, "Blue", "PittsBurgh", "Boston");
        testTracks[1] = new Track(2, "Yellow", "PittsBurgh", "Boston");
        testTracks[2] = new Track(2, "Orange", "PittsBurgh", "Boston");
        testTracks[3] = new Track(2, "Black", "PittsBurgh", "Boston");
        testTracks[4] = new Track(2, "White", "PittsBurgh", "Boston");
        testTracks[5] = new Track(2, "Pink", "PittsBurgh", "Boston");
        testTracks[6] = new Track(2, "Red", "PittsBurgh", "Boston");
        testTracks[7] = new Track(2, "Green", "PittsBurgh", "Boston");

    }
      //TODO
    /**
     * Copy constructor to create an identical version of the given game state
     * @param copyState game state to copy
     */
    public TTRState(TTRState copyState){
        allDown = new FaceDownDeck(copyState.allDown);
        fiveUp = new FaceUpDeck(copyState.fiveUp);
        destinations = new DestDeck(copyState.destinations);
        if(!copyState.discardTrain.getCards().isEmpty()){
            discardTrain = new TrainCarDeck(copyState.discardTrain);
        }
        else{
            discardTrain = new TrainCarDeck(copyState.discardTrain);
        }
        playerID = copyState.getPlayerID();
    }

    /**
     * Selects which area the user is attempting to interact with
     * User cannot interact with track select and card select simultaneously
     * @param action user event
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

    /**
     * Highlights the destination deck if user wants
     * to select from it
     * @param action user generated event
     */
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

    public boolean isLegalTrack(Track currTrack, ArrayList<TrainCards> trainAvailable){
        int colorCount = 0;
        for (int i = 0; i < trainAvailable.size(); i++) {
            if (trainAvailable.get(i).getType().equals(currTrack.getTrainColor())) {
                colorCount++;
            }
        }
        if(colorCount >= currTrack.getTrainTrackNum()){
            return true;
        }
        else{
            return false;
        }
    }

    public void highlightTracks(){
        if(this.trackSelect)
        {
            for(int i = 0; i < testTracks.length; i++) {
                if(!testTracks[i].getCovered()) {
                    if (isLegalTrack(testTracks[i], playerDecks[playerID].getPlayerTrains().getCards())) {
                        testTracks[i].setHighlight(true);
                    }
                }
            }
        }
    }

    /**
     * Places a track on game board
     * @param action user generated event
     */
    public void placeTrack(TrackPlaceAction action, int spot){
        if(!trainCardClick && !destinationClick) {
            highlightTracks();
            if (testTracks[spot].getHighlight() && !trainPlaceClick && !testTracks[spot].getSelected()) {
                testTracks[spot].setSelected(true);
                trainPlaceClick = true;
                trackSpot = spot;
            } else if(testTracks[spot].getSelected() && trainPlaceClick){
                testTracks[spot].setSelected(false);
                trainPlaceClick = false;
                trackSpot = -1;
            }
        }
    }

    /**
     * If user has highlighted a legal action, confirms their selection
     * and ends turn when appropriate
     * @param action
     */
    public void confirmSelection( ConfirmSelectionAction action){
        if(trainPlaceClick){
            testTracks[trackSpot].setCovered(true);
            for(int i = 0; i < testTracks.length; i++){
                testTracks[i].setSelected(false);
                testTracks[i].setHighlight(false);
            }
        }
        else if(trainCardClick){
            for(int i = 0; i < fiveUp.size(); i++){
                if(fiveUp.getCards().get(i).getHighlight()){
                    TrainCards temp = fiveUp.getCards().get(i);
                    temp.setHighlight(false);
                    fiveUp.getCards().remove(i);
                    playerDecks[playerID].getPlayerTrains().add(temp);
                    fiveUp.renewDeck(allDown);
                }
            }
            for(int i = 0; i < allDown.size(); i++){
                if(allDown.getCards().get(i).getHighlight()){
                    TrainCards temp = allDown.getCards().get(i);
                    temp.setHighlight(false);
                    allDown.getCards().remove(i);
                    playerDecks[playerID].getPlayerTrains().add(temp);
                }
            }
        }
        else if(destinationClick){

        }
    }
   public FaceDownDeck getAllDown() {
        return allDown;
    }
    public Track getATestTrack(int i)
    {return testTracks[i];}

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

    public TrainCarDeck getDiscard() {
        return discardTrain;
    }

    public void setDiscard(FaceDownDeck discard) {
        this.discardTrain = discard;
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

    public PlayerDecks[] getPlayerDecks() {
        return playerDecks;
    }

    public void setPlayerDecks(PlayerDecks[] playerDecks) {
        this.playerDecks = playerDecks;
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
