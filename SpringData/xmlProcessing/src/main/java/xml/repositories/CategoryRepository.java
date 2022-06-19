package xml.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import xml.entities.category.Category;
import xml.entities.category.CategoryStatsDto;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
//    @Query("select new xml.entities.category.CategoryStatsDto(c.name, count(p), avg(p.price), sum(p.price)) from Category c join c.products p order by count(p) desc")
    @Query("select new xml.entities.category.CategoryStatsDto(c.name, count(p), avg(p.price), sum(p.price)) from Product p join p.categories c group by c.name order by count(p) desc")
    List<CategoryStatsDto> findAllCategoryStatsOrderByProductCount();
}
