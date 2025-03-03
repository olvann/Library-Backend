package com.ximple.library.service.impl;

import com.ximple.library.exception.NotFoundException;
import com.ximple.library.mapper.BookMapper;
import com.ximple.library.model.dto.BookDTO;
import com.ximple.library.model.dto.BookSearchDTO;
import com.ximple.library.model.entity.Book;
import com.ximple.library.repository.BookRepository;
import com.ximple.library.repository.specifications.BookSpecifications;
import com.ximple.library.service.BookService;
import com.ximple.library.utils.MessageBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    @Override
    public List<BookDTO> searchBookList(BookSearchDTO bookSearchDTO, Boolean includeReviews) {
        return processReviews(bookRepository.findAll(
                Specification.where(BookSpecifications.filterByTitle(bookSearchDTO.title())
                        .and(BookSpecifications.filterByAuthor(bookSearchDTO.author()))
                        .and(BookSpecifications.filterByGenre(bookSearchDTO.genre()))
                        .and(BookSpecifications.filterByStatus(bookSearchDTO.status()))
                        .and(BookSpecifications.filterByPublishedYear(bookSearchDTO.publishedYear())))),
                includeReviews
        )
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public List<BookDTO> getBookList(Boolean includeReviews) {
        return processReviews(bookRepository.findAll(), includeReviews)
                .stream()
                .map(bookMapper::toDTO)
                .toList();
    }

    @Override
    public BookDTO getBookDTOById(Long bookId) {
        return bookRepository.findById(bookId)
                .map(bookMapper::toDTO)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.bookNotFound(bookId)));
    }

    @Override
    public Book getBookById(Long bookId) {
        return bookRepository.findById(bookId)
                .orElseThrow(() -> new NotFoundException(MessageBuilder.bookNotFound(bookId)));
    }

    @Override
    public BookDTO addOrUpdateBook(Book book) {
        return bookMapper.toDTO(bookRepository.save(book));
    }

    private List<Book> processReviews(List<Book> bookList, Boolean includeReviews) {
        if (!Boolean.TRUE.equals(includeReviews)) {
            bookList.parallelStream()
                    .forEach(book -> book.setReviewList(List.of()));
        }
        return bookList;
    }
}
