package com.rarebook.service;

import com.rarebook.entity.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> searchBooks(String query);
    Optional<Book> findBookById(Long id);
    List<Book> findAllBooks();
    Book saveBook(Book book);
    void deleteBookById(Long id);
}