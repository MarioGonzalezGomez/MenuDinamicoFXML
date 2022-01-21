package mggcode.menudinamico.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.StringProperty;

public class Picture {

    @SerializedName("large")
    @Expose
    private StringProperty large;
    @SerializedName("medium")
    @Expose
    private StringProperty medium;
    @SerializedName("thumbnail")
    @Expose
    private StringProperty thumbnail;

    public Picture() {
    }

    public String getLarge() {
        return large.get();
    }

    public StringProperty largeProperty() {
        return large;
    }

    public void setLarge(String large) {
        this.large.set(large);
    }

    public String getMedium() {
        return medium.get();
    }

    public StringProperty mediumProperty() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium.set(medium);
    }

    public String getThumbnail() {
        return thumbnail.get();
    }

    public StringProperty thumbnailProperty() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail.set(thumbnail);
    }
}
