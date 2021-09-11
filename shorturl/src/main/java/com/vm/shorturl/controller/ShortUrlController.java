package com.vm.shorturl.controller;

import com.vm.shorturl.controller.dto.NewUrl;
import com.vm.shorturl.service.impl.ShortUrlServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShortUrlController {

    private ShortUrlServiceImpl shortUrlService;

    public ShortUrlController(ShortUrlServiceImpl shortUrlService) {
        this.shortUrlService = shortUrlService;
    }

    @PostMapping("/api/v1/shorten")
    public void postUrl(@RequestBody NewUrl newUrl) {

    }
}
