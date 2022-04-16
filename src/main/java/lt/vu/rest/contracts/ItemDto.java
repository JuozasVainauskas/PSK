package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Category;
import lt.vu.entities.Item;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

public class ItemDto {
    private Integer id;
    private String name;
    private SellerDto seller;
    private List<CategoryDto> categories;

    public ItemDto(){}

    public ItemDto(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.seller = new SellerDto(item.getSeller());
        this.categories = new ArrayList<>();
        for (Category category : item.getCategories()) {
            this.categories.add(new CategoryDto(category));
        }
    }
}
