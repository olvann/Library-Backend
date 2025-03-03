package com.ximple.library.model.entity;

import com.ximple.library.enums.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="created_by")
    private Long createdBy;

    @CreationTimestamp
    @Column(name="created_at")
    private Date createdAt;

    @Column(name="updated_at")
    private Date updatedAt;

    @Column(name="updated_by")
    private Long updatedBy;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Review> reviewList;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Reservation> reservationList;
}
