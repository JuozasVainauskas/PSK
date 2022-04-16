package lt.vu.decorators;
import lt.vu.entities.Item;

import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

@Decorator
public class ItemDeleterDecorator implements IDeleter {
    @Inject
    @Delegate
    @Any
    IDeleter itemDeleter;

    public Item deleteById(int id) {
        Item item = itemDeleter.deleteById(id);
        if (item != null)
            System.out.println("Deleted an item from the database.\nID: " + item.getId() +
                    "\nName:" + item.getName() +
                    "\nCategories" + item.getCategories() +
                    "\nSeller" + item.getSeller().getName());
        return item;
    }
}
