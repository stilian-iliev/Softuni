package softuni.exam.models.dto.passenger;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.Positive;

public class PassengerImportDto {
    @Length(min = 2)
    private String firstName;

    @Length(min = 2)
    private String lastName;

    @Positive
    private int age;

    private String phoneNumber;

    @Email
    private String email;

    private String town;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getTown() {
        return town;
    }
}
