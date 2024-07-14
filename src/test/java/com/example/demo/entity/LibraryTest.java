package com.example.demo.entity;


import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertTrue;


class LibraryTest {

    @Test
    void shouldReturnTrueIfBookIsAvailable() {
        Map<Book, Integer> map = Map.of(new Book("Java"), 1);
        Library library = new Library(map);

        assertTrue(library.isBookAvailable("Java"));
    }
}