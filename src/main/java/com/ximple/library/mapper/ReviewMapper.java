package com.ximple.library.mapper;

import com.ximple.library.model.dto.ReviewDTO;
import com.ximple.library.model.entity.Review;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.ximple.library.utils.Constants.DTO_DATE_FORMAT;

@Mapper(componentModel = "spring")
public interface ReviewMapper {

    @Mapping(source = "bookId", target = "book.id")
    @Mapping(source = "userId", target = "user.id")
    Review toEntity(ReviewDTO dto);

    @Mapping(source = "book.id", target = "bookId")
    @Mapping(source = "user.id", target = "userId")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = DTO_DATE_FORMAT)
    ReviewDTO toDTO(Review review);

}
