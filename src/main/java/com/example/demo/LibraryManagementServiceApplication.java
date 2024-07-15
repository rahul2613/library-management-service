package com.example.demo;

import com.example.demo.entity.Book;
import com.example.demo.entity.Library;
import com.example.demo.entity.User;
import com.example.demo.service.LibraryManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

public class LibraryManagementServiceApplication {

	public static void main(String[] args) {
		Library library = new Library();
		library.addBook(new Book("Java"));
		library.addBook(new Book("Java"));
		library.addBook(new Book("Clean Code"));
		User user = new User("User1");

		LibraryManagementService libraryManagementService = new LibraryManagementService(library, user);

		//case 1:
		System.out.println(libraryManagementService.viewBooks());

		//case 2:
		libraryManagementService.borrowBooks("Java");

		System.out.println("Borrowed Book: "+ user.getBorrowedBooks());
		System.out.println("Books available in libraray :"+ libraryManagementService.viewBooks());

		//case 4:

		libraryManagementService.returnBook("Java");
		System.out.println("Borrowed Book: "+ user.getBorrowedBooks());
		System.out.println("Books available in libraray :"+ libraryManagementService.viewBooks());


	}

}
