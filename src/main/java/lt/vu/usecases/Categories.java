package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Category;
import lt.vu.persistence.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class Categories {

    @Inject
    private CategoryDAO categoryDAO;

    @Getter
    @Setter
    private Category categoryToCreate = new Category();

    @Getter
    private List<Category> allCategories;

    @PostConstruct
    public void init(){
        loadAllCategories();
    }

    @Transactional
    public void createCategory(){
        this.categoryDAO.persist(categoryToCreate);
    }

    private void loadAllCategories(){
        this.allCategories = categoryDAO.getAll();
    }
}
