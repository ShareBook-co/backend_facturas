package com.misiontic.factura_db_ms.repositories;

import com.misiontic.factura_db_ms.models.Vendedor;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendedorRepository extends MongoRepository<Vendedor, String> {
}
