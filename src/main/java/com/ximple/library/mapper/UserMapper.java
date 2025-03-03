package com.ximple.library.mapper;

import com.ximple.library.model.dto.UserDTO;
import com.ximple.library.model.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.ximple.library.utils.Constants.DTO_DATE_FORMAT;

@Mapper(componentModel = "spring", uses = {ReviewMapper.class, ReservationMapper.class})
public interface UserMapper {

    @Mapping(target = "active", source = "isActive")
    User toEntity(UserDTO userDTO);

    @Mapping(target = "isActive", source = "active")
    @Mapping(target = "createdAt", source = "createdAt", dateFormat = DTO_DATE_FORMAT)
    @Mapping(target = "updatedAt", source = "updatedAt", dateFormat = DTO_DATE_FORMAT)
    UserDTO toDTO(User user);
}
