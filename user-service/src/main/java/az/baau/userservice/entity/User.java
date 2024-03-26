package az.baau.userservice.entity;

import az.baau.userservice.enums.Gender;
import az.baau.userservice.enums.UserRole;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty(message="Boş qoymaq olmaz")
    @Size(min=2, message="Minimum 2 simvol yazila biler")
    @Size(max=30, message="maksimum 30 simvol yazila biler")
    private String name;
    @NotEmpty(message="Boş qoymaq olmaz")
    @Size(min=2, message="Minimum 2 simvol yazila biler")
    @Size(max=30, message="maksimum 30 simvol yazila biler")
    private String surname;
    private Gender gender;
    private LocalDate birthDate;
    @Column(nullable = false,unique = true)
    private String username;
    private String password;
    private UserRole role;


    public User(Long id, String name, String surname, Gender gender, LocalDate birthDate, String username, String password, UserRole role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthDate = birthDate;
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
