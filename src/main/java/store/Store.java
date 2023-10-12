package store;

import java.util.ArrayList;
import java.util.List;

import flower.Item;
import filters.Filter;

public class Store {
    List<Item> items;

    public List<Item> search(Filter filter) {
        List<Item> foundItems = new ArrayList<>();
        for (Item item : items) {
            if (filter.match(item)) {
                foundItems.add(item);
            }
        }
        return foundItems;
    }
}
