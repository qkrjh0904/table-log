package com.complete.tablelog.domain.book.repository;

import com.complete.tablelog.db.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
