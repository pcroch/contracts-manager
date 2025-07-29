package api.contactManager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@Entity
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

    @OneToOne(mappedBy = "contactAddress")
    @JsonIgnore
    private Contact contact;

    @OneToOne(mappedBy = "enterpriseAddress")
    @JsonIgnore
    private Enterprise enterprise;


    @Override
    public int hashCode() {
        return 31;
    }
}
