package com.rarebook.service;

import com.rarebook.entity.Book;
<<<<<<< HEAD

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();
    Book getBookById(String id);
    Book updateBook(Book book);
    void deleteBookById(String id) ;
=======
import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> searchBooks(String query);
    Optional<Book> findBookById(Long id);
    List<Book> findAllBooks();
    Book saveBook(Book book);
    void deleteBookById(Long id);
>>>>>>> master
}