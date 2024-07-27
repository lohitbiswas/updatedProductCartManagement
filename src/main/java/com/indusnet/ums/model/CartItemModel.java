package com.indusnet.ums.model;

import com.indusnet.ums.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemModel {
    private ProductModel product;
    private int quantity;
}

