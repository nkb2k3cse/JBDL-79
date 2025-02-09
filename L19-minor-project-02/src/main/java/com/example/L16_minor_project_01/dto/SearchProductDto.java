package com.example.L16_minor_project_01.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
public class SearchProductDto implements Serializable {

    private static final long serialVersionUID = 1l;
    private List<ProductDto> productDtoList;
    private Long totalRows;
    private Integer totalPages;
}
