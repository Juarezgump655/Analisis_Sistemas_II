package com.umg.analisis_sistemas.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 *
 * @author capi juarez
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ControlExcepcion {

    @ExceptionHandler(value = {MSCapiException.class})
    @ResponseBody
    public ResponseEntity MsException(MSCapiException pException) {

        ErrorEnum error = pException.getError();
        int estadoHttp = error.getEstadoHttp();
        String message = pException.getMessageOverwrite();

        if(CollectionUtils.isEmpty(pException.getErrores())) {
            return ResponseEntity
                    .status(estadoHttp)
                    .body(Response.error(error, pException.getParamError(), message));
        } else {
            return ResponseEntity
                    .status(estadoHttp)
                    .body(Response.error(error, pException.getErrores(), message));
        }
    }
}
