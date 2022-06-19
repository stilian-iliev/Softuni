package bg.softuni.mobilele.repositories;


import bg.softuni.mobilele.models.Brand;
import bg.softuni.mobilele.models.dtos.BrandDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand, Long> {
    List<Brand> findAll();
}
