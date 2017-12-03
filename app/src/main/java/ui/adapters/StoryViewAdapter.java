package ui.adapters;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.eddabjorkkonradsdottir.nytimes.BR;
import com.eddabjorkkonradsdottir.nytimes.R;

import java.util.List;

import entities.Story;
import logic.TopStoriesHandler;

/**
 * @author eddabjorkkonradsdottir on 02/12/17.
 */

public class StoryViewAdapter extends RecyclerView.Adapter<StoryViewAdapter.StoryViewHolder> {
    private List<Story> data;
    private TopStoriesHandler topStoriesHandler;

    public class StoryViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        private StoryViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
        private void bind(Object obj) {
            binding.setVariable(BR.story, obj);
            binding.setVariable(BR.storiesHandler, topStoriesHandler);
            binding.executePendingBindings();
        }
    }

    public StoryViewAdapter(List<Story> myDataset, TopStoriesHandler topStoriesHandler) {
        data = myDataset;
        this.topStoriesHandler = topStoriesHandler;
    }

    @Override
    public StoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.row_layout, parent, false);
        return new StoryViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(StoryViewHolder holder, int position) {
        final Story storyData = data.get(position);
        holder.bind(storyData);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
