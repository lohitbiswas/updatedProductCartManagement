package com.indusnet.ums.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "userPreferences")
public class UserRecommendationModel {
    @Id
    private String userId;
    private List<String> preferredCategories;
    private List<String> purchasedItems;

    // getters and setters
}

