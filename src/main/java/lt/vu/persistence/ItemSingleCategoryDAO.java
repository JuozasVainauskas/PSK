package lt.vu.persistence;

import lt.vu.entities.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import java.util.ArrayList;
import java.util.List;

@Alternative
@ApplicationScoped
public class ItemSingleCategoryDAO extends ItemDAO implements IItemDAO {

    @Override
    public List<Item> getAll() {
        List<Item> itemsWithMultipleCategories = new ArrayList<>();
        for(Item item : super.getAll())
            if(item.getCategories().size() <= 1)
                itemsWithMultipleCategories.add(item);
        return itemsWithMultipleCategories;
    }
}
