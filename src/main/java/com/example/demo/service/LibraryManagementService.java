package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;

import java.util.Map;

public class LibraryManagementService {
    private final Library library;

    public LibraryManagementService(Library library) {
        this.library = library;
    }

    public Map<Book, Integer> viewBooks() {
        return library.getBooks();
    }


}

