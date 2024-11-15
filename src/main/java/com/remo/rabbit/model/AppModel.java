package com.remo.rabbit.model;

public class AppModel {
    public static String MY_API_KEY;

    public static String getMyApiKey() {
        return MY_API_KEY;
    }

    public static void setMyApiKey(String myApiKey) {
        MY_API_KEY = myApiKey;
    }
}
