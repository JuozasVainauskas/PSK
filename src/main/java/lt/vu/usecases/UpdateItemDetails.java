package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Item;
import lt.vu.persistence.ItemDAO;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.OptimisticLockException;
import javax.transaction.Transactional;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class UpdateItemDetails implements Serializable {

    private Item item;

    @Inject
    private ItemDAO itemDAO;

    @PostConstruct
    private void init() {
        System.out.println("UpdateItemDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer itemId = Integer.parseInt(requestParameters.get("itemId"));
        this.item = itemDAO.findOne(itemId);
    }

    @Transactional
    public String updateItem() {
        try{
            itemDAO.update(this.item);
        } catch (OptimisticLockException e) {
            return "/itemDetails.xhtml?faces-redirect=true&itemId=" + this.item.getId() + "&error=optimistic-lock-exception";
        }
        return "itemDetails.xhtml?itemId=" + this.item.getId() + "&faces-redirect=true";
    }
}
