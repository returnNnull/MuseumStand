package com.bam.museumstand.stand;

import com.bam.museumstand.stand.Author;

public class Exhibit {

    private String __name;
    private String __about;
    private Author __author;

    public Exhibit(String name, String about, Author author) {
        __name = name;
        __about = about;
        __author = author;
    }

    public String getName() {
        return __name;
    }

    public void setName(String name) {
        __name = name;
    }

    public String getAbout() {
        return __about;
    }

    public void setAbout(String about) {
        __about = about;
    }

    public Author getAuthor() {
        return __author;
    }

    public void setAuthor(Author author) {
        __author = author;
    }
}
