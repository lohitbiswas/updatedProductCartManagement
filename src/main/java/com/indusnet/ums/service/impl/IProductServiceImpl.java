package com.indusnet.ums.service.impl;

import com.google.gson.Gson;
import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.ProductModel;

import com.indusnet.ums.repository.IProductServiceRepository;

import com.indusnet.ums.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class IProductServiceImpl implements IProductService {

    @Autowired
    Gson gson = new Gson();

    @Autowired
    IProductServiceRepository repository;

 //   @Override
//    public ProductModel add(ProductModel model) {
//
////        ResponseModel responseObj = null;
//
////
////        Long currentTimeInMilli = Instant.now().toEpochMilli();
////        ProductModel saveModel = ProductModel.builder()
////                .des(model.getDes())
////                .name(model.getName())
////                .colour(model.getColour())
////                .dateCreated(currentTimeInMilli)
////                .build();
//
//        repository.save(model);
//
//
////        log.info(gson.toJson(saveModel));
////
////        responseObj = ResponseModel.builder()
////                .messageEn("User Added Successfully")
////                .messageFr("User Added Successfully")
////                .messageTypeId(1)
////                .statusCode(HttpStatus.OK)
////                .build();
////
////        return responseObj;
//
//    }
    public ProductModel createProduct(ProductModel model) {
        ResponseModel responseObj = null;

       return repository.save(model);
    }
    public List<ProductModel> getAllProducts()
    {
        return repository.findAll();
    }

    public Optional<ProductModel> getProductById(String productId) {
        return repository.findById(productId);
    }



    public ProductModel updateProduct(String productId, ProductModel product) {
        Optional<ProductModel> existingProductOptional = repository.findById(productId);
        if (existingProductOptional.isPresent()) {
            ProductModel existingProduct = existingProductOptional.get();

            // Update product properties as needed
            return repository.save(existingProduct);
        } else {
            // Handle product not found
            throw new RuntimeException("Product not found"); // Replace with custom exception
        }
    }

    public void deleteProduct(String productId) {
        repository.deleteById(productId);
    }


}
