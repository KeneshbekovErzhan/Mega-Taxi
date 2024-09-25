package kg.mega.mega_taxi.model;


import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "users")
@Component
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @OneToOne
    @JoinColumn(name = "roleId", referencedColumnName = "roleId")
    private Roles roles;
}
