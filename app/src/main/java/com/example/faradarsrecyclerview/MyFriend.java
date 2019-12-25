package com.example.faradarsrecyclerview;

import androidx.annotation.NonNull;

public class MyFriend {
    private String name;
    private String city;

    public MyFriend(String name, String city){
        this.name=name;
        this.city=city;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @NonNull
    @Override
    public String toString() {
        return name+" ("+city+")";
    }
}
