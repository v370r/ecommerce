package com.vijay.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vijay.ecommerce.dto.CartDTO;
import com.vijay.ecommerce.dto.CartItemDTO;
import com.vijay.ecommerce.model.Cart;
import com.vijay.ecommerce.model.CartItem;

@Mapper(componentModel = "spring")
public interface CartMapper {

    @Mapping(target = "userId", source = "user.id")
    CartDTO toDTO(Cart cart);

    @Mapping(target = "user.id", source = "userId")
    Cart toEntity(CartDTO cartDTO);

    @Mapping(target = "productId", source = "product.id")
    CartItemDTO toDTO(CartItem cartItem);

    @Mapping(target = "product.id", source = "productId")
    CartItem toEntity(CartItemDTO cartItemDTO);

}
