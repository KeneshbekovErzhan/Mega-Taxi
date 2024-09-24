package kg.mega.mega_taxi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "permissions")
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "permissions_name")
    private String permissions_name;

}
