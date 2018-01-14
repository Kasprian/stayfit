package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User_food {
    private final IntegerProperty food_ID;
    private final StringProperty Product;
    private final IntegerProperty Weigh_of_the_product;
    private final StringProperty eatingDate;

    public User_food(int food_ID,String Product,int Weigh_of_the_product,String eatingDate){
        this.food_ID=new SimpleIntegerProperty(food_ID);
        this.Product=new SimpleStringProperty(Product);
        this.Weigh_of_the_product=new SimpleIntegerProperty(Weigh_of_the_product);
        this.eatingDate=new SimpleStringProperty(eatingDate);
    }

    public IntegerProperty diet_IDProperty() {
        return food_ID;
    }

    public StringProperty productProperty() {
        return Product;
    }

    public StringProperty dayProperty() {
        return eatingDate;
    }

    public IntegerProperty weigh_of_the_productProperty() {
        return Weigh_of_the_product;
    }

    public int getDiet_ID() {
        return food_ID.get();
    }

    public String getProduct() {
        return Product.get();
    }

    public String getDay() {
        return eatingDate.get();
    }

    public int getWeigh_of_the_product() {
        return Weigh_of_the_product.get();
    }
}
