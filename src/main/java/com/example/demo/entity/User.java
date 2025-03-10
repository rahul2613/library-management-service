package com.example.demo.entity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {
    private final String name;
    private final Set<Book> borrowedBooks = new HashSet<>();
    private static final int BORROW_LIMIT = 2;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public boolean borrowBook(String bookName) {
            return borrowedBooks.add(new Book(bookName));
    }

    public boolean canBorrow() {
        return borrowedBooks.size() < BORROW_LIMIT;
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) && borrowedBooks.equals(user.borrowedBooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, borrowedBooks);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", borrowedBooks=" + borrowedBooks +
                '}';
    }
}
