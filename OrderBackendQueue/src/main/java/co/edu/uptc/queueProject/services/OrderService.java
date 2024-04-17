package co.edu.uptc.queueProject.services;

import java.util.List;
import java.util.LinkedList;

import co.edu.uptc.queueProject.models.Order;

public class OrderService {

    private LinkedList<Order> orders = new LinkedList<Order>();
    private int lastTurn = 0;

    public OrderService() {
        loadDates();
    }

    public List<Order> loadDates() {

        Order order = new Order();
        order.setClientName("Max Holloway");
        order.setClientAdress("Diagonal 25 N 2-03");
        order.setQuantity(1);
        order.setTypeOrder(2);
        orders.add(order);

        order = new Order();
        order.setClientName("Juan Perez");
        order.setClientAdress("Carrera 10 N 5-05");
        order.setQuantity(1);
        order.setTypeOrder(4);
        orders.add(order);

        return orders;
    }

    public List<Order> getOrder() {
        LinkedList<Order> orderAux = new LinkedList<Order>();
        for (Order order : orders) {
            orderAux.offer(order);
        }
        uploadTurn();
        return orderAux;
    }

    public void addOrder(Order newOrder) {
        orders.add(newOrder);
        uploadTurn();
    }

    private void uploadTurn() {
        int turnoActual = 1;
        for (Order order : orders) {
            order.setTurn(turnoActual);
            turnoActual++;
        }
        lastTurn = turnoActual - 1;
    }

    public Order deleteOrder() {
        Order deletedOrder = null;
        deletedOrder = orders.remove();
        uploadTurn();
        return deletedOrder;
    }

}
