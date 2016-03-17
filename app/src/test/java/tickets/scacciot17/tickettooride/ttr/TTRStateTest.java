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

        /** Test there are five face up train cards**/
        int len = faceUpDeck.getCards().size();
        assertTrue(len == 5);
     //   for(TrainCards card : faceUpDeck.getCards()){
     //       assertNotEquals(card, null);
     //   }
        /** Test if Two Non Locomotive Cards can be drawn **/
        int count = 0;
        for(int i = 0; i < 4; i++){
            if (faceUpDeck.getCards().get(i).getType() != "Rainbow")  {
                count++;
            }
        }
        if(count > 1){
            faceUpDeck.moveTopCardTo(faceUpDeck, myState.getPlayerDecks()[0]);
            faceUpDeck.moveTopCardTo(faceUpDeck, myState.getPlayerDecks()[0]);
        } else {
            //TODO
        }


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