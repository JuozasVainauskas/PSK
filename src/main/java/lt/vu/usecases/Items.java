package lt.vu.usecases;

import lombok.Getter;
import lt.vu.entities.Item;
import lt.vu.persistence.ItemDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.List;

@Model
public class Items implements Serializable {
    @Inject
    private ItemDAO itemDAO;

    @Getter
    private List<Item> allItems;

    @PostConstruct
    public void init(){
        loadAllSellers();
    }

    private void loadAllSellers(){
        this.allItems = itemDAO.getAll();
    }
}
