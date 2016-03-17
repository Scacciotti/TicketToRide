package tickets.scacciot17.tickettooride.ttr.card;

/**
 * Destination ticket card class. Contains an array of the names of cities for
 * destinations and beginnings of routes, and value of the card for points.
 *
 * Created by Parker on 3/15/2016.
 */
public class DestCards extends Cards {
    //String array containing city names
    private final String[] destNames = {"Denver", "El Paso", "Kansas City",
            "Houston", "New York", "Atlanta", "Chicago", "New Orleans", "Calgary",
            "Salt Lake City", "Helena", "Los Angeles", "Duluth", "Sault Ste Marie",
            "Nashville", "Montreal", "Oklahoma City", "Seattle", "Santa Fe",
            "Toronto", "Miami", "Portland", "Phoenix", "Dallas", "New York City",
            "Pittsburgh", "Winnipeg", "Little Rock", "Boston", "Vancouver",
            "San Francisco"};
    //instance variables for beginning and end destinations, score, and if highlighted/claimed
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

    /**
     * Sets the score of the ticket to a new value
     *
     * @param newScore- the new destination tickets score value
     */
    public void setScore(int newScore){
        this.score = newScore;
    }

    /**
     * Sets the highlight variable to the new variable
     *
     * @param highlighted- new boolean value for if highlighted or not
     */
    public void setHighlight(boolean highlighted){
        this.highlight = highlighted;
    }

    /**
     * Tells the destination ticket's score
     *
     * @return
     *      returns the score
     */
    public int getScore(){
        return score;
    }

    /**
     * Tells whether the Destination ticket is highlighted or not
     *
     * @return
     *      Returns true or false
     */
    public boolean getHighlight(){
        return highlight;
    }
}
