package xml.entities.category;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;


@XmlRootElement(name = "categories")
@XmlAccessorType(XmlAccessType.FIELD)
public class CategoryListImportDto {

    @XmlElement(name = "category")
    private List<CategoryImportDto> categories;

    public CategoryListImportDto() {}

    public List<CategoryImportDto> getCategories() {
        return categories;
    }
}
