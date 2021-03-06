package mggcode.menudinamico.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Geo {

    @SerializedName("lat")
    @Expose
    private String lat;
    @SerializedName("lng")
    @Expose
    private String lng;


    public Geo() {
    }


    public Geo(String lat, String lng) {
        super();
        this.lat = lat;
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Geo withLat(String lat) {
        this.lat = lat;
        return this;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public Geo withLng(String lng) {
        this.lng = lng;
        return this;
    }

}
