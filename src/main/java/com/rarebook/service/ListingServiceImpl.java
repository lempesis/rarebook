package com.rarebook.service;

import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import com.rarebook.repository.ListingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ListingServiceImpl implements ListingService {

    @Autowired
    private ListingRepository listingRepository;

    @Override
    public List<Listing> findListingsByBook(Book book) {
        return listingRepository.findByBook(book);
    }

    @Override
    public Listing save(Listing listing) {
        return listingRepository.save(listing);
    }
}
