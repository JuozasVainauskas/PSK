package lt.vu.persistence;

import lt.vu.entities.Category;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class CategoryDAO {

    @Inject
    private EntityManager em;

    public List<Category> getAll() {
        return em.createNamedQuery("Category.getAll", Category.class).getResultList();
    }

    public void persist(Category category){
        this.em.persist(category);
    }

    public Category findOne(Integer id){
        return em.find(Category.class, id);
    }

    public Category update(Category category){
        return em.merge(category);
    }
}
