package ch.noseryoung.supplier_295.domain.user;

import ch.noseryoung.supplier_295.domain.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;

    @Size(min = 5, max = 30)
    private String username;

    @Size(min = 3, max = 30)
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_role", referencedColumnName = "role_id")
    Role role;

    public User(User user) {
        this.user_id = user.getUser_id();
        this.username = user.getUsername();
    }
}