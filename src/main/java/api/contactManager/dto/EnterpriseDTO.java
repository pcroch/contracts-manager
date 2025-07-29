package api.contactManager.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import api.contactManager.domain.Address;
import api.contactManager.domain.Contact;
import api.contactManager.domain.Enterprise;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
public class EnterpriseDTO implements Serializable {

    private UUID id;
    private String vatNumber;
    private Address enterpriseAddress;
    private Set<Contact> contacts;
}