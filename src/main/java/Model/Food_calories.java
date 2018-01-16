package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Food_calories {
    private final StringProperty Product;
    private final IntegerProperty Calories_per_100gram;
    private final IntegerProperty Carbohydrate_per_100gram;
    private final IntegerProperty Protein_per_100gram;
    private final IntegerProperty Fats_per_100gram;

    public Food_calories(String Product,Integer calories_per_100gram, Integer carbohydrate_per_100gram, Integer protein_per_100gram, Integer fats_per_100gram) {
        this.Product = new SimpleStringProperty(Product);
        this.Calories_per_100gram = new SimpleIntegerProperty(calories_per_100gram);
        this.Carbohydrate_per_100gram = new SimpleIntegerProperty(carbohydrate_per_100gram);
        this.Protein_per_100gram = new SimpleIntegerProperty(protein_per_100gram);
        this.Fats_per_100gram = new SimpleIntegerProperty(fats_per_100gram);
    }

    public StringProperty productProperty() {
        return Product;
    }

    public IntegerProperty calories_per_100gramProperty() {
        return Calories_per_100gram;
    }

    public IntegerProperty carbohydrate_per_100gramProperty() {
        return Carbohydrate_per_100gram;
    }

    public IntegerProperty fats_per_100gramProperty() {
        return Fats_per_100gram;
    }

    public IntegerProperty protein_per_100gramProperty() {
        return Protein_per_100gram;
    }

    public String getProduct() {
        return Product.get();
    }

    public int getCalories_per_100gram() {
        return Calories_per_100gram.get();
    }

    public int getCarbohydrate_per_100gram() {
        return Carbohydrate_per_100gram.get();
    }

    public int getProtein_per_100gram() {
        return Protein_per_100gram.get();
    }

    public int getFats_per_100gram() {
        return Fats_per_100gram.get();
    }
}
