package com.indusnet.ums.model;

import com.indusnet.ums.model.CartItemModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CartModel {
    private String id;
    private List<CartItemModel> items;
    // Add user information if needed (e.g., userId, email)
}
