package com.vm.shorturl.service;

import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.exception.InvalidUrlException;

public interface ShortUrlService {
    NewUrl getShortUrl(NewUrl url) throws InvalidUrlException;
    NewUrl getLongUrl(NewUrl url);
}
