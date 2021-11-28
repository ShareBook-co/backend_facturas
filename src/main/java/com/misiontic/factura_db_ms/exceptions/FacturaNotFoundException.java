package com.misiontic.factura_db_ms.exceptions;

public class FacturaNotFoundException extends RuntimeException {
    public FacturaNotFoundException(String message){
        super(message);
    }

}
