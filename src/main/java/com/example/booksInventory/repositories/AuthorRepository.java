package com.example.booksInventory.repositories;

import com.example.booksInventory.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
    Author findByauthorName(String authorName);
}
