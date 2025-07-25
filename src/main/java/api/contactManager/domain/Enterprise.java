package api.contactManager.domain;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@ToString
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    //    @NotNull
    @Column(name = "tva_number")
    private String tvaNumber;

    @OneToOne //@OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Address enterprise_address;
//
//    @ManyToMany(mappedBy = "enterprise_contact")
    @ManyToMany
    private Set<Contact> contact;


}
