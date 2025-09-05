package api.contactManager.service;

import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.errors.BadRequestException;
import api.contactManager.errors.ResourceNotFoundException;
import api.contactManager.service.common.CrudService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

/**
 * Using face dessign pattern
 */

public interface EnterpriseService extends CrudService<EnterpriseDTO, UUID> {

    List<EnterpriseDTO> findAll();

    EnterpriseDTO update(UUID id, @Valid EnterpriseDTO enterpriseDTO) throws ResourceNotFoundException, BadRequestException;

    EnterpriseDTO save(@Valid EnterpriseDTO enterpriseDTO);

    EnterpriseDTO  findEnterpriseByVatNumber (String vatNumber) throws ResourceNotFoundException;

    void addContactToEnterprise (UUID enterpriseId,UUID contactID) throws ResourceNotFoundException;
}
