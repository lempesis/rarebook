package service;

import com.rarebook.entity.Book;
import com.rarebook.repository.BookRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import utils.TestUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class BookServiceTest {
    @InjectMocks
    private BookRepository bookRepository;

    @Test
    public void testFetchData(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(books::add);
        Assert.assertNotNull(books);
    }

    @Test
    public void expectToReturnAllBooks() {
        Book book = bookRepository.findById("3").orElse(null);
        Assert.assertEquals(TestUtils.expectedBook, book);
    }

    @Test
    public void shouldGetTheBookById() {
        Book book = bookRepository.findById("3").orElse(null);
        Assert.assertNotNull(book);
    }

    @Test
    public void shouldDeleteBookById() {
        Book book = bookRepository.findById("3").orElse(null);
        bookRepository.delete(book);

        Assert.assertEquals(39, book.getPrice());
    }

    @Test
    public void shouldUpdateTheBook() {
        Book book = bookRepository.findById("3").orElse(null);
        book.setPrice(39);
        bookRepository.save(book);

        Assert.assertEquals(39, book.getPrice());
    }
}
