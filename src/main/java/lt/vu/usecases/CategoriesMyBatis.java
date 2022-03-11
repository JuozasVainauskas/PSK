package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.mybatis.dao.CategoryMapper;
import lt.vu.mybatis.model.Category;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class CategoriesMyBatis {
    @Inject
    private CategoryMapper categoryMapper;

    @Getter
    private List<Category> allCategories;

    @Getter @Setter
    private Category categoryToCreate = new Category();

    @PostConstruct
    public void init() {
        this.loadAllCategories();
    }

    private void loadAllCategories() {
        this.allCategories = categoryMapper.selectAll();
    }

    @Transactional
    public String createCategory() {
        categoryMapper.insert(categoryToCreate);
        return "/myBatis/categories?faces-redirect=true";
    }
}

