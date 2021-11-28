package com.misiontic.factura_db_ms.repositories;

import com.misiontic.factura_db_ms.models.Facturacion;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface FacturacionRepository extends MongoRepository<Facturacion, String> {
    List<Facturacion> findByVendedor (String vendedor);
    List<Facturacion> findByCliente  (String cliente);
}
