package exam.model.customer;

import exam.model.town.TownNameDto;

public class CustomerImportDto {
    private String firstName;
    private String lastName;
    private String email;
    private String registeredOn;
    private TownNameDto town;


    public CustomerImportDto(String firstName, String lastName, String email, String registeredOn, TownNameDto town) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.registeredOn = registeredOn;
        this.town = town;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getRegisteredOn() {
        return registeredOn;
    }

    public TownNameDto getTown() {
        return town;
    }

    public boolean validate() {
        if (getFirstName().length() < 2) return false;
        if (getLastName().length() < 2) return false;
        if (!getEmail().contains("@") || !getEmail().contains(".")) return false;
        return true;
    }
}
