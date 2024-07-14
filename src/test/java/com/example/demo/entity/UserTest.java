package com.example.demo.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class UserTest {

    @Test
    void ShouldReturnFalseIfBorrowedBooksLimitExceed() {
        User user = new User("user1");
        user.borrowBook("Java");
        user.borrowBook("clean");

        assertFalse(user.canBorrow());
    }

    @Test
    void shouldBeAbleToRemoveBook() {
        User user = new User("user1");
        user.borrowBook("Java");

        user.returnBook(new Book("Java"));

        assertEquals(0, user.getBorrowedBooks().size());
    }
}