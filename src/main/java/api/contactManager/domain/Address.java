package api.contactManager.domain;

import lombok.*;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Data
@Entity
@ToString
@Table(name = "address")
public class Address implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @NotNull(message = "street number is a a required field.")
    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "box_number")
    private String boxNumber;

    @NotNull(message = "street name is a a required field.")
    @Column(name = "street_name")
    private String streetName;

    @NotNull(message = "zip code is a a required field.")
    @Column(name = "zipcode")
    private String zipcode;

    @NotNull(message = "locality is a a required field.")
    @Column(name = "locality")
    private String locality;

    @NotNull(message = "country is a a required field.")
    @Column(name = "country")
    private String country;

    @OneToOne(mappedBy = "contact_address")
    private Contact contact;

    @OneToOne(mappedBy = "enterprise_address")
    private Enterprise enterprise;
}
