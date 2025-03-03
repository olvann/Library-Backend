package com.ximple.library.model.entity;

import com.ximple.library.enums.BookStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String genre;

    private String barcode;

    @Column(name="published_year")
    private Integer publishedYear;

    @Enumerated(EnumType.STRING)
    private BookStatus status;

    @Column(name="created_by")
    private Long createdBy;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="updated_by")
    private Long updatedBy;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "book", fetch = FetchType.LAZY)
    private List<Reservation> reservationList;
}
