package api.contactManager.controller.template.v1;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.errors.ResourceNotFoundException;
import api.contactManager.service.ContactService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Controller
public class ContactControllerV1 extends BaseRestController {

    private final ContactService contactService;

    public ContactControllerV1(ContactService contactService) {
        this.contactService = contactService;

    }

    @GetMapping("/contacts")
    public ResponseEntity<List<ContactDTO>> getAllContacts() {
        log.info("REST request to get all contacts");
        return ResponseEntity.status(HttpStatus.OK).body(contactService.findAll());
    }


    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> createContact(@RequestBody @NonNull ContactDTO body) {
        log.debug("REST request to create a contact");
        ContactDTO contact = this.contactService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

    @PutMapping(value = "/contact/{id}") // not patch as fully updates
    public ResponseEntity<ContactDTO> updateContact(@PathVariable("id") UUID id, @RequestBody @NonNull ContactDTO body) {
        log.debug("REST request to update a contact completely  : {}, {}", id, body.getName());

        if (!id.equals(body.getId())) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactService
                        .update(body)
                        .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + id)));
    }


    @DeleteMapping(value = "/contacts/{id}")
    public ResponseEntity<Map<String, String>>  deleteContactPerId(@PathVariable("id") UUID id) {
        log.debug("REST request to delete contact : {}", id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", contactService.delete(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + id))));
    }
}
