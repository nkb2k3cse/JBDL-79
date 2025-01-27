package com.example.L14_minor_project_01.exception;

import com.example.L14_minor_project_01.dto.CreateProductResponseDto;
import com.example.L14_minor_project_01.dto.ErrorDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(annotations = RestController.class)
public class GlobalExceptionHandler {

//    @ExceptionHandler(CategoryDoesNotExistException.class)
//    public ResponseEntity<CreateProductResponseDto> handleCategoryDoesNotExistException(CategoryDoesNotExistException exception){
//        CreateProductResponseDto responseDto = new CreateProductResponseDto();
//        responseDto.setMsg("Category Does not exist");
//        return ResponseEntity.badRequest().body(responseDto);
//    }

    @ExceptionHandler(CategoryDoesNotExistException.class)
    public ResponseEntity<ErrorDto> handleCategoryDoesNotExistException(CategoryDoesNotExistException exception){
        ErrorDto responseDto = new ErrorDto();
        responseDto.setMsg("Category Does not exist");
        responseDto.setCode(1001l);
        return ResponseEntity.badRequest().body(responseDto);
    }


    @ExceptionHandler(CompanyDoesNotExistException.class)
    public ResponseEntity<ErrorDto> handleCategoryDoesNotExistException(CompanyDoesNotExistException exception){
        ErrorDto responseDto = new ErrorDto();
        responseDto.setMsg("Company Does not exist");
        responseDto.setCode(1002l);
        return ResponseEntity.badRequest().body(responseDto);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ErrorDto> handleInvalidProductException(ProductNotFoundException productNotFoundException){
        ErrorDto errorDto = new ErrorDto();
        errorDto.setMsg("Product Id does not exist, please use correct product id.");
        errorDto.setCode(1003l);
        return ResponseEntity.badRequest().body(errorDto);
    }

}
