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
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter @Setter
public class ItemDetails implements Serializable {

    private Item item;

    @Inject
    private ItemDAO itemDAO;

    @PostConstruct
    private void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer itemId = Integer.parseInt(requestParameters.get("itemId"));
        this.item = itemDAO.findOne(itemId);
    }
}
