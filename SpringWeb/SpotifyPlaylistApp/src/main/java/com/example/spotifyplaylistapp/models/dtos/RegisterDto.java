package com.example.spotifyplaylistapp.models.dtos;

import com.example.spotifyplaylistapp.validation.MatchingFields;
import com.example.spotifyplaylistapp.validation.UniqueEmail;
import com.example.spotifyplaylistapp.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@MatchingFields(first = "password", second = "confirmPassword", message = "Password must be matching!")
public class RegisterDto {
    @UniqueUsername(message = "Username is taken!")
    @NotBlank(message = "Username length must be between 3 and 20 characters!")
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters!")
    private String username;
    @UniqueEmail(message = "Email is already registered!")
    @NotBlank(message = "Enter a valid email address!")
    @Email(message = "Enter a valid email address!")
    private String email;
    @NotBlank
    @Length(min = 3, max = 20)
    private String password;
    @NotBlank
    @Length(min = 3, max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
