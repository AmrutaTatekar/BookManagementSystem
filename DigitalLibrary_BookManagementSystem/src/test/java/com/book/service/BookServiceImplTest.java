package com.book.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.book.entity.BookEntity;
import com.book.repo.BookRepository;

public class BookServiceImplTest {

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookServiceImpl bookService;

	private BookEntity book;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
		book = new BookEntity();
		book.setBookId(1);
		book.setAuthor("John Doe");
		book.setGenre("Programming");
		book.setAvailabilityStatus("Available");
	}

	// Test for inserting a new book
	@Test
	void testUpsertBook_InsertNewRecord() {
		book.setBookId(null); // New record scenario
		when(bookRepository.save(book)).thenReturn(book);

		String result = bookService.upsertBook(book);

		assertEquals("Record Inserted", result);
		verify(bookRepository, times(1)).save(book);
	}

}
