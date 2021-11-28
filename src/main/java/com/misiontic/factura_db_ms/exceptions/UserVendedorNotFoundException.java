package com.misiontic.factura_db_ms.exceptions;

public class UserVendedorNotFoundException extends RuntimeException{
    public UserVendedorNotFoundException(String message){
        super(message);
    }
}
