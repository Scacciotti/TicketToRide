package tickets.scacciot17.tickettooride.ttr;

import org.junit.Test;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.Game.GamePlayer;
import tickets.scacciot17.tickettooride.ttr.card.Cards;
import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

import static org.junit.Assert.*;

/**
 * Created by Jess on 3/16/2016.
 */
public class TTRStateTest {

    @Test
    public void testDrawFaceUpTrainCards() throws Exception {
        TTRState testState = new TTRState();
        FaceUpDeck faceUpDeck = testState.getFiveUp();
        GamePlayer player = new TTRHumanPlayer("TestMonkey");
        DrawUpCardAction action = new DrawUpCardAction(player);
        int size = faceUpDeck.size();
        int selectedCardCount = 0;
        for(int i = 0; i < size; i++){
            assertNotEquals(faceUpDeck.getCards().get(i), null);
        }
        assertTrue(size == 5);

        /** Case 1: 2 Reg **/
        //select two non rainbow cards
        for (int i = 0; i < 5; i++){
            if(testState.getFiveUp().getCards().get(i).getType() != "Rainbow" && selectedCardCount < 3){
                testState.highlightUpCard(action, i);
                selectedCardCount++;
            } else {
                //Replace cards so that theres two non rainbow
                return;
            }

        }
        //assert that on confirm they are added to player hand
        int oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        testState.setTrainCardClick(true);
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 2), testState.getPlayerDecks()[0].getPlayerTrains().size());
        //assert that new cards updates in 'five up'
        size = faceUpDeck.size();
        for(int i = 0; i < size; i++){
            assertNotEquals(faceUpDeck.getCards().get(i), null);
        }
        assertTrue(size == 5);

        /** Case 2: 1 Rainbow 1 Reg (should fail) **/
        selectedCardCount = 0;
        //select one rainbow card, one train card
        testState.getFiveUp().getCards().get(0).setType("Rainbow");
        testState.getFiveUp().getCards().get(1).setType("Blue");
        testState.highlightUpCard(action, 0);
        testState.highlightUpCard(action, 1);
        //assert that confirm fails
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize), testState.getPlayerDecks()[0].getPlayerTrains().size());

        /** Case 3: 1 Rainbow **/
        //select one rainbow card
        testState.getFiveUp().getCards().get(0).setType("Rainbow");
        testState.highlightUpCard(action, 0);
        //assert on confirm rainbow is added to hand
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 1), testState.getPlayerDecks()[0].getPlayerTrains().size());
        //assert five up has new card
        size = faceUpDeck.size();
        for(int i = 0; i < size; i++){
            assertNotEquals(faceUpDeck.getCards().get(i), null);
        }
        assertTrue(size == 5);
    }

    @Test
    public void testDrawFaceDownTrainCard() throws Exception {
        TTRState testState = new TTRState();
        GamePlayer player = new TTRHumanPlayer("TestMonkey");
        DrawDownCardAction drawDownCardAction = new DrawDownCardAction(player);
        //check face down deck nd is non empty

        /** Case 1: FaceDownDeck Full **/
        //select face down stack
        testState.highlightDownCard(drawDownCardAction);
        //assert on confirm player hand increases by 2
        int oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        testState.setTrainCardClick(true);
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 2), testState.getPlayerDecks()[0].getPlayerTrains().size());
    }

    @Test
    public void testDrawComboTrainCard() throws Exception {
        TTRState testState = new TTRState();
        GamePlayer player = new TTRHumanPlayer("TestMonkey");
        DrawDownCardAction drawDownCardAction = new DrawDownCardAction(player);
        DrawUpCardAction action = new DrawUpCardAction(player);
        FaceUpDeck faceUpDeck = new FaceUpDeck();
        int size = faceUpDeck.size();
        int selectedCardCount = 0;
        for(int i = 0; i < size; i++){
            assertNotEquals(faceUpDeck.getCards().get(i), null);
        }

        /** Case: Selects 1 reg card and 1 face donwn **/
        testState.highlightDownCard(drawDownCardAction);
        testState.getFiveUp().getCards().get(0).setType("Blue");
        testState.highlightUpCard(action, 0);
        int oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        testState.setTrainCardClick(true);
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 2), testState.getPlayerDecks()[0].getPlayerTrains().size());

    }

    @Test
    public void testPlaceTrack() throws Exception {
        TTRState testState = new TTRState();
        /** Case 1: Placing Track wihtout train cards (should fail) **/
        //give player random hand containing 0 blue trains
        //assert claim testTrack[0] fails
        //assert score stayed the same

        /** Case 2: Place Track with Proper train cards**/
        //give player 2 blue trains
        //assert claim testTrack[0] passes
        //assert player score increased by 2
        /** Case 2.3: Check Route Can't be double Calimed**/
        //give player 2 blue cards
        //assert claim testTrack[0] fails (as it is already claimed)
        //give player random hand containing only 1 yellow train

        /** **/
        //assert claim testTrack[1] fails
        //assert player score stayed the same
        //give player 1 rainbow train
        //assert claim testTrack[1] passes
        //assert player score increased by 2
    }

    @Test
    public void testDrawDownCard() throws Exception
    {
        TTRState testState = new TTRState();
        FaceDownDeck faceDown = testState.getAllDown();
        for(TrainCards testcard: faceDown.getCards())
        {
            assertNotNull(testcard);
        }
    }
    @Test
    public void testDrawDestination() throws Exception
    {
        TTRState testState = new TTRState();
        DestDeck testDeck = testState.getDestinations();
        for(DestCards testCard: testDeck.getCards())
        {
            assertNotNull(testCard);
        }
    }
    @Test
    public void testPlayerDeckTrains() throws Exception
    {
        TTRState testState = new TTRState();
        PlayerDecks testDeck[] = testState.getPlayerDecks();
        assertNotNull(testDeck);
    }
    @Test
    public void testTrackSelect() throws Exception
    {
        TTRState testState = new TTRState();
        Track trackTest[] = testState.getTestTracks();
        assertNotNull(trackTest);
        //trackTest[0].setSelected();
        assertFalse(trackTest[0].getSelected());
    }
    @Test
    public void testTTRStateConstructor() throws Exception
    {
        TTRState testState = new TTRState();
        testState.setNumPlayers(3);
        assertTrue("3 players declared", testState.getNumPlayers() == 3);
        assertNotNull(testState.getFiveUp());
        assertNotNull(testState.getTestTracks());
        testState.setCardSelect(true);
        assertTrue(testState.getCardSelect());//default TTRState is false
    }
    @Test
    public void testHighlightTracks() throws Exception
    {
        TTRState testState = new TTRState();
        testState.setTrackSelect(true);
        assertTrue(testState.getTrackSelect());
    }
    @Test
    public void testIsLegalTrack() throws Exception
    {
        TTRState testState = new TTRState();
        Track testTrack = testState.getATestTrack(3);//black track
        ArrayList<TrainCards> testArray = new ArrayList<>();
        //add 4 train card objects, 5 is a reference to a black card
        testArray.add(new TrainCards(5));
        testArray.add(new TrainCards(5));
        testArray.add(new TrainCards(5));
        testArray.add(new TrainCards(5));
        assertTrue(testArray.size() == 4);
        assertTrue(testState.isLegalTrack(testTrack,testArray));
    }
}
