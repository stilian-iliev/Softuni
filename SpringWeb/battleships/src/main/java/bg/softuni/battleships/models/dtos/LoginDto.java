package bg.softuni.battleships.models.dtos;

import bg.softuni.battleships.validation.UniqueUsername;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class LoginDto {
    @Length(min = 3, max = 10)
    @NotBlank
    private String username;
    @Length(min = 3)
    @NotBlank
    private String password;

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
}
