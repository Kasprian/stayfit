package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_size {
    private final IntegerProperty BMI_ID;
    private final StringProperty commitDate;
    private final IntegerProperty Height;
    private final IntegerProperty Weigh;
    private final IntegerProperty Chest_size;
    private final IntegerProperty Waist_size;
    private final IntegerProperty Hip_size;

    public User_size(int BMI_ID, String commitDate, int Height, int Weigh, int Chest_size, int Waist_size, int Hip_size ){
        this.BMI_ID = new SimpleIntegerProperty(BMI_ID);
        this.commitDate = new SimpleStringProperty(commitDate);
        this.Height = new SimpleIntegerProperty(Height);
        this.Weigh = new SimpleIntegerProperty(Weigh);
        this.Chest_size = new SimpleIntegerProperty(Chest_size);
        this.Waist_size = new SimpleIntegerProperty(Waist_size);
        this.Hip_size = new SimpleIntegerProperty(Hip_size);
    }

    public IntegerProperty BMI_IDProperty() {
        return BMI_ID;
    }

    public StringProperty commitDateProperty() {
        return commitDate;
    }

    public IntegerProperty heightProperty() {
        return Height;
    }

    public IntegerProperty weighProperty() {
        return Weigh;
    }

    public IntegerProperty chest_sizeProperty() {
        return Chest_size;
    }

    public IntegerProperty waist_sizeProperty() {
        return Waist_size;
    }

    public IntegerProperty hip_sizeProperty() {
        return Hip_size;
    }

    public int getBMI_ID() {
        return BMI_ID.get();
    }

    public String getCommitDate() {
        return commitDate.get();
    }

    public int getHeight() {
        return Height.get();
    }

    public int getWeigh() {
        return Weigh.get();
    }

    public int getChest_size() {
        return Chest_size.get();
    }

    public int getWaist_size() {
        return Waist_size.get();
    }

    public int getHip_size() {
        return Hip_size.get();
    }

    public void setID(int BMI_ID) {
        this.BMI_ID.set(BMI_ID);
    }

    public void setCommitDate(String commitDate) {
        this.commitDate.set(commitDate);
    }

    public void setHeight(int height) {
        this.Height.set(height);
    }

    public void setWeigh(int weigh) {
        this.Weigh.set(weigh);
    }

    public void setChest_size(int chestSize) {
        this.Chest_size.set(chestSize);
    }

    public void setWaist_size(int waistSize) {
        this.Waist_size.set(waistSize);
    }

    public void setHip_size(int hipSize) {
        this.Hip_size.set(hipSize);
    }
}



