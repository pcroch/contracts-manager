package api.contactManager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
@ToString
@Table(name = "enterprise")
public class Enterprise {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "tva number is a a required field.")
    @Column(name = "tva_number")
    private String tvaNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address enterpriseAddress;

    @ManyToMany(mappedBy = "enterprises", fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<Contact> contacts;




}
