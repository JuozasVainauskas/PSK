package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Seller;
import lt.vu.persistence.SellerDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.transaction.Transactional;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Sellers implements Serializable {
    @Inject
    private SellerDAO sellerDAO;

    @Getter
    private List<Seller> allSellers;

    @Getter @Setter
    private Seller sellerToCreate = new Seller();

    @PostConstruct
    public void init(){
        loadAllSellers();
    }

    private void loadAllSellers(){
        this.allSellers = sellerDAO.getAll();
    }

    @Transactional
    public void createSeller() {
        sellerDAO.persist(sellerToCreate);
    }
}
