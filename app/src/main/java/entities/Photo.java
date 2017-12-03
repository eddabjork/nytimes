package entities;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.eddabjorkkonradsdottir.nytimes.BR;
import com.google.gson.annotations.SerializedName;

/**
 * @author eddabjorkkonradsdottir on 30/11/17.
 */

public class Photo extends BaseObservable{
    @SerializedName("url")
    private String imgUrl;
    private String format;
    private int height;
    private int width;
    private String copyright;

    @Bindable
    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        notifyPropertyChanged(BR.imgUrl);
    }

    @Bindable
    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
        notifyPropertyChanged(BR.format);
    }

    @Bindable
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
        notifyPropertyChanged(BR.height);
    }

    @Bindable
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
        notifyPropertyChanged(BR.width);
    }

    @Bindable
    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright;
        notifyPropertyChanged(BR.copyright);
    }
}