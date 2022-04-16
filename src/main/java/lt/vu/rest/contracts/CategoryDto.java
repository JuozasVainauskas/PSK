package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Category;

@Getter
@Setter

public class CategoryDto {
    private Integer id;
    private String name;

    public CategoryDto(){}

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.name = category.getName();
    }
}
