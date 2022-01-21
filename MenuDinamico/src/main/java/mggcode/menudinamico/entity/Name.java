package mggcode.menudinamico.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.StringProperty;

public class Name {

    @SerializedName("first")
    @Expose
    private StringProperty first;
    @SerializedName("last")
    @Expose
    private StringProperty last;

    public Name() {
    }

    public String getFirst() {
        return first.get();
    }

    public StringProperty firstProperty() {
        return first;
    }

    public void setFirst(String first) {
        this.first.set(first);
    }

    public String getLast() {
        return last.get();
    }

    public StringProperty lastProperty() {
        return last;
    }

    public void setLast(String last) {
        this.last.set(last);
    }
}
