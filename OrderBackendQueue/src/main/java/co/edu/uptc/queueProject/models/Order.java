package co.edu.uptc.queueProject.models;


import java.util.Queue;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String clientName;
    private String clientAdress;
    private Queue<Product> products;
    private int turn;
}
