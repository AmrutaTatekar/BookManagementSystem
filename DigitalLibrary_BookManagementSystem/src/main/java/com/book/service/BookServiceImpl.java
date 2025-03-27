package com.book.service;

import java.util.List;
import java.util.Optional;

import com.book.entity.BookEntity;

public class BookServiceImpl implements BookService {

	@Override
	public String upsertBook(BookEntity bookEntity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookEntity> viewAllBooks() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<BookEntity> searchBookByTitle(Integer bookId) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public String deleteBook(Integer bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}
