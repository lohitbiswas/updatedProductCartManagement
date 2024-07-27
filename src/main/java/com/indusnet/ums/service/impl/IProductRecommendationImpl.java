package com.indusnet.ums.service.impl;

import com.indusnet.ums.model.ProductModel;
import com.indusnet.ums.model.UserRecommendationModel;
import com.indusnet.ums.repository.IProductRecommendationRepository;
import com.indusnet.ums.repository.IProductServiceRepository;
import com.indusnet.ums.service.IProductRecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class IProductRecommendationImpl implements IProductRecommendationService {

    @Autowired
    private IProductServiceRepository productRepository;
    @Override
    public List<ProductModel> getRecommendationsForUser(String userId) {
        return productRepository.findByCategory("electronics");
    }

    @Override
    public List<ProductModel> getRecommendationsForProduct(String productId) {
        ProductModel product = productRepository.findById(productId).orElse(null);
        if (product != null) {
            return productRepository.findByCategory(product.getDes());
        } else {
            // Handle product not found
            return List.of();
        }
    }
}
