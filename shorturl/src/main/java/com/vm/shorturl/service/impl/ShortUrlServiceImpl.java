package com.vm.shorturl.service.impl;

import com.google.common.hash.Hashing;
import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.exception.InvalidUrlException;
import com.vm.shorturl.model.ShortUrl;
import com.vm.shorturl.repository.ShortUrlRepository;
import com.vm.shorturl.service.ShortUrlService;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.Charset;
import java.time.LocalDate;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

    private ShortUrlRepository shortUrlRepository;

    public ShortUrlServiceImpl(ShortUrlRepository shortUrlRepository) {
        this.shortUrlRepository = shortUrlRepository;
    }

    @Override
    public NewUrl getShortUrl(NewUrl url) throws InvalidUrlException {

        UrlValidator urlValidator = new UrlValidator(new String[]
                {
                        "http", "https"
                }
        );

        if (!urlValidator.isValid(url.getUrl())) {
            throw new InvalidUrlException(url + " is invalid");
        }

        String shortUrl = Hashing.murmur3_32().hashString(url.getUrl(), Charset.defaultCharset()).toString();

        ShortUrl shortUrlOb = new ShortUrl();
        shortUrlOb.setShortURL(shortUrl);
        shortUrlOb.setLongURL(url.getUrl());
        shortUrlOb.setCreatedTime(LocalDate.now());

        shortUrlRepository.save(shortUrlOb);

        return new NewUrl(shortUrl);
    }

    @Override
    public NewUrl getLongUrl(NewUrl url) {
        return null;
    }
}
