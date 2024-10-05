package com.vijay.ecommerce.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vijay.ecommerce.dto.CommentDTO;
import com.vijay.ecommerce.dto.ProductDTO;
import com.vijay.ecommerce.model.Comment;
import com.vijay.ecommerce.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "image", source = "image")
    ProductDTO toDTO(Product product);

    @Mapping(target = "image", source = "image")
    Product toEntity(ProductDTO productDTO);

    @Mapping(target = "userId", source = "user.id")
    CommentDTO toDTO(Comment comment);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "product", ignore = true)
    Comment toEntity(CommentDTO commentDTO);
}
