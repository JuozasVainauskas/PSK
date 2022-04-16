package lt.vu.decorators;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Item;
import lt.vu.services.ItemService;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.io.Serializable;

@RequestScoped
public class ItemDeleter implements IDeleter, Serializable {
    @Inject
    @Setter
    @Getter
    private ItemService itemService;

    public Item deleteById(int id) {
        return itemService.delete(id);
    }
}
