package api.contactManager.dto;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import api.contactManager.domain.Address;
import api.contactManager.domain.Enterprise;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString(exclude = {"enterprises"})
public class ContactDTO implements Serializable {

    private UUID id;
    private String name;
    private String lastName;
    private Boolean isEmployee;
    private String vatNumber;
    private Address contactAddress;
    private Set<Enterprise> enterprises;
}