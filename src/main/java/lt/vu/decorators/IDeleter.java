package lt.vu.decorators;

import lt.vu.entities.Item;

public interface IDeleter {
    Item deleteById(int id);
}
