package api.contactManager.controller.template.v1;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.service.ContactService;
import api.contactManager.service.EnterpriseService;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
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

    @PostMapping("/enterprises")
    public ResponseEntity<EnterpriseDTO> createEnterprise(@RequestBody EnterpriseDTO body) {
        log.debug("REST request to create an entreprise");
        EnterpriseDTO enterpriseDTO = this.enterpriseService.save(body);
        return ResponseEntity.status(HttpStatus.CREATED).body(enterpriseDTO);
    }

    @PutMapping(value = "/enterprise/{id}")
    public ResponseEntity<EnterpriseDTO> updateEnterprise(@PathVariable("id") UUID id, @RequestBody @NonNull EnterpriseDTO body) {
        log.debug("REST request to update an enterprise completely  : {}, {}", id, body.getVatNumber());

        if (!id.equals(body.getId())) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(enterpriseService
                        .update(body)
                        .orElseThrow(() -> new RuntimeException("No enterprise was found with this id :" + id))); //todo error to change

    }

    @PutMapping(value = "/enterprise/{vatNumber}")
    public ResponseEntity<EnterpriseDTO> findEnterpriseByVatNumber(@PathVariable("vatNumber") String vatNumber) {
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

    @PostMapping("/enterprise/addContact/{uuid}\"")
    public ResponseEntity<EnterpriseDTO> addContactByEnterprise(@PathVariable("uuid") UUID uuid, @RequestBody ContactDTO body) {
        return ResponseEntity
                .status(HttpStatus.FOUND)
                .body(enterpriseService
                        .addContactToEnterprise(uuid, body));
    }


}
