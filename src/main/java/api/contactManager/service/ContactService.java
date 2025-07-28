package api.contactManager.service;//package api.contactManager.service;


import api.contactManager.dto.ContactDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ContactService {

    List<ContactDTO> findAll();


    ContactDTO save(@Valid ContactDTO contactDTO);

    Optional<ContactDTO> update(ContactDTO contactDTO);

    Optional<String> delete(UUID uuid);

}
