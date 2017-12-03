package logic;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.eddabjorkkonradsdottir.nytimes.R;

import java.util.List;

import api.NYTService;
import entities.Story;
import entities.TopStoriesResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import ui.adapters.StoryViewAdapter;

/**
 * @author eddabjorkkonradsdottir on 30/11/17.
 */

public class TopStoriesHandler {
    private String LOGTAG = this.getClass().getSimpleName();

    private Activity activity;

    public TopStoriesHandler(Activity activity) {
        this.activity = activity;

        fetchTopStories();
    }

    private void fetchTopStories() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(NYTService.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NYTService service = retrofit.create(NYTService.class);
        service.topStories().enqueue(new Callback<TopStoriesResponse>() {
            @Override
            public void onResponse(Call<TopStoriesResponse> call, Response<TopStoriesResponse> response) {
                fillViewWithData(response.body().results);
            }

            @Override
            public void onFailure(Call<TopStoriesResponse> call, Throwable t) {
                Log.e(LOGTAG, t.getMessage());
            }
        });
    }

    private void fillViewWithData(List<Story> stories) {
        RecyclerView recyclerView = activity.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(activity);
        recyclerView.setLayoutManager(layoutManager);
        StoryViewAdapter adapter = new StoryViewAdapter(stories, this);
        recyclerView.setAdapter(adapter);
    }

    public void onStoryClicked(Story story) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(story.getUrl()));
        activity.startActivity(browserIntent);
    }
}