package flower;

import java.util.ArrayList;
import java.util.List;

public class FlowerBucket extends Item{
    private List<FlowerPack> flowerBucket = new ArrayList<>();

    public void add(FlowerPack flowerPack) {
        flowerBucket.add(flowerPack);
    }

    public double getPrice() {
        double price = 0;
        for (FlowerPack flowerPack : flowerBucket) {
            price += flowerPack.getPrice();
        }
        return price;
    }
}
