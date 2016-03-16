package tickets.scacciot17.tickettooride.ttr;

import android.graphics.Path;
import android.graphics.Rect;
import android.util.Log;

/**
 * Class which handles all details of each track set
 * @author Jess Mann
 */
public class Track {
    private int trainTrackNum = 0;
    private String trackColor = null;
    private Boolean selected = false;
    private Boolean highlight = false;
    private Boolean covered = false;
    private Path track;
    private Rect touchArea;
    private String startCity;
    private String endCity;

    public Track(int trainTrackNum, String trainColor, Path path, Rect rect){
    /**
     * Constructor for track object
     * @param trainTrackNum the length/number of train cars needed to claim route
     * @param trackColor  color assigned to track route
     * @param path collection of paths representing the locations for placed train tokens
     * @param rect area around path that is selectable by user
     */
    public Track(int trainTrackNum, String trackColor, Path path, Rect rect){
        this.trainTrackNum = trainTrackNum;
        this.trackColor = trainColor;
        trackColor = null;
        track = path;
        touchArea = rect;
    }

    public void setHighlight(Boolean val){
        highlight = val;
    }

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

    public Path getTrack(){
        return track;
    }

    public void setTrack(Path path){
        track = path;
    }

    public Boolean getSelected(){
        return selected;
    }

    public void setSelected(Boolean val){
        selected = val;
    }

    public Boolean getCovered(){
        return covered;
    }

    public void setCovered(Boolean val){
        covered = val;
    }
}
