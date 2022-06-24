package bg.softuni.coffeeshop.models.dtos;

import bg.softuni.coffeeshop.validation.MatchingFields;
import bg.softuni.coffeeshop.validation.UniqueEmail;
import bg.softuni.coffeeshop.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MatchingFields(first = "password", second = "confirmPassword", message = "Passwords must be matching.")
public class UserRegisterDto {
    @UniqueUsername(message = "Username is already taken.")
    @NotBlank(message = "Username length must be between 5 and 20 characters.")
    @Length(min = 5, max = 20, message = "Username length must be between 5 and 20 characters.")
    private String username;

    private String firstName;
    @NotBlank(message = "Last name length must be between 5 and 20 characters.")
    @Length(min = 5, max = 20, message = "Last name length must be between 5 and 20 characters.")
    private String lastName;
    @UniqueEmail(message = "Email is already registered.")
    @NotBlank(message = "Enter valid email address.")
    @Email(message = "Enter valid email address.")
    @Length(min = 5, max = 20, message = "Enter valid email address.")
    private String email;
    @NotBlank(message = "Password length must be more than 3 characters.")
    @Length(min = 3, message = "Password length must be more than 3 characters.")
    private String password;
    @NotBlank(message = "Password length must be more than 3 characters.")
    @Length(min = 3, message = "Password length must be more than 3 characters.")
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
