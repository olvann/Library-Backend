package com.ximple.library.service;

import com.ximple.library.model.dto.BookDTO;
import com.ximple.library.model.dto.BookSearchDTO;
import com.ximple.library.model.entity.Book;

import java.util.List;

public interface BookService {
    List<BookDTO> searchBookList(BookSearchDTO bookSearchDTO, Boolean includeReviews);
    List<BookDTO> getBookList(Boolean includeReviews);
    BookDTO getBookDTOById(Long bookId);
    Book getBookById(Long bookId);
    BookDTO addOrUpdateBook(Book book);
}
