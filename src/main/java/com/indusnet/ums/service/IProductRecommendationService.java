package com.indusnet.ums.service;

import com.indusnet.ums.model.ProductModel;

import java.util.List;

public interface IProductRecommendationService {
    List<ProductModel> getRecommendationsForUser(String userId);
    List<ProductModel> getRecommendationsForProduct(String productId);
}
