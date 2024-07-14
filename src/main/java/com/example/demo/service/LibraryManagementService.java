package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.User;
import com.example.demo.exception.UserException;

import java.util.Map;

public class LibraryManagementService {
    private final Library library;
    private final User user;

    public LibraryManagementService(Library library, User user) {
        this.library = library;
        this.user = user;
    }

    public Map<Book, Integer> viewBooks() {
        return library.getBooks();
    }

    public boolean borrowBooks(User user, String bookName) {
        try {
            return user.borrowBook(bookName);
        } catch (UserException userException) {
            System.out.println("Exception occured while borrowing book");
            return false;
        }
    }
}

