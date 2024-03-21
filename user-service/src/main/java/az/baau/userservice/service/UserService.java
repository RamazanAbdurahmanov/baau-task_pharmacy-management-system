package az.baau.userservice.service;

import az.baau.userservice.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO registerNewUser(UserDTO userDTO);
    List<UserDTO> getAllUsers();
    UserDTO getUserById(Long id);
    UserDTO updateUserById(Long id,UserDTO userDTO);
    void deleteUserById(Long id);

}
