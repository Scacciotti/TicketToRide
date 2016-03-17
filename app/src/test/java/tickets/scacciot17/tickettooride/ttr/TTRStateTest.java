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


    /**
     * checks various types of face up card draws to
     * ensure that they follow appropriate rules
     * (i.e. locomotive ("rainbow") cards can only be drawn
     * singularly)
     * @throws Exception
     */
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
        testState.highlightDownCard(drawDownCardAction);
        //assert on confirm player hand increases by 2
        int oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        testState.setTrainCardClick(true);
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);
        testState.confirmSelection(confirmSelectAction);
        assertEquals((oldDeckSize + 2), testState.getPlayerDecks()[0].getPlayerTrains().size());
    }

    /**
     * Various types of cards draws from the face up, and
     * face down decks
     * @throws Exception
     */
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
        GamePlayer player = new TTRHumanPlayer("TestMonkey");
        ConfirmSelectionAction confirmSelectAction = new ConfirmSelectionAction(player);
        DrawDownCardAction drawDownCardAction = new DrawDownCardAction(player);
        DrawUpCardAction action = new DrawUpCardAction(player);
        FaceUpDeck faceUpDeck = new FaceUpDeck();

        /** Case 1: Placing Track wihtout train cards (should fail) **/
        //give player random hand containing 0 blue trains
        //assert claim testTrack[0] fails
        testState.getTestTracks()[0].setSelected(true);
        testState.confirmSelection(confirmSelectAction);
        int oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        assertEquals(oldDeckSize, testState.getPlayerDecks()[0].getPlayerTrains().size());

        /** Case 2: Place Track with Proper train cards**/
        //give player 2 blue trains
        testState.getFiveUp().getCards().get(0).setType("Blue");
        testState.getFiveUp().getCards().get(1).setType("Blue");
        testState.highlightUpCard(action, 0);
        testState.highlightUpCard(action, 1);
        testState.confirmSelection(confirmSelectAction);
        //assert claim testTrack[0] passes
        oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        assertEquals(oldDeckSize-2, testState.getPlayerDecks()[0].getPlayerTrains().size());
        //assert player score increased by 2
        /** Case 2.3: Check Route Can't be double Claimed**/
        //give player 2 blue cards
        testState.getFiveUp().getCards().get(0).setType("Blue");
        testState.getFiveUp().getCards().get(1).setType("Blue");
        testState.highlightUpCard(action, 0);
        testState.highlightUpCard(action, 1);
        testState.confirmSelection(confirmSelectAction);
        //assert claim testTrack[0] fails (as it is already claimed)
        oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        testState.getTestTracks()[1].setSelected(true);
        testState.confirmSelection(confirmSelectAction);
        assertEquals(oldDeckSize, testState.getPlayerDecks()[0].getPlayerTrains().size());


        /** Case 3: Claim with Rainbow **/
        //give player random hand containing 1 yellow train 1 rainbow
        testState.getFiveUp().getCards().get(0).setType("Blue");
        testState.getFiveUp().getCards().get(1).setType("Blue");
        testState.highlightUpCard(action, 0);
        testState.highlightUpCard(action, 1);
        testState.confirmSelection(confirmSelectAction);
        //assert claim testTrack[1]
        oldDeckSize = testState.getPlayerDecks()[0].getPlayerTrains().size();
        assertEquals(oldDeckSize, testState.getPlayerDecks()[0].getPlayerTrains().size());

    }
    /**
     * Draws from faceDown pile, checks to see if all cards
     * are not null
     * @throws Exception
     */
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

    /**
     * draws destination cards and checks to ensure that they
     * are not not
     * @throws Exception
     */
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

    /**
     * copies over player deck and checks to see if null
     * @throws Exception
     */
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
        trackTest[0].setSelected(true);
        assertTrue(trackTest[0].getSelected());
    }

    /**
     * Various default tests and modifications of the State constructor
     * to ensure it handles them properly
     * @throws Exception
     */
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

    /**
     * Sets a highlight true for all tracks, checks to see if all true
     * @throws Exception
     */
    @Test
    public void testHighlightTracks() throws Exception
    {
        TTRState testState = new TTRState();
        testState.setTrackSelect(true);
        assertTrue(testState.getTrackSelect());
    }

    /**
     * References a test track and creates 4 black cards
     * then sees if the isLegalTrack properly handles it
     * @throws Exception
     */
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
        assertTrue(testState.isLegalTrack(testTrack, testArray));
    }
}
