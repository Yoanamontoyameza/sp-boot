package com.uttt.autosparepart.repository;

import com.uttt.autosparepart.entities.ClientDO;
import org.springframework.data.repository.CrudRepository;

public interface ClientRepository extends CrudRepository<ClientDO,Long> {
    ClientDO findByEmail(String email);
    boolean existsByEmail(String email);
}
