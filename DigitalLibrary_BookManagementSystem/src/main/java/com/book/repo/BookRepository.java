package com.book.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.book.entity.BookEntity;

public interface BookRepository extends JpaRepository<BookEntity,Integer>{

}
