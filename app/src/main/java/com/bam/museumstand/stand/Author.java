package com.bam.museumstand.stand;

import android.graphics.drawable.Drawable;

public class Author {
    private String __name;
    private String __years;
    private String __about;
    private Drawable __img;

    public Author(String name, String years, String about) {
        __name = name;
        __years = years;
        __about = about;
    }

    public Drawable getImg() {
        return __img;
    }

    public void setImg(Drawable img) {
        __img = img;
    }

    public String getName() {
        return __name;
    }

    public void setName(String name) {
        __name = name;
    }

    public String getYears() {
        return __years;
    }

    public void setYears(String years) {
        __years = years;
    }

    public String getAbout() {
        return __about;
    }

    public void setAbout(String about) {
        __about = about;
    }
}
