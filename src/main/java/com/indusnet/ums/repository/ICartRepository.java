package com.indusnet.ums.repository;

import com.indusnet.ums.model.CartModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ICartRepository extends MongoRepository<CartModel,String> {

}
