package com.rarebook.repository;

import com.rarebooks.demo.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class BookRepositoryTest {

    @Autowired
    private BookRepository bookRepository;

    private Book testBook1;
    private Book testBook2;

    @BeforeEach
    public void setUp() {
        testBook1 = new Book();
        testBook1.setTitle("Test Book 1");
        testBook1.setAuthor("Test Author 1");
        bookRepository.save(testBook1);

        testBook2 = new Book();
        testBook2.setTitle("Test Book 2");
        testBook2.setAuthor("Test Author 2");
        bookRepository.save(testBook2);
    }

    @Test
    public void testCreateBook() {
        Book book = new Book();
        book.setTitle("New Book");
        book.setAuthor("New Author");
        bookRepository.save(book);

        assertThat(book.getId()).isNotNull();
    }

    @Test
    public void testFindBookById() {
        Optional<Book> foundBook = bookRepository.findById(testBook1.getId());
        assertThat(foundBook).isPresent();
        assertThat(foundBook.get().getTitle()).isEqualTo("Test Book 1");
    }

    @Test
    public void testUpdateBook() {
        testBook1.setTitle("Updated Title");
        bookRepository.save(testBook1);

        Optional<Book> updatedBook = bookRepository.findById(testBook1.getId());
        assertThat(updatedBook).isPresent();
        assertThat(updatedBook.get().getTitle()).isEqualTo("Updated Title");
    }

    @Test
    public void testDeleteBook() {
        bookRepository.delete(testBook1);
        Optional<Book> deletedBook = bookRepository.findById(testBook1.getId());
        assertThat(deletedBook).isNotPresent();
    }

    @Test
    public void testFindBooksByAuthor() {
        List<Book> booksByAuthor1 = bookRepository.findByAuthor("Test Author 1");
        assertThat(booksByAuthor1).hasSize(1).extracting(Book::getTitle).contains("Test Book 1");
    }

    @Test
    public void testFindBooksByTitleContaining() {
        List<Book> booksWithTitleContaining = bookRepository.findByTitleContaining("Test");
        assertThat(booksWithTitleContaining).hasSize(2)
                .extracting(Book::getTitle)
                .contains("Test Book 1", "Test Book 2");
    }

    @Test
    public void testFindAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        assertThat(allBooks).hasSize(2);
    }

    @Test
    public void testCreateBookWithNullTitle() {
        Book book = new Book();
        book.setAuthor("Author with no title");

        assertThatThrownBy(() -> {
            bookRepository.save(book);
        }).isInstanceOf(Exception.class);
    }

    @Test
    public void testCreateBookWithNullAuthor() {
        Book book = new Book();
        book.setTitle("Title with no author");

        assertThatThrownBy(() -> {
            bookRepository.save(book);
        }).isInstanceOf(Exception.class);
    }

    @Test
    public void testFindBooksByTitle() {
        List<Book> booksByTitle = bookRepository.findByTitle("Test Book 1");
        assertThat(booksByTitle).hasSize(1)
                .extracting(Book::getTitle)
                .contains("Test Book 1");
    }

    @Test
    public void testFindBooksByNonExistentAuthor() {
        List<Book> booksByNonExistentAuthor = bookRepository.findByAuthor("Non Existent Author");
        assertThat(booksByNonExistentAuthor).isEmpty();
    }

    @Test
    public void testFindBooksByTitleNotContaining() {
        List<Book> booksWithTitleNotContaining = bookRepository.findByTitleContaining("Non Existent");
        assertThat(booksWithTitleNotContaining).isEmpty();
    }
}
