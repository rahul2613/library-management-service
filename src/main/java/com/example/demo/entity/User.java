package com.example.demo.entity;

import java.util.Objects;
import java.util.Set;

public class User {
    private final String name;
    private final Set<Book> borrowedBooks;

    public User(String name, Set<Book> borrowedBooks) {
        this.name = name;
        this.borrowedBooks = borrowedBooks;
    }

    public String getName() {
        return name;
    }

    public Set<Book> getBorrowedBooks() {
        return borrowedBooks;
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
