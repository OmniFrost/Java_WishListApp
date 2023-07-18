package com.izdeveloper.wishlistapp;

public class Article {

    private String itemName, itemDescription;
    private long timeOfAddition;

    public Article(String itemName, String itemDescription) {
        this.itemName = itemName;
        this.itemDescription = itemDescription;
        this.timeOfAddition = System.currentTimeMillis();
    }

    public String getItemName() {
        return itemName;
    }

    public String getItemDescription() {
        return itemDescription;
    }

    public long getTimeOfAddition() {
        return timeOfAddition;
    }
}
