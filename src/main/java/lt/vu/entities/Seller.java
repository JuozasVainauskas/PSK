package lt.vu.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Seller.getAll", query = "select s from Seller as s")
})
@Table(name = "SELLER")
@Getter
@Setter
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "seller")
    private List<Item> items = new ArrayList<>();

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
