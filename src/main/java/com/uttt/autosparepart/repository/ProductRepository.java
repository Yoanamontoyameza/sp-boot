package com.uttt.autosparepart.repository;

import com.uttt.autosparepart.entities.ProductDO;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<ProductDO,Long> {
}
