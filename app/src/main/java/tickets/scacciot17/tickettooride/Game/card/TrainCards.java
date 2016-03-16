package tickets.scacciot17.tickettooride.Game.card;

/**
 * Created by Parker on 3/15/2016.
 */
public class TrainCards extends Cards {

    private final String[] trainCarNames = {"Yellow", "Blue", "Orange", "White",
                                            "Pink", "Black", "Red", "Green",
                                            "Rainbow"};


    private String type;

    public TrainCards(int typeNum){
        type = trainCarNames[typeNum];
    }

    public String toString(TrainCards c){
        return this.type;
    }
}
