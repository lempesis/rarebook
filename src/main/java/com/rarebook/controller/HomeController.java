package com.rarebook.controller;

import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import com.rarebook.service.BookService;
import com.rarebook.service.ListingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    private BookService bookService;

    @Autowired
    private ListingService listingService;

    @GetMapping("/books")
    public List<Book> searchBooks(@RequestParam String query) {
        return bookService.searchBooks(query);
    }

    @GetMapping("/books/{id}")
    public Book getBook(@PathVariable Long id) {
        return bookService.findBookById(id).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
    }

    @GetMapping("/listings/{bookId}")
    public List<Listing> getListingsByBook(@PathVariable Long bookId) {
        Book book = bookService.findBookById(bookId).orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + bookId));
        return listingService.findListingsByBook(book);
    }
}