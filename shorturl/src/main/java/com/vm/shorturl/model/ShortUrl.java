package com.vm.shorturl.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShortUrl {

    @Id
    private String id;
    private String longURL;
    private String shortURL;

    public ShortUrl() {
    }

    public ShortUrl(String longURL, String shortURL) {
        this.longURL = longURL;
        this.shortURL = shortURL;
    }

    public String getLongURL() {
        return longURL;
    }

    public void setLongURL(String longURL) {
        this.longURL = longURL;
    }

    public String getShortURL() {
        return shortURL;
    }

    public void setShortURL(String shortURL) {
        this.shortURL = shortURL;
    }
}
