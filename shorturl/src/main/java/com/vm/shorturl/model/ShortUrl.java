package com.vm.shorturl.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class ShortUrl {

    private String longURL;
    @Id
    private String shortURL;
    private LocalDate createdTime;

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

    public LocalDate getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDate createdTime) {
        this.createdTime = createdTime;
    }

    @Override
    public String toString() {
        return "ShortUrl{" +
                ", longURL='" + longURL + '\'' +
                ", shortURL='" + shortURL + '\'' +
                ", createdTime=" + createdTime +
                '}';
    }
}
