package api.contactManager.service;//package api.contactManager.service;


import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.service.common.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactService extends CrudService<ContactDTO, UUID>  {

    List<ContactDTO> findAll();

    ContactDTO save(@Valid ContactDTO contactDTO);

    ContactDTO update(UUID ID, ContactDTO contactDTO);

    void delete(UUID uuid);

}
