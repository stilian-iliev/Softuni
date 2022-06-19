package xml.processing.productshop.repositories;

import xml.processing.productshop.entities.category.Category;
import xml.processing.productshop.entities.category.CategoryStatisticsDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
    @Query("select new json.processing.productshop.entities.category.CategoryStatisticsDto(c.name, count(p), avg(p.price), sum(p.price)) from Product p join p.categories c group by c.name order by count(p) desc")
    List<CategoryStatisticsDto> findAllCategoryStatistics();
}
