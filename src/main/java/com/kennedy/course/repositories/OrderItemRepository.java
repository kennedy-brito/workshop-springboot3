package com.kennedy.course.repositories;

import com.kennedy.course.entities.OrderItem;
import com.kennedy.course.entities.pk.OrderItemPk;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {
}
