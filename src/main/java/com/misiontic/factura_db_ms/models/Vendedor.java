package com.misiontic.factura_db_ms.models;

import org.springframework.data.annotation.Id;

public class Vendedor {
    @Id
    private String username;

    public Vendedor(){}
    public Vendedor(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
