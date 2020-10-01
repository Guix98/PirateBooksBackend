package bo.edu.ucb.sis.piratebay.bl;

import bo.edu.ucb.sis.piratebay.dao.CategoryDao;

import bo.edu.ucb.sis.piratebay.model.CategoryModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryBl {
    private CategoryDao categoryDao;

    @Autowired
    public CategoryBl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    public List<CategoryModel> findAllCategory() {
        return this.categoryDao.findAllCategory();
    }
}
