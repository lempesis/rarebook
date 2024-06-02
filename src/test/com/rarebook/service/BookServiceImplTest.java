package com.rarebook.service;

import com.rarebook.entity.Book;
import com.rarebook.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceImplTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSearchBooks() {
        String query = "test";
        List<Book> expectedBooks = new ArrayList<>();
        // Populate expectedBooks with test data
        when(bookRepository.findByTitleContainingOrAuthorContaining(query, query)).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.searchBooks(query);
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testFindBookById() {
        Long id = 1L;
        Book expectedBook = new Book();
        // Populate expectedBook with test data
        when(bookRepository.findById(id)).thenReturn(Optional.of(expectedBook));

        Optional<Book> actualBook = bookService.findBookById(id);
        assertEquals(Optional.of(expectedBook), actualBook);
    }
    
    @Test
    public void testFindAllBooks() {
        List<Book> expectedBooks = new ArrayList<>();
        // Populate expectedBooks with test data
        when(bookRepository.findAll()).thenReturn(expectedBooks);

        List<Book> actualBooks = bookService.findAllBooks();
        assertEquals(expectedBooks, actualBooks);
    }

    @Test
    public void testSaveBook() {
        Book bookToSave = new Book();
        Book savedBook = new Book();
        // Populate savedBook with test data
        when(bookRepository.save(bookToSave)).thenReturn(savedBook);

        Book returnedBook = bookService.saveBook(bookToSave);
        assertEquals(savedBook, returnedBook);
    }

    @Test
    public void testDeleteBookById() {
        Long id = 1L;
        doNothing().when(bookRepository).deleteById(id);

        bookService.deleteBookById(id);

        verify(bookRepository, times(1)).deleteById(id);
    }
}
