package com.kennedy.course.resources;

import com.kennedy.course.entities.Order;
import com.kennedy.course.servicies.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    OrderService service;

    @GetMapping
    public ResponseEntity<List<Order>> getOrders(){

        List<Order> orders = service.findAll();

        return ResponseEntity.ok().body(orders);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable long id){
        Order order = service.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
