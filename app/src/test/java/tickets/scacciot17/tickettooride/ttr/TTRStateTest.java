package tickets.scacciot17.tickettooride.ttr;

import org.junit.Test;

import java.util.ArrayList;

import tickets.scacciot17.tickettooride.ttr.card.DestCards;
import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

import static org.junit.Assert.*;

/**
 * Created by Jess on 3/16/2016.
 */
public class TTRStateTest {

    @Test
    public void testDrawFaceUpTrainCards() throws Exception {
        TTRState myState = new TTRState();
        FaceUpDeck faceUpDeck = myState.getFiveUp();
        int size = faceUpDeck.size();
        for(int i = 0; i < size; i++){
            assertNotEquals(faceUpDeck.getCards().get(i), null);
        }
        //assert there are five non-empty face up train cards

        /** Case 1: 2 Reg **/
        //select two non rainbow cards
        //assert that on confirm they are added to player hand
        //assert that new cards updates in 'five up'

        /** Case 2: 1 Rainbow 1 Reg (should fail) **/
        //select one rainbow card, one train card
        //assert that confirm fails
        //assert five up remain the same
        //assert that

        /** Case 3: 1 Rainbow **/
        //select one rainbow card
        //assert on confirm rainbow is added to hand
        //assert five up has new card

    }

    @Test
    public void testDrawFaceDownTrainCard() throws Exception {
        TTRState testState = new TTRState();
        //check face down deck exists and is non empty

        /** Case 1: FaceDownDeck Full **/
        //select face down stack
        //assert on confirm player hand increases by 2
        //assert FaceDownDeck size decreased by 2

        /** Case 2: FaceDownDeck has 1 Card, Discard Full **/
        //select face down stack
        //assert on confirm player hand increases by 2
        //discard pile should reshuffle itself in
        //assert discard empty

        /** Case 3: FaceDownDeck has 1 Card, Discard Empty **/
        //select face down stack
        //assert on confirm player hand increases by 1
        //select face down stack
        //assert on confirm no changes/craches
    }

    @Test
    public void testPlaceTrack() throws Exception {
        TTRState testState = new TTRState();
        //give player random hand containing 0 blue trains
        //assert claim testTrack[0] fails
        //assert score stayed the same
        //give player 2 blue trains
        //assert claim testTrack[0] passes
        //assert player score increased by 2
        //give player 2 blue cards
        //assert claim testTrack[0] fails (as it is already claimed)
        //give player random hand containing only 1 yellow train
        //assert claim testTrack[1] fails
        //assert player score stayed the same
        //give player 1 rainbow train
        //assert claim testTrack[1] passes
        //assert player score increased by 2
    }

    //mimic I made for practice
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
        //PlayerDecks testDeck = testState.;
    }
}