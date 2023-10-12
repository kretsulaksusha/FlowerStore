package filters;

import java.util.ArrayList;
import java.util.List;

import flower.Flower;
import flower.FlowerBucket;
import flower.FlowerColor;
import flower.FlowerType;
import flower.FlowerPack;
import flower.Item;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor @Getter @Setter
public class FilterFlower implements Filter {
    // all flowers
    private List<Flower> flowers;
    // min and max sepal length
    private double sepalLengthMin;
    private double sepalLengthMax;
    // min and max price
    private double priceMin;
    private double priceMax;
    // all colors
    private List<FlowerColor> colorList = new ArrayList<>();
    // all types of flowers
    private List<FlowerType> flowerTypeList = new ArrayList<>();

    @Override
    public boolean match(Item item) {
        if (item instanceof FlowerBucket == false) {
            throw new IllegalArgumentException("Invalid type for flower");
        }

        FlowerBucket flowerBuck = (FlowerBucket)item;
        if (priceMin > flowerBuck.getPrice() && flowerBuck.getPrice() > priceMax) {
                return false;
        }

        Flower flower;
        boolean hasFlower = false;
        boolean hasSepalLen = false;
        boolean hasType = false;

        for (FlowerPack flowerPack : flowerBuck.getFlowerBucket()) {
            flower = flowerPack.getFlower();
            if (flowers.contains(flower)) {
                hasFlower = true;
            }
            if (sepalLengthMin <= flower.getSepalLength() &&
                flower.getSepalLength() <= sepalLengthMax) {
                hasSepalLen = true;
            }
            if (flowerTypeList.contains(flower.getFlowerType())) {
                hasType = true;
            }
            if (hasFlower && hasSepalLen && hasType) {
                return true;
            }
        }
        
        return false;
    }
}
