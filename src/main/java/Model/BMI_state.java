package Model;

import javafx.beans.property.*;

public class BMI_state {
    private final IntegerProperty BMI_ID;
    private final StringProperty DateHistory;
    private final FloatProperty BMI;
    private final StringProperty Description;

    public BMI_state(int BMI_ID,String DateHistory,float BMI,String Description){
        this.BMI_ID=new SimpleIntegerProperty(BMI_ID);
        this.DateHistory=new SimpleStringProperty(DateHistory);
        this.BMI=new SimpleFloatProperty(BMI);
        this.Description=new SimpleStringProperty(Description);
    }

    public int getBMI_ID() {
        return BMI_ID.get();
    }

    public String getDateHistory() {
        return DateHistory.get();
    }

    public float getBMI() {
        return BMI.get();
    }

    public String getDescription() {
        return Description.get();
    }

    public IntegerProperty BMI_IDProperty() {
        return BMI_ID;
    }

    public StringProperty dateHistoryProperty() {
        return DateHistory;
    }

    public FloatProperty BMIProperty() {
        return BMI;
    }

    public StringProperty descriptionProperty() {
        return Description;
    }
    public void setBMI_ID(int BMI_ID){
        this.BMI_ID.set(BMI_ID);
    }
    public void setDateHistory(String dateHistory){
        this.DateHistory.set(dateHistory);
    }
    public void setBMI(float BMI){
        this.BMI.set(BMI);
    }
    public void setDescription(String description){
        this.Description.set(description);
    }
}
