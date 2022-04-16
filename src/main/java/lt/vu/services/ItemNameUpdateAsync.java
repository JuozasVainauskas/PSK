package lt.vu.services;

import lt.vu.entities.Item;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.OptimisticLockException;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@ApplicationScoped
public class ItemNameUpdateAsync {
    @PersistenceContext
    private EntityManager em;

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public String update(Integer id, String name, int preWait, int postWait) {
        try {
            Thread.sleep(preWait);
            Item item = em.find(Item.class, id);
            Thread.sleep(postWait);
            item.setName(name);
            em.flush();
        }
        catch (OptimisticLockException e) {
            System.out.println("OptimisticLockException");
            return "OptimisticLockException";
        } catch (InterruptedException ignored) {
            System.out.println("INTERRUPTED");
        }
        return "Updated";
    }
}
