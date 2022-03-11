package lt.vu.persistence;

import lt.vu.entities.Seller;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

@ApplicationScoped
public class SellerDAO {

    @Inject
    private EntityManager em;

    public List<Seller> getAll() {
        return em.createNamedQuery("Seller.getAll", Seller.class).getResultList();
    }

    public void persist(Seller seller){
        this.em.persist(seller);
    }

    public Seller findOne(Integer id){
        return em.find(Seller.class, id);
    }

    public Seller update(Seller seller){
        return em.merge(seller);
    }
}
