package com.uttt.autosparepart.repository;

import com.uttt.autosparepart.entities.CategoryDO;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryDO,Long> {
}
