package voyendo.service;

import voyendo.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    Logger logger = LoggerFactory.getLogger(CategoryService.class);

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public Category crearCategoria(String nombre){
        logger.debug("Creando categoria " + nombre);
        Category category = new Category(nombre);
        categoryRepository.save(category);
        return category;
    }

    @Transactional(readOnly = true)
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional(readOnly = true)
    public List<Category> findAllOrderedByName() {
        return categoryRepository.findAllByOrderByNameAsc();
    }

    @Transactional(readOnly = true)
    public Category findById(Long categoryId) { return categoryRepository.findById(categoryId).orElse(null); }

    @Transactional(readOnly = true)
    public Category findByName(String name) { return categoryRepository.findByName(name).orElse(null); }
}
