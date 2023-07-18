package com.izdeveloper.wishlistapp;

import java.util.ArrayList;

public class Storage {
    private ArrayList<Article> list;
    private static Storage single;

    private Storage() {
        list = new ArrayList<>();
    }

    public static Storage getSingle() {
        if (single == null) {
            single = new Storage();
        }
        return single;
    }
    public ArrayList<Article> getItems() {
        return list;
    }

    public void addArticle(Article item) {
        list.add(item);
    }

}
