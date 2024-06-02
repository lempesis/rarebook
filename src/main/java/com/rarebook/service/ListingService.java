package com.rarebook.service;

import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import java.util.List;

public interface ListingService {
    List<Listing> findListingsByBook(Book book);
    Listing save(Listing listing);
}
