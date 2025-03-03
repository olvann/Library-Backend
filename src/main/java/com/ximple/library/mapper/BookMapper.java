package com.ximple.library.mapper;

import com.ximple.library.model.dto.BookDTO;
import com.ximple.library.model.entity.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class, ReservationMapper.class})
public interface BookMapper {

    BookDTO toDTO(Book book);
    Book toEntity(BookDTO bookDTO);
}
