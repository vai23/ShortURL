package com.vm.shorturl.controller.dto;

public class NewUrl {
    private String url;

    public NewUrl() {
    }

    public NewUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "NewUrl{" +
                "url='" + url + '\'' +
                '}';
    }
}
