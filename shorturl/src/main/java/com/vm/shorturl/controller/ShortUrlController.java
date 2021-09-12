package com.vm.shorturl.controller;

import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.exception.InvalidUrlException;
import com.vm.shorturl.exception.UrlNotFoundException;
import com.vm.shorturl.service.impl.ShortUrlServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<NewUrl> shorten(@RequestBody NewUrl url) {

        logger.info("Received Url to shorten : " + url);

        NewUrl shortUrl = null;

        try {
            shortUrl = shortUrlService.getShortUrl(url);
        } catch (InvalidUrlException invalidUrlException) {
            logger.error(invalidUrlException.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }

        logger.info("Generated short url : " + shortUrl);

        return ResponseEntity.status(HttpStatus.CREATED).body(shortUrl);
    }

    @GetMapping("{key}")
    public ResponseEntity<NewUrl> getLongUrl(@PathVariable String key) {

        logger.info("Got key : " + key);

        NewUrl longUrl = null;

        try {
            longUrl = shortUrlService.getLongUrl(new NewUrl(key));
        } catch (UrlNotFoundException urlNotFoundException) {
            logger.error(urlNotFoundException.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        logger.info("Got long url from key : " + longUrl);

        return ResponseEntity.status(HttpStatus.FOUND).body(longUrl);
    }
}
