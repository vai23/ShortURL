package com.vm.shorturl.controller;

import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.exception.InvalidUrlException;
import com.vm.shorturl.exception.UrlNotFoundException;
import com.vm.shorturl.service.impl.ShortUrlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class ShortUrlController {

    private static final Logger logger = LoggerFactory.getLogger(ShortUrlServiceImpl.class);

    private ShortUrlServiceImpl shortUrlService;

    public ShortUrlController(ShortUrlServiceImpl shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("shorten")
    public NewUrl shorten(@RequestBody NewUrl url) {

        logger.info("Received Url to shorten : " + url);

        NewUrl shortUrl = null;

        try {
            shortUrl = shortUrlService.getShortUrl(url);
        } catch (InvalidUrlException invalidUrlException) {
            logger.error(invalidUrlException.getMessage());
        }

        logger.info("Generated short url : " + shortUrl);

        return shortUrl;
    }

    @GetMapping("{key}")
    public NewUrl getLongUrl(@PathVariable String key) {

        logger.info("Got key : " + key);

        NewUrl longUrl = null;

        try {
            longUrl = shortUrlService.getLongUrl(new NewUrl(key));
        } catch (UrlNotFoundException urlNotFoundException) {
            logger.error(urlNotFoundException.getMessage());
        }

        logger.info("Got long url from key : " + longUrl);

        return longUrl;
    }
}
