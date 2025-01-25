package com.example.L15_minor_project_01.config;

import com.example.L15_minor_project_01.dto.ErrorDto;
import com.example.L15_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L15_minor_project_01.exception.CompanyDoesNotExistException;
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
}
