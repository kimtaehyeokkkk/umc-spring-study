package com.umc.study.repository;

import com.umc.study.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    // 카테고리를 JOIN으로 함께 조회해 N+1 방지
    @EntityGraph(attributePaths = "category")
    List<Book> findAllByOrderByBookIdDesc();

    // 3주차 GET /books/category/{categoryId} 유지용
    @EntityGraph(attributePaths = "category")
    List<Book> findAllByCategory_CategoryIdOrderByBookIdDesc(Long categoryId);

    // 선택 심화: 제목에 keyword가 포함된 도서 검색 (LIKE '%keyword%')
    @EntityGraph(attributePaths = "category")
    List<Book> findByTitleContainingOrderByBookIdDesc(String keyword);
}