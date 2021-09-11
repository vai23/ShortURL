package com.vm.shorturl.service;

public interface ShortUrlService {
    String getShortUrl(String longUrl);
    String getLongUrl(String shortUrl);
}
