package lt.vu.services;

import lt.vu.entities.Category;
import lt.vu.entities.Item;
import lt.vu.entities.Seller;
import lt.vu.persistence.CategoryDAO;
import lt.vu.persistence.ItemDAO;
import lt.vu.persistence.SellerDAO;
import lt.vu.rest.contracts.CategoryDto;
import lt.vu.rest.contracts.ItemDto;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class ItemService {
    @Inject
    ItemDAO itemDAO;
    @Inject
    SellerDAO sellerDAO;
    @Inject
    CategoryDAO categoryDAO;

    @Inject
    private EntityManager em;

    public List<Item> getAll() {
        return itemDAO.getAll();
    }

    public Item get(int id) throws NotFoundException {
        Item item = itemDAO.findOne(id);
        if (item == null) {
            throw new NotFoundException("Item with Id " + id + " was not found");
        }
        return item;
    }

    public Item createFrom(ItemDto itemDto) {
        validate(itemDto);
        Item item = new Item();
        item.setName(itemDto.getName());
        item.setSeller(getSellerFrom(itemDto));
        item.setCategories(getCategoriesFrom(itemDto));
        itemDAO.persist(item);
        return item;
    }

    public Item updateFrom(ItemDto itemDto, int id) {
        validate(itemDto);
        Item item = get(id);
        item.setName(itemDto.getName());
        item.setSeller(getSellerFrom(itemDto));
        item.setCategories(getCategoriesFrom(itemDto));
        itemDAO.update(item);
        return item;
    }

    public Item updateFromOptimistic(ItemDto itemDto, int id) throws InterruptedException {
        validate(itemDto);
        Item item = get(id);
        Thread.sleep(7000);
//        em.refresh(item);
        item.setName(itemDto.getName());
        item.setSeller(getSellerFrom(itemDto));
        item.setCategories(getCategoriesFrom(itemDto));
        em.flush();
        return item;
    }

    public Item delete(int id) {
        Item item = get(id);
        itemDAO.delete(item);
        return item;
    }

    private void validate(ItemDto itemDto) {
        if(itemDto.getName() == null)
            throw new BadRequestException("Item must have a name");
        if(itemDto.getSeller() == null)
            throw new BadRequestException("Item must have a seller");
    }

    private Seller getSellerFrom(ItemDto itemDto) {
        Seller seller = sellerDAO.findOne(itemDto.getSeller().getId());
        if(seller == null)
            throw new NotFoundException("Seller with Id " + itemDto.getId() + " was not found");
        return seller;
    }

    private List<Category> getCategoriesFrom(ItemDto itemDto) {
        List<Category> categories = new ArrayList<>();
        for(CategoryDto categoryDto : itemDto.getCategories()) {
            Category category = categoryDAO.findOne(categoryDto.getId());
            if (category == null)
                throw new NotFoundException("Category with Id " + categoryDto.getId() + " was not found");
            categories.add(category);
        }
        return categories;
    }
}

