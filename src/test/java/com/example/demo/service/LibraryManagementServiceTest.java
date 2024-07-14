package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;


class LibraryManagementServiceTest {

    @Mock
    Library library;

    @Mock
    User user;

    LibraryManagementService libraryManagementService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        libraryManagementService = new LibraryManagementService(library, user);
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

    @Test
    void shouldBeAbleToBorrowBookFromLibrary() throws UserException {
        when(user.borrowBook("Java")).thenReturn(true);
        assertTrue(libraryManagementService.borrowBooks(user, "Java"));
    }

    @Test
    void shouldUserBeAbleToBorrowMax2Book() throws UserException {
        when(user.borrowBook("Java")).thenThrow(UserException.class);
        assertFalse(libraryManagementService.borrowBooks(user, "Java"));
    }

    @Test
    void shouldRemoveBookFromLibraryAfterBorrow() throws UserException {
        Book cBook = new Book("C");
        Book javaBook = new Book("Java");
        Map<Book, Integer> expectedBooks = new HashMap<>();
        expectedBooks.put(cBook, 1);
        expectedBooks.put(javaBook, 1);

        when(library.getBooks()).thenReturn(expectedBooks);
        when(user.borrowBook("Java")).thenReturn(true);

        libraryManagementService.borrowBooks(user, "Java");

        assertFalse(library.getBooks().containsKey(new Book("Java")));
    }
}