package com.example.Bookstore;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;
import com.example.Bookstore.domain.User;
import com.example.Bookstore.domain.UserRepository;

@SpringBootApplication
public class BookStoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookStoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository,CategoryRepository crepository, UserRepository urepository) {
	return (args) -> {
		log.info("save a couple of books");
		
		crepository.save(new Category("Sales"));
		crepository.save(new Category("Marketing"));
		crepository.save(new Category("Development"));
		
		Book book1 = new Book("John", "Sales Representative", 25, "S21", 2500, crepository.findByName("Sales").get(0));
		Book book2 = new Book("Mikka", "Sales Manger", 30, "S12", 6000, crepository.findByName("Sales").get(0));
		Book book3 = new Book("Ettu", "Digital Marketing", 41, "M13", 2500, crepository.findByName("Marketing").get(0));
		Book book4 = new Book("Jussi", "Specialist", 27, "M14", 2000, crepository.findByName("Marketing").get(0));
		Book book5 = new Book("Jonna", "Software Developer", 34, "D11", 4500, crepository.findByName("Development").get(0));
		Book book6 = new Book("Marko", "Researcher", 42, "D23", 4000, crepository.findByName("Development").get(0));
		
	
		repository.save(book1);
		repository.save(book2);
		repository.save(book3);
		repository.save(book4);
		repository.save(book5);
		repository.save(book6);
		
		//Demo user
				//https://www.browserling.com/tools/bcrypt using this to generate bcrypt password
				User user1 = new User("user", "$2a$10$n1UULdce1utCr3tC/XLP0OjIOAwjFB0yCImFkAgeyXcevf9jPnK3.", "admin@gmail.com", "USER");
				User user2 = new User("admin", "$2a$10$cDLOfjCusgDBg0WSaWOs7ewujF4PTAgW5FednrvNlpR05d73Jp./q", "user@gmail.com", "ADMIN");
				urepository.save(user1);
			    urepository.save(user2);

		
		
		log.info("fetch all books");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
		}
	
	};
	}

}
