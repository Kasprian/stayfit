package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Calories_balance {
    private final IntegerProperty ID;
    private final StringProperty commitDate;
    private final IntegerProperty Calories;
    private final IntegerProperty Carbohydrate;
    private final IntegerProperty Protein;
    private final IntegerProperty Fats;

    public Calories_balance(int ID, String commitDate, int Calories, int Carbohydrate, int Protein, int Fats) {
        this.ID = new SimpleIntegerProperty(ID);
        this.commitDate = new SimpleStringProperty(commitDate);
        this.Calories = new SimpleIntegerProperty(Calories);
        this.Carbohydrate = new SimpleIntegerProperty(Carbohydrate);
        this.Protein = new SimpleIntegerProperty(Protein);
        this.Fats = new SimpleIntegerProperty(Fats);
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public void setCommitDate(String commitDate) {
        this.commitDate.set(commitDate);
    }

    public void setCalories(int calories) {
        this.Calories.set(calories);
    }

    public void setCarbohydrate(int carbohydrate) {
        this.Carbohydrate.set(carbohydrate);
    }

    public void setProtein(int protein) {
        this.Protein.set(protein);
    }

    public void setFats(int fats) {
        this.Fats.set(fats);
    }

    public int getID() {
        return ID.get();
    }

    public String getCommitDate() {
        return commitDate.get();
    }

    public int getCalories() {
        return Calories.get();
    }

    public int getCarbohydrate() {
        return Carbohydrate.get();
    }

    public int getProtein() {
        return Protein.get();
    }

    public int getFats() {
        return Fats.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
    }

    public StringProperty commitDateProperty() {
        return commitDate;
    }

    public IntegerProperty caloriesProperty() {
        return Calories;
    }

    public IntegerProperty carbohydrateProperty() {
        return Carbohydrate;
    }

    public IntegerProperty proteinProperty() {
        return Protein;
    }

    public IntegerProperty fatsProperty() {
        return Fats;
    }
}
