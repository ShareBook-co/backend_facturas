package com.misiontic.factura_db_ms.controllers;

import com.misiontic.factura_db_ms.models.Vendedor;
import com.misiontic.factura_db_ms.repositories.VendedorRepository;
import com.misiontic.factura_db_ms.exceptions.UserVendedorNotFoundException;

import org.springframework.web.bind.annotation.*;

@RestController
public class VendedorController {
    private final VendedorRepository vendedorRepository;

    public VendedorController(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }

    @GetMapping("/vendedores/{username}")
    Vendedor getVendedor(@PathVariable String username){
        return this.vendedorRepository.findById(username).
                orElseThrow(() -> new UserVendedorNotFoundException("El usuario no existe"));
    }

    @PostMapping("/vendedores")
    Vendedor newVendedor(@RequestBody Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    @PutMapping("/vendedores/update")
    Vendedor updateVendedor(@RequestBody Vendedor vendedor){
        return vendedorRepository.save(vendedor);
    }

    @DeleteMapping("/vendedores/delete/{username}")
    String deleteVendedor(@PathVariable String username){
        Vendedor vendedor = this.vendedorRepository.findById(username).orElse(null);
        if(vendedor == null){
            throw new UserVendedorNotFoundException("EL Vendedor que desea eliminar no existe");
        }
        this.vendedorRepository.deleteById(username);
        return "Vendedor Elimiando";
    }
}
