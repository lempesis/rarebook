package utils;

import com.rarebook.entity.Book;

import java.util.HashMap;
import java.util.Map;

public class TestUtils {
    public static Book expectedBook = new Book(1, "Wolf of Wall street ", "25 September 2007", 23.0);
    public static Map<Integer, Book> expectedBooks = new HashMap<Integer, Book>() {
        {
            put(1, new Book(1, "Wolf of Wall street ", "25 September 2007", 23.0));
            put(2, new Book(2, "The Lord of the Rings", "29 July 1954", 13.0));
            put(3, new Book(3, "A Game of Thrones", "1 August 1996", 43.34));
        }
    };

}
