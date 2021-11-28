package com.misiontic.factura_db_ms.controllers;

import com.misiontic.factura_db_ms.models.Cliente;
import com.misiontic.factura_db_ms.repositories.ClienteRepository;
import com.misiontic.factura_db_ms.exceptions.UserClienteNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {
    private final ClienteRepository clienteRepository;

    public ClienteController(ClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @GetMapping("/clientes/{username}")
    Cliente getCliente(@PathVariable String username){
        return this.clienteRepository.findById(username).
                orElseThrow(() -> new UserClienteNotFoundException("El usuario no existe"));
    }

    @PostMapping("/clientes")
    Cliente newCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @PutMapping("/clientes/update")
    Cliente updateCliente(@RequestBody Cliente cliente){
        return clienteRepository.save(cliente);
    }

    @DeleteMapping("/clientes/delete/{username}")
    String deleteCliente(@PathVariable String username){
        Cliente cliente = this.clienteRepository.findById(username).orElse(null);
        if(cliente == null){
            throw new UserClienteNotFoundException("EL cliente que desea eliminar no existe");
        }
        this.clienteRepository.deleteById(username);
        return "CLiente eliminado";
    }
}
