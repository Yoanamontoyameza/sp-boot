package com.uttt.autosparepart.sevices;

import com.uttt.autosparepart.entities.CategoryDO;
import com.uttt.autosparepart.entities.ProductDO;
import com.uttt.autosparepart.entities.ResponseTO;
import com.uttt.autosparepart.repository.CategoryRepository;
import com.uttt.autosparepart.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements ProductServiceI {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @Override
    public CategoryDO save(CategoryDO categoryDO) {
        return categoryRepository.save(categoryDO);
    }

    @Override
    public List<CategoryDO> categories() {
        Iterable<CategoryDO> elements = categoryRepository.findAll();
        List<CategoryDO> categories = new ArrayList<>();
        elements.forEach(categories::add);
        return categories;
    }

    @Override
    public ResponseTO delete(Long id) {
        ResponseTO response = new ResponseTO();
         this.categoryRepository.deleteById(id);
         response.setStatus(true);
         response.setMessage("Categoria eliminada");
         return  response;
    }

    @Override
    public ProductDO saveProduct(ProductDO productDO) {
        return productRepository.save(productDO);
    }

    @Override
    public List<ProductDO> products() {
        Iterable<ProductDO> elements = productRepository.findAll();
        List<ProductDO> products = new ArrayList<>();
        elements.forEach(products::add);
        return products;
    }

    @Override
    public ResponseTO deleteProduct(Long id) {
        ResponseTO response = new ResponseTO();
        this.productRepository.deleteById(id);
        response.setStatus(true);
        response.setMessage("Producto eliminado");
        return  response;
    }
}
