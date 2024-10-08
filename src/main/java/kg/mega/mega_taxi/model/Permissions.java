package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@NoArgsConstructor
@Entity
@Table(name = "permissions")
@Component
@Data
public class Permissions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long permissionId;
    @Column(name = "permission_name")
    private String permission_name;

}
