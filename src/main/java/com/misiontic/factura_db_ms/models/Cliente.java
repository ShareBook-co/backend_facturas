package com.misiontic.factura_db_ms.models;

import org.springframework.data.annotation.Id;

public class Cliente {
    @Id
    private String username;

    public Cliente(){}
    public Cliente(String username){
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
