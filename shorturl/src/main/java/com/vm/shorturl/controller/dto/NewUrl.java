package com.vm.shorturl.controller.dto;

public class NewUrl {
    private String longUrl;

    public NewUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }
}
