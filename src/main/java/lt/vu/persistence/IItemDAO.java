package lt.vu.persistence;

import lt.vu.entities.Item;

import java.util.List;

public interface IItemDAO {
    void persist(Item item);
    Item findOne(Integer id);
    Item update(Item post);
    List<Item> getAll();
}
