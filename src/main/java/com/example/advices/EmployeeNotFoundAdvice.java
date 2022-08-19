package com.example.advices;

import com.example.beans.Fault;
import com.example.exceptions.EmployeeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class EmployeeNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Fault employeeNotFoundHandler(EmployeeNotFoundException ex) {
        Fault eror = new Fault();
        eror.setErrorCode("01");
        eror.setErrorMessage(ex.getMessage());
        return eror;
    }
}