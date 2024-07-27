package com.indusnet.ums.service;

import com.indusnet.ums.common.ResponseModel;
import com.indusnet.ums.model.ProductModel;
import com.indusnet.ums.model.UserModel;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    ProductModel createProduct(@Valid ProductModel model);

    List<ProductModel> getAllProducts();
    Optional<ProductModel> getProductById(String productId);

    ProductModel updateProduct(String productId, ProductModel product);
    void deleteProduct(String productId);


}


