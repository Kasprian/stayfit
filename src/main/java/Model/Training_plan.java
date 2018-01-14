package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Training_plan {
    private final IntegerProperty train_ID;
    private final StringProperty Exercise;
    private final StringProperty trainingDay;
    private final StringProperty trainingTime;

    public Training_plan(int train_ID,String Exercise,String trainingDay,String trainingTime){
        this.train_ID=new SimpleIntegerProperty(train_ID);
        this.Exercise=new SimpleStringProperty(Exercise);
        this.trainingDay=new SimpleStringProperty(trainingDay);
        this.trainingTime=new SimpleStringProperty(trainingTime);
    }

    public IntegerProperty train_IDProperty() {
        return train_ID;
    }

    public StringProperty exerciseProperty() {
        return Exercise;
    }

    public StringProperty trainingDayProperty() {
        return trainingDay;
    }

    public StringProperty trainingTimeProperty() {
        return trainingTime;
    }

    public int getTrain_ID() {
        return train_ID.get();
    }

    public String getExercise() {
        return Exercise.get();
    }

    public String getTrainingTime() {
        return trainingTime.get();
    }

    public String getTrainingDay() {
        return trainingDay.get();
    }
}
