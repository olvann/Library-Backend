package com.ximple.library.controller;

import com.ximple.library.model.dto.BookDTO;
import com.ximple.library.model.dto.BookSearchDTO;
import com.ximple.library.model.dto.ResponseDTO;
import com.ximple.library.service.BookService;
import com.ximple.library.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.ximple.library.utils.ResponseUtils.buildOkResponse;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<ResponseDTO<List<BookDTO>>> getBookList(
            @RequestParam(name = "includeReviews", defaultValue = "FALSE") Boolean includeReviews) {
        var bookList = bookService.getBookList(includeReviews);

        return buildOkResponse(MessageBuilder.booksRetrieved(bookList), bookList);
    }

    @PostMapping(value = "/search")
    public ResponseEntity<ResponseDTO<List<BookDTO>>> searchBookList(
            @RequestBody BookSearchDTO bookSearchDTO,
            @RequestParam(name = "includeReviews", required = false) Boolean includeReviews) {
        var bookList = bookService.searchBookList(bookSearchDTO, includeReviews);

        return buildOkResponse(MessageBuilder.booksRetrievedWithFilter(bookList, bookSearchDTO),
                bookList);
    }
}
