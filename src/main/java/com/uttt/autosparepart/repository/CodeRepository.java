package com.uttt.autosparepart.repository;

import com.uttt.autosparepart.entities.CodeDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


public interface CodeRepository extends CrudRepository<CodeDO,Long> {
    @Query(value = "SELECT  code FROM restore_code rc WHERE  rc .id  = (SELECT MAX(rc.id) FROM restore_code rc " +
            "WHERE rc.user_dx  = :email)", nativeQuery = true)
    String getTopCode(@Param("email") String email);
}
