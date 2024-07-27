package com.indusnet.ums.controller;

import com.indusnet.ums.model.ProductModel;
import com.indusnet.ums.service.IProductRecommendationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequestMapping("/api/recommendations")

public class RecommendationController {

    @Autowired
    private IProductRecommendationService recommendationService;

    // Example endpoint: Get product recommendations based on a user ID
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<ProductModel>> getRecommendationsForUser(@PathVariable String userId) {
        List<ProductModel> recommendations = recommendationService.getRecommendationsForUser(userId);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }

    // Example endpoint: Get product recommendations based on a product ID
    @GetMapping("/product/{productId}")
    public ResponseEntity<List<ProductModel>> getRecommendationsForProduct(@PathVariable String productId) {
        List<ProductModel> recommendations = recommendationService.getRecommendationsForProduct(productId);
        return new ResponseEntity<>(recommendations, HttpStatus.OK);
    }
}

