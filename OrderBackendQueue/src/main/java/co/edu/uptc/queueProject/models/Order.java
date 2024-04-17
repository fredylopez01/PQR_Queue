package co.edu.uptc.queueProject.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private String clientName;
    private String clientAdress;
    private int typeOrder;
    private int quantity;
    private int turn;
}
