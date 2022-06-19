package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Passenger;

import java.util.List;
import java.util.Optional;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Optional<Passenger> findByEmail(String email);

//    @Query("select softuni.exam.models.dto.passenger.PassengerExportDto(p.firstName, p.lastName, p.email, p.phoneNumber, count(t)) from Passenger p join p.tickets t order by count(t) desc, p.email")
//    List<PassengerExportDto> findAllPassengersByTicketCount();

    @Query("select p from Passenger p join p.tickets t group by p.id order by count(t) desc, p.email")
    List<Passenger> findAllPassengersByTicketCount();
}
