package com.vm.shorturl.repository;

import com.vm.shorturl.model.ShortUrl;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ShortUrlRepository extends CrudRepository<ShortUrl, String> {
}
