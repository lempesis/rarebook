package com.rarebook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.rarebook.service.BookServiceImpl;
import com.rarebook.entity.Book;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServiceImpl bookServiceImpl;

    @RequestMapping(method = RequestMethod.GET)
    public Collection<Book> getAllBooks(){
        return bookServiceImpl.getAllBooks();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteBookById(@PathVariable("id") String id) {
        bookServiceImpl.deleteBookById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Book getBookById(@PathVariable("id") String id) {
        return bookServiceImpl.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateBook(@RequestBody Book book) {
        this.bookServiceImpl.updateBook(book);
    }
}
