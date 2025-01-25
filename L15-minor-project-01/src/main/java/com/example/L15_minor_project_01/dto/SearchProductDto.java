package com.example.L15_minor_project_01.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class SearchProductDto {

    private List<ProductDto> productDtoList;
    private Long totalRows;
    private Integer totalPages;
}
