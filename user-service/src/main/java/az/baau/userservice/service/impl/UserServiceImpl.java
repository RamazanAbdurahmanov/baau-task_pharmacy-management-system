package az.baau.userservice.service.impl;

import az.baau.userservice.dto.UserDTO;
import az.baau.userservice.entity.User;
import az.baau.userservice.enums.UserRole;
import az.baau.userservice.exception.UserNotFoundException;
import az.baau.userservice.mapper.UserMapper;
import az.baau.userservice.repository.UserRepository;
import az.baau.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private  UserRepository userRepository;
    @Autowired
    private  PasswordEncoder passwordEncoder;


    public UserServiceImpl() {

    }


    @Override
    public UserDTO registerNewUser(UserDTO userDTO) {
        User user= UserMapper.INSTANCE.userDtoToUser(userDTO);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole(UserRole.CUSTOMER);
        userRepository.save(user);
        return UserMapper.INSTANCE.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users=userRepository.findAll();
        if(users.isEmpty()==false){
            List<UserDTO> userDTOS= new ArrayList<>();
            for (User user:users){
                userDTOS.add(UserMapper.INSTANCE.userToUserDTO(user));
            }
            return userDTOS;
        }
        else {
            throw new UserNotFoundException("Users Not Fund");
        }


    }

    @Override
    public UserDTO getUserById(Long id) {
        Optional<User> user=userRepository.findById(id);
        if(user.isPresent()){
            return UserMapper.INSTANCE.userToUserDTO(user.get());
        }
        throw new UserNotFoundException("User Not Found : Id ->"+id);
    }

    @Override
    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){
            User foundUser=user.get();
            foundUser.setName(userDTO.getName());
            foundUser.setSurname(userDTO.getSurname());
            foundUser.setGender(userDTO.getGender());
            foundUser.setBirthDate(userDTO.getBirthDate());
            foundUser.setUsername(userDTO.getUsername());
            foundUser.setPassword(userDTO.getPassword());
            userRepository.save(foundUser);
            return UserMapper.INSTANCE.userToUserDTO(foundUser);
        }
        else {
            throw new UserNotFoundException("User Not found Id: "+id);
        }
    }

    @Override
    public void deleteUserById(Long id) {
        Optional<User> deletedUser=userRepository.findById(id);
        if (deletedUser.isPresent()){
            userRepository.deleteById(id);
        }
        else {
            throw new UserNotFoundException("User not found Id: "+id);
        }

    }
    public User findByUsername(String username) {
        return  userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return org.springframework.security.core.userdetails.User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getRole().toString())
                .build();
    }


}
