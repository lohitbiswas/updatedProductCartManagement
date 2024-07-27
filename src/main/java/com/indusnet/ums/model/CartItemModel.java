package com.indusnet.ums.model;

import com.indusnet.ums.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartItemModel {
    private ProductModel product;
    private int quantity;
}

