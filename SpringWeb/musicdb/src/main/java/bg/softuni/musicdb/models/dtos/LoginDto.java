package bg.softuni.musicdb.models.dtos;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

public class LoginDto {
    @NotBlank
    @Length(min = 5, max = 20)
    private String username;
    @NotBlank
    @Length(min = 5, max = 20)
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
