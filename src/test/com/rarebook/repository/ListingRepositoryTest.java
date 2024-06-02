package com.rarebook.repository;

import com.rarebooks.demo.entity.Book;
import com.rarebooks.demo.entity.Listing;
import com.rarebooks.demo.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class ListingRepositoryTest {

    @Autowired
    private ListingRepository listingRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    private User testUser;
    private Book testBook;

    @BeforeEach
    public void setUp() {
        testUser = new User();
        testUser.setUsername("testuser");
        testUser.setPassword("password");
        userRepository.save(testUser);

        testBook = new Book();
        testBook.setTitle("Test Book");
        testBook.setAuthor("Test Author");
        bookRepository.save(testBook);
    }

    @Test
    public void testCreateListing() {
        Listing listing = new Listing();
        listing.setBook(testBook);
        listing.setUser(testUser);
        listing.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing);

        assertThat(listing.getId()).isNotNull();
    }

    @Test
    public void testFindListingById() {
        Listing listing = new Listing();
        listing.setBook(testBook);
        listing.setUser(testUser);
        listing.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing);

        Optional<Listing> foundListing = listingRepository.findById(listing.getId());
        assertThat(foundListing).isPresent();
        assertThat(foundListing.get().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(19.99));
    }

    @Test
    public void testUpdateListing() {
        Listing listing = new Listing();
        listing.setBook(testBook);
        listing.setUser(testUser);
        listing.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing);

        listing.setPrice(BigDecimal.valueOf(29.99));
        listingRepository.save(listing);

        Optional<Listing> updatedListing = listingRepository.findById(listing.getId());
        assertThat(updatedListing).isPresent();
        assertThat(updatedListing.get().getPrice()).isEqualByComparingTo(BigDecimal.valueOf(29.99));
    }

    @Test
    public void testDeleteListing() {
        Listing listing = new Listing();
        listing.setBook(testBook);
        listing.setUser(testUser);
        listing.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing);

        listingRepository.delete(listing);
        Optional<Listing> deletedListing = listingRepository.findById(listing.getId());
        assertThat(deletedListing).isNotPresent();
    }

    @Test
    public void testFindListingsByUser() {
        Listing listing1 = new Listing();
        listing1.setBook(testBook);
        listing1.setUser(testUser);
        listing1.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing1);

        Listing listing2 = new Listing();
        listing2.setBook(testBook);
        listing2.setUser(testUser);
        listing2.setPrice(BigDecimal.valueOf(29.99));
        listingRepository.save(listing2);

        List<Listing> userListing = listingRepository.findByUser(testUser);
        assertThat(userListing).hasSize(2);
    }

    @Test
    public void testFindListingsByBook() {
        Listing listing1 = new Listing();
        listing1.setBook(testBook);
        listing1.setUser(testUser);
        listing1.setPrice(BigDecimal.valueOf(19.99));
        listingRepository.save(listing1);

        Listing listing2 = new Listing();
        listing2.setBook(testBook);
        listing2.setUser(testUser);
        listing2.setPrice(BigDecimal.valueOf(29.99));
        listingRepository.save(listing2);

        List<Listing> bookListings = listingRepository.findByBook(testBook);
        assertThat(bookListings).hasSize(2);
    }

    @Test
    public void testFindListingsByPriceLessThan() {
        Listing listing1 = new Listing();
        listing1.setBook(testBook);
        listing1.setUser(testUser);
        listing1.setPrice(BigDecimal.valueOf(15.99));
        listingRepository.save(listing1);

        Listing listing2 = new Listing();
        listing2.setBook(testBook);
        listing2.setUser(testUser);
        listing2.setPrice(BigDecimal.valueOf(25.99));
        listingRepository.save(listing2);

        List<Listing> cheapListings = listingRepository.findByPriceLessThan(BigDecimal.valueOf(20.00));
        assertThat(cheapListings).hasSize(1);
        assertThat(cheapListings.get(0).getPrice()).isEqualByComparingTo(BigDecimal.valueOf(15.99));
    }

    @Test
    public void testFindAllListings() {
        List<Listing> allListings = listingRepository.findAll();
        assertThat(allListings).isNotEmpty();
    }

    @Test
    public void testCreateListingWithNullValues() {
        Listing listing = new Listing();
        listing.setPrice(BigDecimal.valueOf(19.99));

        assertThatThrownBy(() -> {
            listingRepository.save(listing);
        }).isInstanceOf(Exception.class);
    }
}
