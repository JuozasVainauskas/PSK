package lt.vu.rest.contracts;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Seller;

@Getter
@Setter

public class SellerDto {
    private Integer id;
    private String name;

    public SellerDto() {}

    public SellerDto(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public SellerDto(Seller seller) {
        this.id = seller.getId();
        this.name = seller.getName();
    }
}
