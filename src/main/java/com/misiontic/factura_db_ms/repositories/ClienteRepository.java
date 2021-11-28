package com.misiontic.factura_db_ms.repositories;

import com.misiontic.factura_db_ms.models.Cliente;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
}
