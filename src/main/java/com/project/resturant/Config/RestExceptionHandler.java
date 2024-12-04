package com.project.resturant.Config;

import com.project.resturant.Dtos.BundleMessage;
import com.project.resturant.Dtos.ExceptionResponse;
import com.project.resturant.Service.BundleTranslatorService;
import jakarta.transaction.SystemException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {
@ExceptionHandler(SystemException.class)
    public ResponseEntity<ExceptionResponse> handleSystemException(SystemException exception){
        return ResponseEntity.ok( new ExceptionResponse(HttpStatus.BAD_REQUEST, BundleTranslatorService.getMessageInEnglishAndArabic(exception.getMessage())) );

    }
}
