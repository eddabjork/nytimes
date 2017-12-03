package api;

import entities.TopStoriesResponse;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author eddabjorkkonradsdottir on 30/11/17.
 */

public interface NYTService {
    String API_KEY = "d27526b5787c4150a0bfca9713d7f7ad";

    String BASE_URL = "https://api.nytimes.com/svc/";

    @GET("topstories/v2/home.json?api-key="+API_KEY)
    Call<TopStoriesResponse> topStories();
}
