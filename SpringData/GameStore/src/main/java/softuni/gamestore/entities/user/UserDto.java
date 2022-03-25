package softuni.gamestore.entities.user;

import softuni.gamestore.exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserDto {
    private String email;

    private String password;

    private String fullName;

    public UserDto() {
    }

    public UserDto(String[] tokens) {
        setEmail(tokens[1]);
        setPassword(tokens[2], tokens[3]);
        setFullName(tokens[4]);
    }

    public void setEmail(String email){
        if (!email.contains("@") || !email.contains(".")){
            throw new ValidationException("Email must contain @ and .");
        }
        this.email = email;
    }

    public void setPassword(String password, String repass) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).+$");
        Matcher m = pattern.matcher(password);
        if (!m.matches()){
            throw new ValidationException("Password must contain at least 1 uppercase, 1 lowercase letter and 1 digit.");
        }
        if (!password.equals(repass)) {
            throw new ValidationException("Passwords don't match");
        }

        this.password = password;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullName() {
        return fullName;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
