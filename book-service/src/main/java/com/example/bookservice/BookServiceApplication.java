package com.example.bookservice;

import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class BookServiceApplication implements CommandLineRunner {

	private final BookRepository bookRepository;

	public BookServiceApplication(BookRepository bookRepository){
		this.bookRepository=bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Dünyanın Gözü", "2000", "Robert Jordan", "İthaki Yayınevi", "123456");
		Book book2 = new Book("Yüzüklerin Efendisi", "1960", "J.R.R Tolkien", "Metis Yayıncılık", "456789");
		Book book3 = new Book("Harry Potter ve Felsefe Taşı", "1997", "J. K. Rowling", "YKB Yayınları", "987654");

		List<Book> bookList = bookRepository.saveAll(Arrays.asList(book1, book2, book3));
		// Eklenen kitapları konsola yazdırma (burayı ekledik)
		System.out.println("Veritabanına eklenen kitaplar:");
		bookList.forEach(book -> System.out.println(book.getTitle() + " - " + book.getAuthor()));

	}
}
