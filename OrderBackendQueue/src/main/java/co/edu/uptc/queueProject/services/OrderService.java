package co.edu.uptc.queueProject.services;

import java.util.Queue;
import java.util.LinkedList;

import co.edu.uptc.queueProject.models.Order;
import co.edu.uptc.queueProject.models.Product;
import co.edu.uptc.queueProject.utils.DataUtil;

public class OrderService {

    public OrderService() {
        Order order = new Order();
        order.setClientName("Max Holloway");
        order.setClientAdress("Diagonal 25 N 2-03");
        Queue<Product> products = new LinkedList<>();
        products.offer(new Product("martillo", 5000));
        products.offer(new Product("tubo", 11500));
        products.offer(new Product("puntillas", 15000));
        products.offer(new Product("pegante", 5000));
        order.setProducts(products);
        addOrder(loadDates(), order);

        order = new Order();
        order.setClientName("Juan Perez");
        order.setClientAdress("Carrera 10 N 5-05");
        products.offer(new Product("martillo", 5000));
        products.offer(new Product("tubo", 11500));
        products.offer(new Product("puntillas", 15000));
        products.offer(new Product("pegante", 5000));
        order.setProducts(products);
        addOrder(loadDates(), order);
    }

    public Queue<Order> getOrder() {
        LinkedList<Order> orders = loadDates();
        LinkedList<Order> orderAux = new LinkedList<Order>();
        for (Order order : orders) {
            orderAux.offer(order);
        }
        uploadTurn();
        return orderAux;
    }

    public void addOrder(Queue<Order> orders, Order newOrder) {
        orders.offer(newOrder);
        uploadTurn();
    }

    private void uploadTurn() {
        LinkedList<Order> orders = loadDates();
        for (int i = 0; i < orders.size(); i++) {
            orders.get(i).setTurn(i+1);
        }
    }

    public Order deleteOrder(Queue<Order> orders) {
        Order deletedOrder = orders.poll();
        uploadTurn();
        return deletedOrder;
    }

    public void saveDates(LinkedList<Order> orders){
        DataUtil.orders = orders;
    }

    public LinkedList<Order> loadDates(){
        return (LinkedList<Order>) DataUtil.orders;
    }

}
