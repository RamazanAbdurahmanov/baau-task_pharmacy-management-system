package az.baau.userservice.entity;

import az.baau.userservice.enums.Gender;
import az.baau.userservice.enums.UserRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private Gender gender;
    private LocalDate birthDate;
    private String username;
    private String password;
    private UserRole role;
}
