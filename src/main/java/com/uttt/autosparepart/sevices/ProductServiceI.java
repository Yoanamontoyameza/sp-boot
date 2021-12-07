package com.uttt.autosparepart.sevices;

import com.uttt.autosparepart.entities.CategoryDO;
import com.uttt.autosparepart.entities.ProductDO;
import com.uttt.autosparepart.entities.ResponseTO;

import java.util.List;

public interface ProductServiceI {
    CategoryDO save(CategoryDO categoryDO);
    List<CategoryDO> categories();
    ResponseTO delete(Long id);
    ProductDO saveProduct(ProductDO productDO);
    List<ProductDO> products();
    ResponseTO deleteProduct(Long id);
}
