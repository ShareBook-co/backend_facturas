package com.misiontic.factura_db_ms.controllers;

import com.misiontic.factura_db_ms.models.*;
import com.misiontic.factura_db_ms.repositories.*;
import com.misiontic.factura_db_ms.exceptions.*;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FacturacionController {
    private final FacturacionRepository facturacionRepository;
    private final ClienteRepository clienteRepository;
    private final VendedorRepository vendedorRepository;

    public FacturacionController(FacturacionRepository facturacionRepository, ClienteRepository clienteRepository, VendedorRepository vendedorRepository){
        this.facturacionRepository = facturacionRepository;
        this.clienteRepository = clienteRepository;
        this.vendedorRepository = vendedorRepository;
    }

    @PostMapping("/facturacion")
    Facturacion newFactura(@RequestBody Facturacion factura){
        Cliente cliente   = this.clienteRepository.findById( factura.getCliente() ).orElse(null);
        if(cliente == null){
            throw new UserClienteNotFoundException("El Cliente no existe");
        }
        Vendedor vendedor = this.vendedorRepository.findById(factura.getVendedor()).orElse(null);
        if(vendedor == null){
            throw new UserVendedorNotFoundException("El Vendedor no existe");
        }
        this.clienteRepository.save(cliente);
        this.vendedorRepository.save(vendedor);
        factura.setFecha( new Date() );
        return facturacionRepository.save(factura);
    }

    @GetMapping("/facturacion/vendedor/{username}")
    List<Facturacion> vendedorFacturas(@PathVariable String username){
        Vendedor vendedor   = this.vendedorRepository.findById( username ).orElse(null);
        if(vendedor == null){
            throw new UserVendedorNotFoundException("El Cliente no existe");
        }
        List<Facturacion> facturasVendedor = this.facturacionRepository.findByVendedor(username);
        return facturasVendedor;
    }

    @GetMapping("/facturacion/clientes/{username}")
    List<Facturacion> clienteFacturas(@PathVariable String username){
        Cliente cliente   = this.clienteRepository.findById( username ).orElse(null);
        if(cliente == null){
            throw new UserClienteNotFoundException("El Cliente no existe");
        }
        List<Facturacion> facturasCliente = this.facturacionRepository.findByCliente(username);
        return facturasCliente;
    }



    @PutMapping("/facturacion/update")
    Facturacion updateFactura(@RequestBody Facturacion facturacion){
        Facturacion factura = this.facturacionRepository.findById(facturacion.getId()).orElse(null);
        if(factura == null){
            throw new FacturaNotFoundException("El codigo de la factura no existe");
        }
        factura.setCantidadLibro( facturacion.getCantidadLibro());
        factura.setDireccion( facturacion.getDireccion());
        factura.setCliente( facturacion.getCliente());
        factura.setFecha( facturacion.getFecha());
        return facturacionRepository.save(factura);
    }

    @DeleteMapping("/facturacion/delete/{id}")
    String deleteFactura(@PathVariable String id){
        Facturacion factura = this.facturacionRepository.findById(id).orElse(null);
        if(factura == null){
            throw new FacturaNotFoundException("El codigo de la factura no existe");
        }
        this.facturacionRepository.deleteById(id);
        return "La factura se ha eliminado";
    }
}
