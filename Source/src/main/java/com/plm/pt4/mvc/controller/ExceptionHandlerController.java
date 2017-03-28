package com.plm.pt4.mvc.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {
      
      @ExceptionHandler(Exception.class)
      public String handleException(Exception ex) {
            System.out.println(ex.toString());
            return "error";
      }

}