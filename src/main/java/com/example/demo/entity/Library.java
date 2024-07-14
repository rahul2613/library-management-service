package com.example.demo.entity;

import java.util.Map;
import java.util.Objects;

public class Library {
    private final Map<Book, Integer> books;

    public Library(Map<Book, Integer> books) {
        this.books = books;
    }

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public boolean isBookAvailable(String bookName) {
        return books.containsKey(new Book(bookName));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return books.equals(library.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books);
    }
}
