package br.com.curse.webflux.mapper;

import br.com.curse.webflux.entity.User;
import br.com.curse.webflux.model.request.UserRequest;
import br.com.curse.webflux.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueCheckStrategy.*;
import static org.mapstruct.NullValuePropertyMappingStrategy.*;

@Mapper(
        componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE,
        nullValueCheckStrategy = ALWAYS
)
public interface UserMapper {

    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request);

    UserResponse toResponse(final User entity);
}
