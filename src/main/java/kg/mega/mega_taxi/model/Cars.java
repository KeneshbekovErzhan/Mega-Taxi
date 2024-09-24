package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "number_sheet")
    private String numberSheet;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users idUsers;

}
