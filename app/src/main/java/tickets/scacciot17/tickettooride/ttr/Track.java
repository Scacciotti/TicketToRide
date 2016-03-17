package tickets.scacciot17.tickettooride.ttr;

import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;

/**
 * Class which handles all details of each track set
 *
 * @author Nick Scacciotti
 * @author Nick Larson
 * @author Jess Mann
 * @author Parker Schibel
 * @version March 2016
 */
public class Track {
    //instance variables for tracks
    private int trainTrackNum = 0;
    private String trackColor = null;
    private Boolean selected = false;
    private Boolean highlight = false;
    private Boolean covered = false;
    private Path track;
    private Rect touchArea;
    private String startCity;
    private String endCity;
    private boolean selectHighlight;

    /**
     * Constructor for track object
     * @param trainTrackNum the length/number of train cars needed to claim route
     * @param trackColor  color assigned to track route
     * @param secondCity collection of paths representing the locations for placed train tokens
     * @param firstCity area around path that is selectable by user
     */
    public Track(int trainTrackNum, String trackColor, String firstCity, String secondCity){
        this.trainTrackNum = trainTrackNum;
        this.trackColor = trackColor;
        startCity = firstCity;
        endCity = secondCity;
        highlight = false;
        selected = false;
    }

    /**
     * Sets whether the track is highlighted or not
     *
     * @param val - new value for if track is highlighted
     */
    public void setHighlight(Boolean val){
        highlight = val;
    }

    /**
     * Retruns if highlighted
     *
     * @return
     *      Returns true/false if track is highlighted
     */
    public Boolean getHighlight(){
        return highlight;
    }

    /**
     * Returns the raw x and y values from user touches on screen
     * @param x raw x value
     * @param y raw y value
     * @return
     */
    public Boolean isTouched(int x, int y){
        return (touchArea.contains(x,y));
    }

    /**
     * Returns the tracknumber
     * @return
     */
    public int getTrainTrackNum(){
        return trainTrackNum;
    }

    /**
     * Returns the track color
     * @return
     */
    public String getTrainColor(){
        return trackColor;
    }

    /**
     * Retruns the track Path
     * @return
     */
    public Path getTrack(){
        return track;
    }

    /**
     * Sets the track path
     * @param path - new Path for graphics
     */
    public void setTrack(Path path){
        track = path;
    }

    /**
     * Checks if track is selected
     * @return
     */
    public Boolean getSelected(){
        return selected;
    }

    /**
     * Sets the tracks new selected value
     * @param val - new boolean for if selected
     */
    public void setSelected(Boolean val){
        selected = val;
    }

    /**
     * Retruns if the track is covered
     * @return
     */
    public Boolean getCovered(){
        return covered;
    }

    /**
     * Sets whether the track is/isn't selected
     * @param val - new boolean for if covered
     */
    public void setCovered(Boolean val){
        covered = val;
    }
}
