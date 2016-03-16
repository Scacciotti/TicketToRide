package tickets.scacciot17.tickettooride.Game.card;

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

    public DestCards(int dest1, int dest2, int point){
        city1 = destNames[dest1];
        city2 = destNames[dest2];
        score = point;
    }
}
