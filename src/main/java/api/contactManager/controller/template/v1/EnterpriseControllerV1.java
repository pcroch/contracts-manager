package api.contactManager.controller.template.v1;


import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.service.EnterpriseService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class EnterpriseControllerV1 extends BaseRestController {

    private final EnterpriseService enterpriseService;

    public EnterpriseControllerV1(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/enterprise")
    public ResponseEntity<EnterpriseDTO> createEnterprise(@RequestBody @NonNull EnterpriseDTO body) {
        log.info("REST request to create an entreprise");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(enterpriseService.save(body));
    }

    @PutMapping(value = "/enterprise") // not patch as fully updates
    public ResponseEntity<EnterpriseDTO> updateEnterprise(@RequestParam("id") @NonNull UUID id, @RequestBody @NonNull EnterpriseDTO body) {
        log.info("REST request to update an enterprise completely: " + body.getId());
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(enterpriseService.update(id, body));

    }

    @GetMapping(value = "/enterprise")
    public ResponseEntity<EnterpriseDTO> findEnterpriseByVatNumber(@NonNull @RequestParam("vatNumber") String vatNumber) {
        log.info("REST request to find an enterprise with VAT Number  : {}", vatNumber);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(enterpriseService.findEnterpriseByVatNumber(vatNumber));
    }

    @GetMapping("/enterprises")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprises() {
        log.info("REST request to get all enterprises");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(enterpriseService.findAll());
    }

    @PostMapping("/enterprise/addContact")
    public ResponseEntity addContactByEnterprise(@NonNull @RequestParam("enterpriseId") UUID enterpriseId, @NonNull @RequestParam("contactId") UUID contactId) {
        log.info("REST request to add contact to an enterprises");
        enterpriseService.addContactToEnterprise(enterpriseId, contactId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
