package com.shawn.web.exception;

import com.shawn.constant.ErrorCode;
import com.shawn.model.dto.Error;
//import lombok.extern.apachecommons.CommonsLog;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Xiaoyue Xiao
 */
@ControllerAdvice
class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundExceptionHandler(HttpServletRequest request, ResourceNotFoundException e) {
        logError(request, e);
        Error ex = new Error();
        ex.setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR);
        ex.setMessage(e.getMessage());
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ex);
    }

    @ExceptionHandler(ParameterIllegalException.class)
    public ResponseEntity<?> parameterIllegalExceptionHandler(HttpServletRequest request, ParameterIllegalException e) {
        logError(request, e);
        Error ex = new Error();
        ex.setCode(ErrorCode.PARAMETER_ILLEGAL_ERROR);
        ex.setMessage("An invalid value was specified for one of the query parameters in the request URL.");
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(ex);
    }

    @ExceptionHandler(ServerInternalErrorException.class)
    public ResponseEntity<?> serverInternalErrorExceptionHandler(HttpServletRequest request, ServerInternalErrorException e) {
        logError(request, e);
        Error ex = new Error();
        ex.setCode(ErrorCode.RESOURCE_NOT_FOUND_ERROR);
        ex.setMessage("The server encountered an internal error. Please retry the request.");
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> exceptionHandler(HttpServletRequest request, Exception e) {
        logError(request, e);
        Error ex = new Error();
        ex.setCode(ErrorCode.SERVER_INTERNAL_ERROR);
        ex.setMessage("The server met an unexpected error. Please contact administrators. " + e.getMessage());
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(ex);
    }

    /********************************** HELPER METHOD **********************************/
    private void logError(HttpServletRequest request, Exception e) {
    	System.out.println("[URI: " + request.getRequestURI() + "]"
                + "[error: " + e.getMessage() + "]");
    }

}
