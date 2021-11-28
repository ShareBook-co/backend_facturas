package com.misiontic.factura_db_ms.exceptions;

public class UserClienteNotFoundException extends RuntimeException{
    public UserClienteNotFoundException(String message){
        super(message);
    }
}
