package com.obuvki.rest.DTO.ProductDTOs;
import lombok.Data;
@Data
public class ExportCartDto {
    private  long id;
    private  String productName;
    private  float price;
    private  String size;
    private  long quantity;
    private  String imageURL;
}
