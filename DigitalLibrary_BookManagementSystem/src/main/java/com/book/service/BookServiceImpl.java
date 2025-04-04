package com.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.book.entity.BookEntity;
import com.book.repo.BookRepository;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	public BookRepository bookRepository;

	@Override
	public String upsertBook(BookEntity bookEntity) {
		Integer bookId = bookEntity.getBookId();
		System.out.println(bookEntity);

		bookRepository.save(bookEntity);
		System.out.println(bookEntity);

		if (bookId == null)
			return "Record Inserted";
		else
			return "Record Updated";
	}

	@Override
	public List<BookEntity> viewAllBooks() {
		List<BookEntity> bookList = bookRepository.findAll();
		return bookList;

	}

	@Override
	public BookEntity searchBookById(Integer bookId) {
		Optional<BookEntity> optional = bookRepository.findById(bookId);
		if (optional.isPresent()) {
			BookEntity bookEntity = optional.get();
			return bookEntity;
		}
		return null;
	}

	@Override
	public String deleteBook(Integer bookId) {
		bookRepository.deleteById(bookId);
		String msg = "Record Deleted";
		return msg;

	}

}
