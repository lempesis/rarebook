package com.rarebook.controller;

import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import com.rarebook.service.BookService;
import com.rarebook.service.ListingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class HomeControllerTest {

    private MockMvc mockMvc;

    @Mock
    private BookService bookService;

    @Mock
    private ListingService listingService;

    @InjectMocks
    private HomeController homeController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testSearchBooks() throws Exception {
        Book book1 = new Book(1L, "Title 1", "Author 1", 2022);
        Book book2 = new Book(2L, "Title 2", "Author 2", 2023);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookService.searchBooks(anyString())).thenReturn(books);

        mockMvc.perform(get("/api/books?query=test"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].title").value("Title 1"))
                .andExpect(jsonPath("$[1].title").value("Title 2"));
    }

    @Test
    public void testGetBook() throws Exception {
        Book book = new Book(1L, "Title", "Author", 2022);

        when(bookService.findBookById(anyLong())).thenReturn(java.util.Optional.of(book));

        mockMvc.perform(get("/api/books/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.author").value("Author"))
                .andExpect(jsonPath("$.year").value(2022));
    }

    @Test
    public void testGetListingsByBook() throws Exception {
        Book book = new Book(1L, "Title", "Author", 2022);
        Listing listing1 = new Listing(1L, book, "Seller 1", 100.0);
        Listing listing2 = new Listing(2L, book, "Seller 2", 150.0);
        List<Listing> listings = Arrays.asList(listing1, listing2);

        when(bookService.findBookById(anyLong())).thenReturn(java.util.Optional.of(book));
        when(listingService.findListingsByBook(book)).thenReturn(listings);

        mockMvc.perform(get("/api/listings/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].seller").value("Seller 1"))
                .andExpect(jsonPath("$[1].seller").value("Seller 2"))
                .andExpect(jsonPath("$[0].price").value(100.0))
                .andExpect(jsonPath("$[1].price").value(150.0));
    }
}
