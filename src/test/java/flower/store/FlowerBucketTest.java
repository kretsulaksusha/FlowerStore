/**
 * Flower package for creating flowers.
 */
package flower.store;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import flower.Flower;
import flower.FlowerBucket;
import flower.FlowerPack;

import org.junit.jupiter.api.Assertions;

import java.util.Random;

public class FlowerBucketTest {
    // creating renerator
    private static final Random RANDOM_GENERATOR = new Random();
    // setting max quantity
    private static final int MAX_QUANTITY = 1000;
    // setting max price
    private static final int MAX_PRICE = 100;

    private FlowerBucket flowerBucket;

    /**
     * Initializing FlowerBucket
     */
    @BeforeEach
    public void init() {
        flowerBucket = new FlowerBucket();
    }

    /**
     * Testing getPrice method in FlowerBucket
     */
    @Test
    public void testPrice() {
        int price = RANDOM_GENERATOR.nextInt(MAX_PRICE);
        int quantity = RANDOM_GENERATOR.nextInt(MAX_QUANTITY);
        Flower flower = new Flower();
        flower.setPrice(price);
        FlowerPack flowerPack = new FlowerPack(flower, quantity);
        flowerBucket.add(flowerPack);
        Assertions.assertEquals(price * quantity, flowerBucket.getPrice());
    }
}
