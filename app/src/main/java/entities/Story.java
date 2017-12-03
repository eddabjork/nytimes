package entities;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.eddabjorkkonradsdottir.nytimes.BR;
import com.eddabjorkkonradsdottir.nytimes.R;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @author eddabjorkkonradsdottir on 30/11/17.
 */

public class Story extends BaseObservable {
    private String section;
    private String subsection;
    private String title;
    @SerializedName("abstract")
    private String summary;
    private String url;
    @SerializedName("multimedia")
    private List<Photo> photos;
    @SerializedName("short_url")
    private String shortUrl;

    @Bindable
    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
        notifyPropertyChanged(BR.section);
    }

    @Bindable
    public String getSubsection() {
        return subsection;
    }

    public void setSubsection(String subsection) {
        this.subsection = subsection;
        notifyPropertyChanged(BR.subsection);
    }

    @Bindable
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
        notifyPropertyChanged(BR.title);
    }

    @Bindable
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
        notifyPropertyChanged(BR.summary);
    }

    @Bindable
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
        notifyPropertyChanged(BR.url);
    }

    @Bindable
    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
        notifyPropertyChanged(BR.photos);
    }

    @BindingAdapter("android:src")
    public static void setImageUrl(ImageView view, List<Photo> photos) {
        Picasso
                .with(view.getContext())
                .load(photos.get(0).getImgUrl())
                .placeholder(R.drawable.placeholder)
                .fit()
                .into(view);
    }

    @Bindable
    public String getShortUrl() {
        return shortUrl;
    }

    public void setShortUrl(String shortUrl) {
        this.shortUrl = shortUrl;
        notifyPropertyChanged(BR.shortUrl);
    }
}
