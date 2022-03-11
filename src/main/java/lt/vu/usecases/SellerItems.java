package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Item;
import lt.vu.entities.Seller;
import lt.vu.persistence.ItemDAO;
import lt.vu.persistence.SellerDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@Model
public class SellerItems implements Serializable {

    @Inject
    private SellerDAO sellerDAO;

    @Inject
    private ItemDAO itemDAO;

    @Getter
    @Setter
    private Seller seller;

    @Getter @Setter
    private Item itemToCreate = new Item();

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer sellerId = Integer.parseInt(requestParameters.get("sellerId"));
        this.seller = sellerDAO.findOne(sellerId);
    }

    @Transactional
    public void createItem() {
        itemToCreate.setSeller(this.seller);
        itemDAO.persist(itemToCreate);
    }
}
