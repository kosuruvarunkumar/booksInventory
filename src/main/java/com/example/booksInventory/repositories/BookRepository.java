package com.example.booksInventory.repositories;

import com.example.booksInventory.model.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, String> {
    List<Book> findAll();
}
