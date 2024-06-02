import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import com.rarebook.repository.ListingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ListingServiceImplTest {

    @Mock
    private ListingRepository listingRepository;

    @InjectMocks
    private ListingServiceImpl listingService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testFindListingsByBook() {
        Book book = new Book();
        List<Listing> expectedListings = new ArrayList<>();
        // Populate expectedListings with test data
        when(listingRepository.findByBook(book)).thenReturn(expectedListings);

        List<Listing> actualListings = listingService.findListingsByBook(book);
        assertEquals(expectedListings, actualListings);
    }

    @Test
    public void testSave() {
        Listing listingToSave = new Listing();
        Listing savedListing = new Listing();
        // Populate savedListing with test data
        when(listingRepository.save(listingToSave)).thenReturn(savedListing);

        Listing returnedListing = listingService.save(listingToSave);
        assertEquals(savedListing, returnedListing);
    }
}
