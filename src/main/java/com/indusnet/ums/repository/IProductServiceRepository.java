package com.indusnet.ums.repository;

import com.indusnet.ums.model.ProductModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface IProductServiceRepository extends MongoRepository<ProductModel,String> {

    List<ProductModel> findByCategory(String electronics);
}
