package com.obuvki.rest.DTO.ProductDTOs;

import lombok.Data;

@Data
public class ExportProductDto {
    private  long id;
    private  String productName;
    private  float price;
    private  String size;
    private  String info;
    private  String company;
    private  String imageURL;
}
