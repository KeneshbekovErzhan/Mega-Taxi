package kg.mega.mega_taxi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;
import org.springframework.stereotype.Component;

import java.util.List;
@NoArgsConstructor
@Entity
@Table(name = "roles")
@Component
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long roleId;

    @Column(name = "role")
    private String role;

    @ManyToMany(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name = "roles_has_permissions",
            joinColumns = @JoinColumn(name = "roleId", referencedColumnName = "roleId"),
            inverseJoinColumns = @JoinColumn(name = "permissionId", referencedColumnName = "permissionId")
    )
    private List<Permissions> permissions;
}
