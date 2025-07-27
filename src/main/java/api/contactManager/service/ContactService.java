package api.contactManager.service;//package api.contactManager.service;


import api.contactManager.dto.ContactDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface ContactService {

    Logger log = LoggerFactory.getLogger(ContactService.class);

    List<ContactDTO> findAll();

}
