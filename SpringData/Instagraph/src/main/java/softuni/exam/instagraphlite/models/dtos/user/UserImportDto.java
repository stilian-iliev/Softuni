package softuni.exam.instagraphlite.models.dtos.user;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class UserImportDto {
    @NotNull
    @Length(min = 2, max = 18)
    private String username;

    @NotNull
    @Length(min = 4)
    private String password;

    @NotNull
    private String profilePicture;

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }
}
