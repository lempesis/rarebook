package com.rarebook.service;

import com.rarebook.entity.Book;
import com.rarebook.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

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
        bookRepository.deleteById(id);
    }
}
