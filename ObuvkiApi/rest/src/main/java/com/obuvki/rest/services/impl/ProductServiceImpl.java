package com.obuvki.rest.services.impl;

import com.obuvki.rest.DTO.ProductDTOs.ExportProductDto;
import com.obuvki.rest.Models.AppProduct;
import com.obuvki.rest.repository.ProductRepository;
import com.obuvki.rest.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    //ExportPRODUCT
//    private  long id;
//    private  String productName;
//    private  float price;
//    private  String size;
//    private  String info;
//    private  String company;
//    private  String imageURL;
    private  final ProductRepository productRepository;

    public List<ExportProductDto> getAllProducts(){
        List<AppProduct> products =  productRepository.findAll();
        List<ExportProductDto> exportProductsDto= new ArrayList<>();
        for (AppProduct product : products)
        {
           ExportProductDto exportProduct =  new ExportProductDto();
           exportProduct.setProductName(product.getProductName());
           exportProduct.setId(product.getProductid());
           exportProduct.setCompany(product.getBrand());
           exportProduct.setImageURL(product.getImageURL());
           exportProduct.setSize(product.getSize());
           exportProduct.setPrice(product.getPrice());

           exportProductsDto.add(exportProduct);
        }

        return exportProductsDto;

    }

}

