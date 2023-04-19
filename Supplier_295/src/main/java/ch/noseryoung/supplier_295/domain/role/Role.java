package ch.noseryoung.supplier_295.domain.role;

import ch.noseryoung.supplier_295.domain.authority.Authority;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int role_id;

    @Size(min = 2, max = 10)
    private String role_name;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_authority",
            joinColumns = @JoinColumn(name = "id_role", referencedColumnName = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "id_authority", referencedColumnName = "authority_id"))
    Set<Authority> savedAuthorities;
}
