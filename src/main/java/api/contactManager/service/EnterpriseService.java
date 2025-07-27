package api.contactManager.service;//package api.contactManager.service;

import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;

import java.util.List;

public interface EnterpriseService {

    List<EnterpriseDTO> findAll();

}
