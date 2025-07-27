package api.contactManager.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@ToString
@Table(name = "contact")
public class Contact implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "name is a a required field.")
    @Column(name = "name")
    private String name;

    @NotNull(message = "lastname is a a required field.")
    @Column(name = "last_name")
    private String lastName;

    @ColumnDefault("true")
    @Column(name = "is_employee")
    private boolean isEmployee;

    @Column(name = "tva_number")
    private String tvaNumber;

    @OneToOne
    @JoinColumn(name = "address_id")
    private Address contactAddress;

    @ManyToMany
//    @JoinTable(
//            name = "enterprise_contact",
//            joinColumns = {@JoinColumn(name = "enterprise_id", referencedColumnName = "id")})
    private Set<Enterprise> enterprise = new HashSet<>();
}
