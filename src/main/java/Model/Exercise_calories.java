package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Exercise_calories {
    private final StringProperty Exercise;
    private final IntegerProperty Calories_per_hour;

    public Exercise_calories(String exercise,int Calories_per_hour) {
        this.Exercise =new SimpleStringProperty(exercise);
        this.Calories_per_hour=new SimpleIntegerProperty(Calories_per_hour);
    }

    public IntegerProperty calories_per_hourProperty() {
        return Calories_per_hour;
    }

    public StringProperty exerciseProperty() {
        return Exercise;
    }

    public String getExercise() {
        return Exercise.get();
    }

    public int getCalories_per_hour() {
        return Calories_per_hour.get();
    }
    public void setExercise(){

    }
}
