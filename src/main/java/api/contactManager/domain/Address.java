package api.contactManager.domain;

import lombok.*;
import org.jetbrains.annotations.NotNull;

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

    @NotNull
    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "box_number")
    private String boxNumber;

    @NotNull
    @Column(name = "street_name")
    private String streetName;

    @NotNull
    @Column(name = "zipcode")
    private String zipcode;

    @NotNull
    @Column(name = "locality")
    private String locality;

    @NotNull
    @Column(name = "country")
    private String country;

//    @OneToOne(mappedBy = "address")
//    private Contact contact;

//    @OneToOne
//    @JoinColumn(name = "enterprise_id")
//    private Enterprise enterprise;


//    @Override
//    public String toString() {
//        return String.format("{addressId: %s, streetNumber: %s, streetName: %s}", addressId, streetNumber, streetName);
//    }
}
