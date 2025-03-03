package com.ximple.library.repository.specifications;

import com.ximple.library.enums.BookStatus;
import com.ximple.library.model.entity.Book;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class BookSpecifications {
    public static Specification<Book> filterByTitle(String title) {
        return (root, query, criteriaBuilder) ->
                title == null ? null : criteriaBuilder
                        .like(criteriaBuilder.lower(root.get("title")), "%" + title.toLowerCase() + "%");
    }

    public static Specification<Book> filterByAuthor(String author) {
        return (root, query, criteriaBuilder) ->
                author == null ? null : criteriaBuilder
                        .like(criteriaBuilder.lower(root.get("author")), "%" + author.toLowerCase() + "%");
    }

    public static Specification<Book> filterByGenre(String genre) {
        return (root, query, criteriaBuilder) ->
                genre == null ? null : criteriaBuilder
                        .equal(root.get("genre"), genre);
    }

    public static Specification<Book> filterByPublishedYear(Integer year) {
        return (root, query, criteriaBuilder) ->
                year == null ? null : criteriaBuilder
                        .equal(root.get("publishedYear"), year);
    }

    public static Specification<Book> filterByRating(Integer rating) {
        return (root, query, criteriaBuilder) ->
                rating == null ? null : criteriaBuilder
                        .equal(root.get("rating"), rating);
    }

    public static Specification<Book> filterByStatus(BookStatus status) {
        return (root, query, criteriaBuilder) ->
                status == null ? null : criteriaBuilder
                        .equal(root.get("status"), status);
    }
}
