package mggcode.menudinamico.entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import javafx.beans.property.StringProperty;

public class Result {

    @SerializedName("gender")
    @Expose
    private StringProperty gender;
    @SerializedName("name")
    @Expose
    private Name name;

    @SerializedName("email")
    @Expose
    private StringProperty email;

    @SerializedName("cell")
    @Expose
    private StringProperty cell;

    @SerializedName("picture")
    @Expose
    private Picture picture;

    public Result() {
    }

    public String getGender() {
        return gender.get();
    }

    public StringProperty genderProperty() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender.set(gender);
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getCell() {
        return cell.get();
    }

    public StringProperty cellProperty() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell.set(cell);
    }

    public Picture getPicture() {
        return picture;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }
}
