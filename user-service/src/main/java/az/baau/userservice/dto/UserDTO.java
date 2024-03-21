package az.baau.userservice.dto;

import az.baau.userservice.enums.Gender;
import az.baau.userservice.enums.UserRole;
import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthDate;
    private String username;
    private String password;
    private UserRole role;
}

