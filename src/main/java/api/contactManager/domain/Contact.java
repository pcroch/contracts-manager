package api.contactManager.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
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

    //    @NotNull(message = "road is a required field.")
    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastame;

    //    @NotNull
    @Column(name = "is_employee")
    private boolean isEmployee;

    //    @NotNull
    @Column(name = "tva_number")
    private String tvaNumber;

    @OneToOne //@OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address contact_address;

    @ManyToMany
//    @JoinTable(
//            name = "enterprise_contact",
//            joinColumns = {@JoinColumn(name = "enterprise_id", referencedColumnName = "id")})
    private Set<Enterprise> enterprise = new HashSet<>();


//    @Override
//    public String toString() {
//        return String.format("{addressId: %s, streetNumber: %s, streetName: %s}", addressId, streetNumber, streetName);
//    }
}
