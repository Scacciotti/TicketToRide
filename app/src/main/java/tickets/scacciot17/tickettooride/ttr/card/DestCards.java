package tickets.scacciot17.tickettooride.ttr.card;

/**
 * Created by Parker on 3/15/2016.
 */
public class DestCards extends Cards {
    private final String[] destNames = {"Denver", "El Paso", "Kansas City",
            "Houston", "New York", "Atlanta", "Chicago", "New Orleans", "Calgary",
            "Salt Lake City", "Helena", "Los Angeles", "Duluth", "Sault Ste Marie",
            "Nashville", "Montreal", "Oklahoma City", "Seattle", "Santa Fe",
            "Toronto", "Miami", "Portland", "Phoenix", "Dallas", "New York City",
            "Pittsburgh", "Winnipeg", "Little Rock", "Boston", "Vancouver",
            "San Francisco"};

    private String city1;
    private String city2;
    private int score;
    private boolean highlight;

    public DestCards(int dest1, int dest2, int point){
        if(dest1 > destNames.length-1){
            city1 = "";
        }
        else if (dest2 > destNames.length-1){
            city2 = "";
        } else {
            city1 = destNames[dest1];
            city2 = destNames[dest2];
        }
        score = point;
        highlight = false;
    }

    public void setScore(int newScore){
        this.score = newScore;
    }

    public void setHighlight(boolean highlighted){
        this.highlight = highlighted;
    }

    public int getScore(){
        return score;
    }

    public boolean getHighlight(){
        return highlight;
    }
}
