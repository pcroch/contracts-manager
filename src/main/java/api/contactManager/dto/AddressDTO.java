package api.contactManager.dto;

import api.contactManager.domain.Contact;
import api.contactManager.domain.Enterprise;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.UUID;

@Data
@ToString
public class AddressDTO implements Serializable {

    private UUID id;
    private String streetNumber;
    private String boxNumber;
    private String streetName;
    private String zipcode;
    private String locality;
    private String country;
    private Contact contact;
    private Enterprise enterprise;
}