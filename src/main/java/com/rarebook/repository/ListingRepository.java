package com.rarebook.repository;

import com.rarebook.entity.Book;
import com.rarebook.entity.Listing;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ListingRepository extends JpaRepository<Listing, Long> {
    List<Listing> findByBook(Book book);
}
