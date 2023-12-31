package com.julian.catalogservice.web;

import com.julian.catalogservice.config.PolarProperties;
import com.julian.catalogservice.domain.Book;
import com.julian.catalogservice.domain.BookService;

import jakarta.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("books")
public class BookController {

    Logger logger = LoggerFactory.getLogger(BookController.class);

    private PolarProperties polarProperties;

    private final BookService bookService;

    public BookController(BookService bookService, PolarProperties polarProperties) {
        this.bookService = bookService;
        this.polarProperties = polarProperties;
    }

    @GetMapping("/")
    public String getGreeting() {
        return polarProperties.getGreeting();
    }

    @GetMapping
    public Iterable<Book> get() {
        logger.info("GET request. BookService viewBookList");
        return bookService.viewBookList();
    }

    @GetMapping("{isbn}")
    public Book getByIsbn(@PathVariable String isbn) {
        return bookService.viewBookDetails(isbn);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book post(@Valid @RequestBody Book book) {
        return bookService.addBookToCatalog(book);
    }

    @DeleteMapping("{isbn}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn) {
        bookService.removeBookFromCatalog(isbn);
    }

    @PutMapping("{isbn}")
    public Book put(@PathVariable String isbn, @Valid @RequestBody Book book) {
        return bookService.editBookDetails(isbn, book);
    }

}
