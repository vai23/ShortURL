package com.vm.shorturl.service;

import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.exception.InvalidUrlException;
import com.vm.shorturl.exception.UrlNotFoundException;

public interface ShortUrlService {
    NewUrl getShortUrl(NewUrl url) throws InvalidUrlException;
    NewUrl getLongUrl(NewUrl url) throws UrlNotFoundException;
}
