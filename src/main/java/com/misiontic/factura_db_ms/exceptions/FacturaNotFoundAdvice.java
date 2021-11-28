package com.misiontic.factura_db_ms.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@ResponseBody
public class FacturaNotFoundAdvice {

    @ResponseBody
    @ExceptionHandler(FacturaNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String FacturaNotFoundAdvice(FacturaNotFoundException ex){
        return ex.getMessage();
    }
}
