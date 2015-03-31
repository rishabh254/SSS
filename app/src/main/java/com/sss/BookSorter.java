package com.sss;

import com.sss.Util.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class BookSorter {
    public void sortBooksByName(ArrayList<Book> books) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book lhs, Book rhs) {
                return lhs.getBookName().compareTo(rhs.getBookName());
            }
        });
    }

    public void sortBooksByDate(ArrayList<Book> books) {

        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book lhs, Book rhs) {
//     //           Date lhsDate = lhs.getDate();
//     //           Date rhsDate = rhs.getDate();
//                if (lhs.getDate() != null && rhs.getDate() != null) {
//                    return rhs.getDate().compareTo(lhs.getDate());
//                } else {
//                    return 0;
//                }
//
            return 0;
            }
        });
    }

    public void sortBooksByRating(ArrayList<Book> books) {
        Collections.sort(books, new Comparator<Book>() {
            @Override
            public int compare(Book lhs, Book rhs) {
                int ratingLhs = lhs.getRatings();
                int ratingRhs = rhs.getRatings();
                if (ratingLhs < ratingRhs) {
                    return 1;
                } else if (ratingLhs > ratingRhs) {
                    return -1;
                } else {
                    return 0;
                }
            }
        });
    }
}
