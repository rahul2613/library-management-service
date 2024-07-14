package com.example.demo.entity;

import java.util.Map;
import java.util.Objects;

public class Library {
    private Map<Book, Integer> books;

    public Library(Map<Book, Integer> books) {
        this.books = books;
    }

    public Map<Book, Integer> getBooks() {
        return books;
    }

    public boolean isBookAvailable(String bookName) {
        return books.containsKey(new Book(bookName));
    }

    public void removeBook(Book book) {
        if (books.get(book) == 1) {
            books.remove(book);
        }
        if (books.containsKey(book)) {
            Integer existingNumberOfCopies = books.get(book);
            books.put(book, existingNumberOfCopies - 1);
        }
    }

    public void addBook(Book book) {
        books.put(book, books.getOrDefault(book, 0) + 1);
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
