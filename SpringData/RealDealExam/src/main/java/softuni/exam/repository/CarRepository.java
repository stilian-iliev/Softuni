package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Car;
import softuni.exam.models.dtos.car.ExportByPicCountDto;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Optional<Car> findByMakeAndModelAndKilometers(String make, String model, int kilometers);

    @Query("select new softuni.exam.models.dtos.car.ExportByPicCountDto(c.make, c.model, c.kilometers, c.registeredOn, count(p)) from Picture p join p.car c group by c order by count(p) desc, c.make")
    List<ExportByPicCountDto> findAllByPicCount();
}
