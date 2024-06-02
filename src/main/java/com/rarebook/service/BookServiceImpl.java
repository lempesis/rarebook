package com.rarebook.service;

import com.rarebook.entity.Book;
import com.rarebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
=======
import java.util.List;
import java.util.Optional;
>>>>>>> master

@Service
public class BookServiceImpl implements BookService {

<<<<<<< HEAD
    private BookRepository bookRepository;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        return books;
    }

    @Override
    public Book getBookById(String id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public Book updateBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    @Override
    public void deleteBookById(String id) {
=======
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> searchBooks(String query) {
        return bookRepository.findByTitleContainingOrAuthorContaining(query, query);
    }

    @Override
    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public void deleteBookById(Long id) {
>>>>>>> master
        bookRepository.deleteById(id);
    }
}
