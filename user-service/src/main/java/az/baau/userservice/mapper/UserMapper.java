package az.baau.userservice.mapper;

import az.baau.userservice.dto.UserDTO;
import az.baau.userservice.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);

    User userDtoToUser(UserDTO userDTO);

}
