package bg.softuni.musicdb.models.dtos;

import bg.softuni.musicdb.validation.MatchingFields;
import bg.softuni.musicdb.validation.UniqueEmail;
import bg.softuni.musicdb.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@MatchingFields(first = "password", second = "confirmPassword")
public class UserRegisterDto {
    @NotNull
    @UniqueUsername
    @Length(min = 3, max = 20)
    private String username;
    @NotNull
    @Length(min = 3, max = 20)
    private String fullName;
    @NotBlank
    @Email
    @UniqueEmail
    private String email;
    @NotNull
    @Length(min = 5, max = 20)
    private String password;
    @NotNull
    @Length(min = 5, max = 20)
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
