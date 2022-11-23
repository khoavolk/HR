package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
//import com.example.Bookstore.domain.CategoryRepository;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

	 @Autowired
	    private BookRepository repository;
	    //private CategoryRepository crepository;
	 
	    //Check if I can find a book
	    @Test
	    public void findByTitleShouldReturnBook() {
	        List<Book> books = repository.findByAuthor("G.G.Martin");
	        
	        assertThat(books).hasSize(1);
	        assertThat(books.get(0).getAuthor()).isEqualTo("G.G.Martin");
	    }
	    
	    //Check if I can save a new book
	    @Test
	    public void createNewBook() {
	    	Book book = new Book("IT", "Stephene King", 1992, "2113", 70, new Category("Horror"));
	    	repository.save(book);
	    	assertThat(book.getId()).isNotNull();
	    }  
	    
	    //Check if I can delete book
	    @Test
	    public void deleteBook() {
	    	List<Book> books = repository.findByTitle("Twilight");
	    	assertThat(books).hasSize(1);
	    	repository.deleteById((long) 9);
	    	books = repository.findByTitle("Twilight");
	    	assertThat(books).hasSize(0);
	    }
	    
}
