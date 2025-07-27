package api.contactManager.controller.template.v1;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.service.ContactService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@Controller
public class ContactControllerV1 extends BaseRestController {

    private final ContactService contactService;

    private final ContactMapper contactMapper;

    public ContactControllerV1(ContactService contactService, ContactMapper contactMapper) {
        this.contactService = contactService;
        this.contactMapper = contactMapper;
    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        log.info("REST request to get all contacts");
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
    }


    @PostMapping("/")
    public ResponseEntity<Contact> createContact(@RequestBody ContactDTO body) {
        log.info("Create");
        return null;
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable("id") UUID id, @RequestBody @NonNull ContactDTO body) {
        log.info("Update");
        //todo remplace by body params
        return null;
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> deleteContactPerId(@PathVariable("id") UUID id) {
        log.info("Delete");
        return null;
    }
}
