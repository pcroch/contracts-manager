package api.contactManager.service;//package api.contactManager.service;

import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface EnterpriseService {

    List<EnterpriseDTO> findAll();

    Optional<EnterpriseDTO> update(EnterpriseDTO enterpriseDTO);

    EnterpriseDTO save(@Valid EnterpriseDTO enterpriseDTO);

    Optional<EnterpriseDTO>  findEnterpriseByVatNumber(@Valid String vatNumber);

    void addContactToEnterprise (UUID enterpriseId,UUID contactID);
}
