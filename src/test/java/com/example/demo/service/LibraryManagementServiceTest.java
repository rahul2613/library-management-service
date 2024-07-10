package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;


class LibraryManagementServiceTest {

    @Mock
    Library library;

    LibraryManagementService libraryManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libraryManagementService = new LibraryManagementService(library);
    }

    @Test
    void shouldBeAbleToViewEmptyBooksIfNoBooksArePresentInLibrary() {
        when(library.getBooks()).thenReturn(Map.of());

        Map<Book, Integer> books = libraryManagementService.viewBooks();

        assertEquals(Map.of(), books);
    }

    @Test
    void shouldBeAbleToViewBooksInLibrary() {
        Book cBook = new Book("C");
        Book javaBook = new Book("Java");
        Map<Book, Integer> expectedBooks = Map.of(cBook, 1, javaBook, 2);

        when(library.getBooks()).thenReturn(expectedBooks);

        Map<Book, Integer> books = libraryManagementService.viewBooks();

        assertEquals(expectedBooks, books);
    }
}