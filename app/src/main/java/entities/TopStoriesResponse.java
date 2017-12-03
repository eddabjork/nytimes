package entities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @author eddabjorkkonradsdottir on 30/11/17.
 */

public class TopStoriesResponse {
    @SerializedName("num_results")
    public int numResults;
    public List<Story> results;
}