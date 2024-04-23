package co.edu.uptc.queueProject.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Claim {

    private String name;
    private String id;
    private String accountNumber;
    private String matter;
    private String email;
    private String claim;
    private int turn;
   

}
