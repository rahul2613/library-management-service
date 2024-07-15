package com.example.demo.entity;


import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class LibraryTest {

    @Test
    void shouldReturnTrueIfBookIsAvailable() {
        Map<Book, Integer> map = Map.of(new Book("Java"), 1);
        Library library = new Library();
        library.setBooks(map);

        assertTrue(library.isBookAvailable("Java"));
    }

    @Test
    void shouldRemoveBookFromLibrary() {
        Book book = new Book("Java");
        Map<Book, Integer> map = new HashMap<>();
        map.put(book, 1);
        Library library = new Library();
        library.setBooks(map);

        library.removeBook(book);

        assertEquals(0, library.getBooks().size());
    }

    @Test
    void shouldUpdateRemainingCopiesOfBookCorrectly() {
        Book book = new Book("Java");
        Map<Book, Integer> map = new HashMap<>();
        map.put(book, 2);
        Library library = new Library();
        library.setBooks(map);

        library.removeBook(book);

        assertEquals(1, library.getBooks().size());
    }

    @Test
    void shouldBeAbleToAddBook() {
        Book book = new Book("Java");
        Map<Book, Integer> map = new HashMap<>();
        map.put(book, 2);
        Library library = new Library();
        library.setBooks(map);

        library.addBook(book);

        assertEquals(3, library.getBooks().get(book));
    }
}