package graphapp;

import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public abstract class Graph {

    protected String caption;
    protected List<Item> items;

    public Graph(String value) {
        setCaption(value);
        items = new ArrayList<>();
    }

    public void add(Item item) {
        items.add(item);
    }

    public void setCaption(String value) {
        caption = value;
    }

    public String getCaption() {
        return caption;
    }

    protected int getItemMaxValue() {
        /*
        int maxValue = 0;
        for (Item item : items) {
            if (item.getValue() > maxValue) {
                maxValue = item.getValue();
            }
        }
        return maxValue;
         */
        return items.stream().max(Comparator.comparing(Item::getValue)).get().getValue();
    }

    protected int getItemMaxNameLength() {
        int maxNameLength = 0;
        for (Item item : items) {
            if (item.getName().length() > maxNameLength) {
                maxNameLength = item.getName().length();
            }
        }
        return maxNameLength;
    }

    public abstract void print();
}
