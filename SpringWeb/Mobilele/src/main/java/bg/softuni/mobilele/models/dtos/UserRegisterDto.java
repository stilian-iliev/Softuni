package bg.softuni.mobilele.models.dtos;

import bg.softuni.mobilele.models.validation.MatchingFields;
import bg.softuni.mobilele.models.validation.UniqueUsername;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@MatchingFields(first = "password", second = "rePass", message="Password must be matching")
public class UserRegisterDto {
    @NotEmpty(message = "First name is required.")
    @Size(min = 2, max = 20, message = "First name must be between 2 and 20 characters.")
    private String firstName;

    @NotEmpty(message = "Last name is required.")
    @Size(min = 2, max = 20, message = "Last name must be between 2 and 20 characters.")
    private String lastName;

    @NotEmpty(message = "Username is required.")
    @Size(min = 2, max = 20, message = "Username must be between 2 and 20 characters.")
    @UniqueUsername(message = "Username is taken.")
    private String username;

    @NotEmpty(message = "Password is required.")
    @Size(min = 8, max = 32, message = "Password must be between 2 and 20 characters.")
    private String password;

    private String rePass;

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

    public String getRePass() {
        return rePass;
    }

    public void setRePass(String rePass) {
        this.rePass = rePass;
    }
}
