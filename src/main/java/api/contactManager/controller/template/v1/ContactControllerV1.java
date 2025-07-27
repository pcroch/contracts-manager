package api.contactManager.controller.template.v1;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.service.ContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ContactControllerV1 extends BaseRestController {

    private static final Logger log = LoggerFactory.getLogger(ContactControllerV1.class);

    private final ContactService contactService;

    private final ContactMapper contactMapper;

    public ContactControllerV1(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }


    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        log.info("REST request to get all contacts");
        List<ContactDTO> response = contactService.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
