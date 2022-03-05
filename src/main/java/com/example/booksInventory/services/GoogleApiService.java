package com.example.booksInventory.services;

import com.example.booksInventory.dto.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class GoogleApiService {
    private final RestTemplate restTemplate;
    private final Environment environment;

    @Autowired
    public GoogleApiService(RestTemplate restTemplate, Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
    }

    public BookDTO getBookDetailsFromGoogleApi(String queryString) {
        String url = environment.getProperty("google.books-api-endpoint") + "?q=" + queryString;
        return restTemplate.getForObject(url, BookDTO.class);
    }
}
