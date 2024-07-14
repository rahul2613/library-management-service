package com.example.demo.entity;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class UserTest {

    @Test
    void ShouldReturnFalseIfBorrowedBooksLimitExceed() {
        User user = new User("user1");
        user.borrowBook("Java");
        user.borrowBook("clean");

        assertFalse(user.canBorrow());
    }
}