package tickets.scacciot17.tickettooride.ttr;

import org.junit.Test;

import tickets.scacciot17.tickettooride.ttr.card.TrainCards;

import static org.junit.Assert.*;

/**
 * Created by Jess on 3/16/2016.
 */
public class TTRStateTest {

    @Test
    public void testDrawTrainCards() throws Exception {
        TTRState myState = new TTRState();
        FaceUpDeck faceUpDeck = myState.getFiveUp();
        for(TrainCards card : faceUpDeck.getCards()){
            assertNotEquals(card, null);
        }
    }
    @Test
    public void testPlaceTrack() throws Exception {

    }
}