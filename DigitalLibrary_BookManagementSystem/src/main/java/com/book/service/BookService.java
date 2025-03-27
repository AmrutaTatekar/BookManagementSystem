package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.BookEntity;

public interface BookService {

	// Method to perform CRUD operations

	// Method to Insert and Update the book data
	public String upsertBook(BookEntity bookEntity);

	// Method to get list of all books
	public List<BookEntity> viewAllBooks();

	// method to search a book by id
	public BookEntity searchBookById(Integer bookId);

	// Method to delete a book record
	public String deleteBook(Integer bookId);

}
