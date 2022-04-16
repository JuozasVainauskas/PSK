package lt.vu.persistence;

import lt.vu.entities.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class ItemDAO implements IItemDAO {

    @Inject
    private EntityManager em;

    public List<Item> getAll() {
        return em.createNamedQuery("Item.getAll", Item.class).getResultList();
    }

    public void persist(Item item){
        this.em.persist(item);
    }

    public Item findOne(Integer id) {
        return em.find(Item.class, id);
    }

    public Item update(Item item){
        return em.merge(item);
    }

    public void delete(Item item) {
        this.em.remove(item); }
}
