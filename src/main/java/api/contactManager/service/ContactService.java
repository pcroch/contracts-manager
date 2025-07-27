package api.contactManager.service;//package api.contactManager.service;


import api.contactManager.dto.ContactDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface ContactService {

    List<ContactDTO> findAll();

}
