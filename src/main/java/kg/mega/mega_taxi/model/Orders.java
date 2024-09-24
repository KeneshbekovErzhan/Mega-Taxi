package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "source_point")
    private String sourcePoint;

    @Column(name = "destination_point")
    private String destinationPoint;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users client;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users driver;

    @Column(name = "order_status")
    private String orderStatus;

    @Column(name = "price")
    private double price;

}
