package api.contactManager.controller.template.v1;


import api.contactManager.dto.ContactDTO;
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
@Controller
public class EnterpriseControllerV1 extends BaseRestController {

    private final EnterpriseService enterpriseService;

    public EnterpriseControllerV1(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/enterprise")
    public ResponseEntity<EnterpriseDTO> createEnterprise(@RequestBody EnterpriseDTO body) {
        log.debug("REST request to create an entreprise");
        EnterpriseDTO enterpriseDTO = this.enterpriseService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(enterpriseDTO);
    }

    @PutMapping(value = "/enterprise")
    public ResponseEntity<EnterpriseDTO> updateEnterprise(@RequestBody @NonNull EnterpriseDTO body) {
        log.debug("REST request to update an enterprise completely: " + body.getId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(enterpriseService
                        .update(body)
                        .orElseThrow(() -> new RuntimeException("No enterprise was found with this id :" + body.getId()))); //todo error to change

    }

    @GetMapping(value = "/enterprise")
    public ResponseEntity<EnterpriseDTO> findEnterpriseByVatNumber(@RequestParam("vatNumber") String vatNumber) {
        log.debug("REST request to find an enterprise with VAT Number  : {}", vatNumber);
        //todo if null and using params instead of path variable
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(enterpriseService
                        .findEnterpriseByVatNumber(vatNumber)
                        .orElseThrow(() -> new RuntimeException("No enterprise was found with this vat number :" + vatNumber))); //todo error to change
    }

    @GetMapping("/enterprises")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprises() {
        log.info("REST request to get all enterprises");
        return ResponseEntity.status(HttpStatus.OK).body(enterpriseService.findAll());
    }

    @PostMapping("/enterprise/addContact")
    public ResponseEntity<EnterpriseDTO> addContactByEnterprise(@RequestParam("enterpriseId") UUID enterpriseId, @RequestParam("contactId") UUID contactId) {
        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(enterpriseService
                        .addContactToEnterprise(enterpriseId, contactId));
    }
}
