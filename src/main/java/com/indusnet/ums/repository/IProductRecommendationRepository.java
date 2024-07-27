package com.indusnet.ums.repository;

import com.indusnet.ums.model.UserRecommendationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IProductRecommendationRepository extends MongoRepository<UserRecommendationModel,String> {

}
