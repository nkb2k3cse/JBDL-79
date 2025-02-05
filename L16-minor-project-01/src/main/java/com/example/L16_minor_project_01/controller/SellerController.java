package com.example.L16_minor_project_01.controller;

import com.example.L16_minor_project_01.dto.CreateProductRequestDto;
import com.example.L16_minor_project_01.dto.CreateProductResponseDto;
import com.example.L16_minor_project_01.dto.OrderDetailDto;
import com.example.L16_minor_project_01.exception.CategoryDoesNotExistException;
import com.example.L16_minor_project_01.exception.CompanyDoesNotExistException;
import com.example.L16_minor_project_01.service.SellerService;
import jakarta.validation.Valid;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping("/product")
    public ResponseEntity<CreateProductResponseDto> createProduct(@RequestBody @Valid CreateProductRequestDto requestDto) throws CompanyDoesNotExistException, CategoryDoesNotExistException {
        CreateProductResponseDto responseDto = sellerService.createProduct(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    @PostMapping("/bulk-products")
    public ResponseEntity<List<CreateProductResponseDto>> createBulkProducts(@RequestParam MultipartFile file) throws IOException, CompanyDoesNotExistException, CategoryDoesNotExistException {
        List<CreateProductResponseDto> responseDtos = new ArrayList<>();
        BufferedReader fileReader = new BufferedReader(new InputStreamReader(file.getInputStream()));
        CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
        List<CSVRecord> csvRecords = csvParser.getRecords();
        List<CreateProductRequestDto> listDtos = new ArrayList<>();
        for(CSVRecord csvRecord: csvRecords){
            CreateProductRequestDto requestDto = new CreateProductRequestDto();
            requestDto.setName(csvRecord.get("name"));
            requestDto.setDescription(csvRecord.get("description"));
            requestDto.setPrice(Double.valueOf(csvRecord.get("price")));
            requestDto.setActive(Boolean.valueOf(csvRecord.get("active")));
            requestDto.setCatId(Long.valueOf(csvRecord.get("catId")));
            requestDto.setCompanyId(Long.valueOf(csvRecord.get("companyId")));
            listDtos.add(requestDto);
        }
        return ResponseEntity.ok(sellerService.createProductBulk(listDtos));
    }



    @GetMapping("/pendingOrders")
    public List<OrderDetailDto> getPendingOrder(){
        return null;
    }

}
