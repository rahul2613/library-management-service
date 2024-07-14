package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.User;

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

    public boolean borrowBooks(String bookName) {
        if (library.isBookAvailable(bookName) && user.canBorrow()) {
            user.borrowBook(bookName);
            library.getBooks().remove(new Book(bookName));
            return true;
        }
        return false;
    }
}

