package api.contactManager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
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
    private Boolean isEmployee;

    @Column(name = "vat_number") //todo managing when the vat is empty but isEmployee is false
    private String vatNumber;

    @OneToOne
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address contactAddress;

    @ManyToMany(fetch = FetchType.LAZY)
    @JsonIgnore
    @JoinTable(
            name = "enterprise_contact",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "enterprise_id"))
    private Set<Enterprise> enterprises = new HashSet<>();



    @Override
    public int hashCode() {
        return 31;
    }
}
