package com.vijay.ecommerce.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.vijay.ecommerce.dto.OrderDTO;
import com.vijay.ecommerce.dto.OrderItemDTO;
import com.vijay.ecommerce.model.Order;
import com.vijay.ecommerce.model.OrderItem;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "orderItems", source = "items")
    OrderDTO toDTO(Order order);

    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "items", source = "orderItems")
    Order toEntity(OrderDTO orderDTO);

    List<OrderDTO> toDTOs(List<Order> orders);

    List<Order> toEntities(List<OrderDTO> orderDTOS);

    @Mapping(target = "productId", source = "product.id")
    OrderItemDTO toOrderItemDTO(OrderItem orderItem);

    @Mapping(target = "product.id", source = "productId")
    OrderItem toOrderItemEntity(OrderItemDTO orderItemDTO);

    List<OrderItemDTO> toOrderItemDTOs(List<OrderItem> orderItem);

    List<OrderItem> toOrderItemEntities(List<OrderItemDTO> orderItemDTO);
}
