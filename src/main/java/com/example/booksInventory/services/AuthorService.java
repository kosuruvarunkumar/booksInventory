package com.example.booksInventory.services;

import com.example.booksInventory.model.Author;
import com.example.booksInventory.repositories.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<Author> saveAuthor(Set<Author> authors) {
        return ((List<Author>) authorRepository.saveAll(authors));
    }

    public Author findByauthorName(String authorName) {
        return authorRepository.findByauthorName(authorName);
    }
}
