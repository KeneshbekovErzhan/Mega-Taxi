package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "cars")
@Component
@Data
public class Cars {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long carsId;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "number_sheet")
    private String numberSheet;

    @OneToOne
    @JoinColumn(name = "userId", referencedColumnName = "userId")
    private Users idUsers;

}
