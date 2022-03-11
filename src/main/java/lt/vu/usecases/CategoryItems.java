package lt.vu.usecases;

import lombok.Getter;
import lombok.Setter;
import lt.vu.entities.Category;
import lt.vu.persistence.CategoryDAO;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;
import java.util.Map;

@Model
public class CategoryItems implements Serializable {

    @Inject
    private CategoryDAO categoryDAO;

    @Getter
    @Setter
    private Category category;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer categoryId = Integer.parseInt(requestParameters.get("categoryId"));
        this.category = categoryDAO.findOne(categoryId);
    }
}

