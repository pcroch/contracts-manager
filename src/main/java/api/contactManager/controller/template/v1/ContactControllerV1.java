package api.contactManager.controller.template.v1;

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
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactService.findAll());
    }


    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> createContact(@RequestBody @NonNull ContactDTO body) {
        log.info("REST request to create a contact");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(contactService.save(body));
    }

    @PutMapping(value = "/contact") // not patch as fully updates
    public ResponseEntity<ContactDTO> updateContact(@RequestParam("id") @NonNull UUID id, @RequestBody @NonNull ContactDTO body) {
        log.info("REST request to update a contact completely  : {}, {}", id, body.getName());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(contactService.update(id, body));
    }


    @DeleteMapping(value = "/contacts/{id}")
    public ResponseEntity<Map<String, String>>  deleteContactPerId(@PathVariable("id") UUID id) {
        log.info("REST request to delete contact : {}", id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(Map.of("message", contactService.delete(id)
                        .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + id))));
    }
}
