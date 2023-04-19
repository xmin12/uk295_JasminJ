package ch.noseryoung.supplier_295.domain.authority;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "authority")
public class Authority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int authority_id;

    @Size(min = 2, max = 10)
    private String name;
}
