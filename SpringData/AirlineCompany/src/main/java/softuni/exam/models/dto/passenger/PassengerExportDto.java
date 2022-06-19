package softuni.exam.models.dto.passenger;

public class PassengerExportDto {
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private int numberOfTickets;

    public PassengerExportDto(String firstName, String lastName, String email, String phoneNumber, int numberOfTickets) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.numberOfTickets = numberOfTickets;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getNumberOfTickets() {
        return numberOfTickets;
    }

    @Override
    public String toString() {
        return String.format("Passenger %s  %s\n" +
                "\tEmail - %s\n" +
                "\tPhone - %s\n" +
                "\tNumber of tickets - %d", getFirstName(), getLastName(), getEmail(), getPhoneNumber(), getNumberOfTickets());
    }
}
