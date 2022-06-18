package bg.softuni.battleships.models.dtos;

import bg.softuni.battleships.validation.MatchingFields;
import bg.softuni.battleships.validation.UniqueEmail;
import bg.softuni.battleships.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MatchingFields(first = "password", second = "confirmPassword", message = "Passwords are not matching.")
public class UserRegisterDto {

    @Length(min = 3, max = 10)
    @NotBlank
    @UniqueUsername
    private String username;
    @Length(min = 5, max = 20)
    @NotBlank
    private String fullName;
    @Email
    @NotBlank
    @UniqueEmail
    private String email;
    @Length(min = 3)
    @NotBlank
    private String password;
    @NotBlank
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
