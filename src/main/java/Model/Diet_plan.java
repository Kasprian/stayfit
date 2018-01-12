package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Diet_plan {
    private final IntegerProperty diet_ID;
    private final StringProperty Product;
    private final StringProperty Day;
    private final StringProperty Meal_type;
    private final IntegerProperty Weigh_of_the_product;

    public Diet_plan(int diet_ID,String Product,String Day,String Meal_type,int Weigh_of_the_product){
        this.diet_ID=new SimpleIntegerProperty(diet_ID);
        this.Product=new SimpleStringProperty(Product);
        this.Day=new SimpleStringProperty(Day);
        this.Meal_type=new SimpleStringProperty(Meal_type);
        this.Weigh_of_the_product=new SimpleIntegerProperty(Weigh_of_the_product);
    }

    public IntegerProperty diet_IDProperty() {
        return diet_ID;
    }

    public StringProperty productProperty() {
        return Product;
    }

    public StringProperty dayProperty() {
        return Day;
    }

    public StringProperty meal_typeProperty() {
        return Meal_type;
    }

    public IntegerProperty weigh_of_the_productProperty() {
        return Weigh_of_the_product;
    }

    public int getDiet_ID() {
        return diet_ID.get();
    }

    public String getProduct() {
        return Product.get();
    }

    public String getDay() {
        return Day.get();
    }

    public String getMeal_type() {
        return Meal_type.get();
    }

    public int getWeigh_of_the_product() {
        return Weigh_of_the_product.get();
    }
}
