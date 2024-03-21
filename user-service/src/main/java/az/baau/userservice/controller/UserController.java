package az.baau.userservice.controller;

import az.baau.userservice.dto.UserDTO;
import az.baau.userservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<UserDTO> registerNewCustomer(@RequestBody UserDTO userDTO) {
        return new ResponseEntity<>(userService.registerNewUser(userDTO), HttpStatus.OK);

    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getOneUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.getUserById(id), HttpStatus.OK);
    }

    @PutMapping("/id")
    public ResponseEntity<UserDTO> updateUserById(@PathVariable Long id, @RequestBody UserDTO updatedUser) {
        return new ResponseEntity<>(userService.updateUserById(id, updatedUser), HttpStatus.OK);
    }

    public ResponseEntity<String> deleteUserById(@PathVariable Long id) {
        userService.deleteUserById(id);
        return new ResponseEntity<>("Successfully Deleted", HttpStatus.OK);
    }
}
