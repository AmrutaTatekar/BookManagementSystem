package com.book.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.book.entity.BookEntity;
import com.book.service.BookService;

@RestController
public class BookRestController {
	
	@Autowired
	public BookService bookService;
	
	@PostMapping("/book")
	public ResponseEntity<String> upsertBook(@RequestBody BookEntity bookEntity){
		String msg = bookService.upsertBook(bookEntity);
		return new ResponseEntity<>(msg,HttpStatus.CREATED);
		
	}

}
