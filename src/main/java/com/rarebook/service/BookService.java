package com.rarebook.service;

import com.rarebook.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book updateBook(Book book);
    void deleteBookById(String id) ;
}