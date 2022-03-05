package com.example.booksInventory.controllers;

import com.example.booksInventory.dto.BookDTO;
import com.example.booksInventory.dto.BookDTOForInventory;
import com.example.booksInventory.model.Author;
import com.example.booksInventory.model.Book;
import com.example.booksInventory.services.AuthorService;
import com.example.booksInventory.services.BookService;
import com.example.booksInventory.services.GoogleApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
public class BookController {
    private final GoogleApiService googleApiService;
    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(GoogleApiService googleApiService, BookService bookService, AuthorService authorService) {
        this.googleApiService = googleApiService;
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping("/{queryString}")
    public ResponseEntity<BookDTO> getBooksFromGoogleApi(@PathVariable String queryString) {
        return new ResponseEntity<>(googleApiService.getBookDetailsFromGoogleApi(queryString), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<?> getAllBooksInInventory() {
        return new ResponseEntity<>(bookService.getAllBooksInInventory(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<?> saveBook(@RequestBody BookDTOForInventory bookDTOForInventory) {
        Book book = getBookFromBookDTOForInventory(bookDTOForInventory);
        return new ResponseEntity<>(bookService.saveBook(book), HttpStatus.OK);
    }

    private Book getBookFromBookDTOForInventory(BookDTOForInventory bookDTOForInventory) {
        Book book = new Book();
        book.setgID(bookDTOForInventory.getgID());
        book.seteTag(bookDTOForInventory.geteTag());
        book.setTitle(bookDTOForInventory.getTitle());
        book.setPublisher(bookDTOForInventory.getPublisher());
        book.setPublishedDate(bookDTOForInventory.getPublishedDate());
        book.setDescription(bookDTOForInventory.getDescription());
        book.setImageLink(bookDTOForInventory.getImageLink());
        book.setCount(bookDTOForInventory.getCount());
        book.setAuthors(addAuthors(bookDTOForInventory.getAuthors().split(",")));
        return book;
    }

    private Set<Author> addAuthors(String[] authorsInString) {
        Set<Author> authors = new HashSet<>();
        for(String authorInString : authorsInString) {
            if(authorService.findByauthorName(authorInString) == null) {
                Author author = new Author();
                author.setAuthorName(authorInString);
                authors.add(author);
            }else {
                authors.add(authorService.findByauthorName(authorInString));
            }
        }
        return new HashSet<>(authorService.saveAuthor(authors));

    }
}
