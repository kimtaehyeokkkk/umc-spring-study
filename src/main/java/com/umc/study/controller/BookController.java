package com.umc.study.controller;

import com.umc.study.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping
    public List<Map<String, Object>> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/category/{categoryId}")
    public List<Map<String, Object>> getBooksByCategory(@PathVariable Long categoryId) {
        return bookService.getBooksByCategory(categoryId);
    }

    @PostMapping
    public ResponseEntity<String> createBook(@RequestBody Map<String, Object> body) {
        Object categoryId = body.get("categoryId");
        Object title = body.get("title");

        if (categoryId == null || !(title instanceof String t) || t.isBlank()) {
            return ResponseEntity.badRequest().body("categoryId와 title은 필수입니다.");
        }

        bookService.createBook(body);
        return ResponseEntity.ok("도서 등록이 완료되었습니다!");
    }
}