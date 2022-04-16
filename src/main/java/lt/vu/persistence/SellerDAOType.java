package lt.vu.persistence;

import lt.vu.entities.Item;
import lt.vu.entities.Seller;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Specializes;
import java.util.List;

@Specializes
@ApplicationScoped
public class SellerDAOType extends SellerDAO {
    @PostConstruct
    private void LogItemSeller(Seller seller) {
        System.out.println("Seller's " +seller.getName() + " last item is: " + seller.getItems().get(seller.getItems().size() - 1).getName());
    }

    @Override
    public Seller findOne(Integer id){
        Seller seller = super.findOne(id);
        LogItemSeller(seller);
        return seller;
    }
}