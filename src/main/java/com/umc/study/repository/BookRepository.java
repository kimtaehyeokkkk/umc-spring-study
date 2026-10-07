package com.umc.study.repository;

import com.umc.study.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 전체 도서 최신 등록순
    List<Book> findAllByOrderByBookIdDesc();

    // 3주차 GET /books/category/{categoryId} 유지용
    List<Book> findAllByCategory_CategoryIdOrderByBookIdDesc(Long categoryId);
}