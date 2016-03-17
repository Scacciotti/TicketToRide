package tickets.scacciot17.tickettooride.ttr;

import org.junit.Test;

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

    }
}