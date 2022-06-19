package xml.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoriesListDto {
    @XmlElement(name = "category")
    private List<CategoryStatsDto> categories;

    public CategoriesListDto() {
    }

    public CategoriesListDto(List<CategoryStatsDto> categories) {
        this.categories = categories;
    }

    public void setCategories(List<CategoryStatsDto> categories) {
        this.categories = categories;
    }
}
