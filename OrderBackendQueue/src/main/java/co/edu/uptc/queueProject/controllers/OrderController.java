package co.edu.uptc.queueProject.controllers;

import org.springframework.web.bind.annotation.RestController;

import co.edu.uptc.queueProject.models.Order;
import co.edu.uptc.queueProject.services.OrderService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Queue;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {

    OrderService orderService = new OrderService();

    @GetMapping()
    public ResponseEntity<Object> getOrder() {
        Queue<Order> orders;
        orders = orderService.getOrder();
        return ResponseEntity.status(HttpStatus.OK).body(orders);
    }

    @PostMapping("addOrder")
    public ResponseEntity<Object> addOrder(@RequestBody Order order) {
        orderService.addOrder(order);
        return ResponseEntity.status(HttpStatus.OK).body(order);
    }

    @DeleteMapping("/sendOrder")
    public ResponseEntity<Object> deleteOrder() {
        Order order = orderService.deleteOrder();
        return ResponseEntity.ok().body(order);
    }

}
