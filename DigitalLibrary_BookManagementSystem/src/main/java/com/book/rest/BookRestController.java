package com.book.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookEntity;
import com.book.service.BookService;

@RestController
public class BookRestController {

	@Autowired
	public BookService bookService;

	@PostMapping("/book")
	public ResponseEntity<String> addBook(@RequestBody BookEntity bookEntity) {
		String msg = bookService.upsertBook(bookEntity);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);

	}

	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBooks() {
		List<BookEntity> allBooks = bookService.viewAllBooks();
		return new ResponseEntity<>(allBooks, HttpStatus.OK);
	}

	@GetMapping("/books/{bookId}")
	public ResponseEntity<BookEntity> searchBook(@PathVariable Integer bookId) {
		BookEntity msg = bookService.searchBookById(bookId);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	@PutMapping("/book")
	public ResponseEntity<String> updatebook(@RequestBody BookEntity bookEntity) {
		String msg = bookService.upsertBook(bookEntity);
		return new ResponseEntity<>(msg, HttpStatus.CREATED);
	}

	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer bookId) {
		String msg = bookService.deleteBook(bookId);
		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

}
