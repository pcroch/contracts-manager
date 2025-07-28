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
public class EnterpriseControllerV1 extends BaseRestController{

    private final EnterpriseService enterpriseService;

    public EnterpriseControllerV1(EnterpriseService enterpriseService) {
        this.enterpriseService = enterpriseService;
    }

    @PostMapping("/enterprises/")
    public ResponseEntity<Contact> createEnterprise(@RequestBody ContactDTO body) {
        log.info("Create");
        return null;
    }

    @PutMapping(value = "/enterprises/{id}")
    public ResponseEntity<Contact> updateEnterprise(@PathVariable("id") UUID id, @RequestBody @NonNull ContactDTO body) {
        log.info("Update");
        //todo remplace by body params
        return null;
    }

    @PutMapping(value = "/enterprises/{vat}")
    public ResponseEntity<Contact> findEnterpriseByVatNumber(@PathVariable("vat") UUID id, @RequestBody @NonNull ContactDTO body) {
        log.info("Update");
        //todo remplace by body params
        return null;
    }

    @GetMapping("/enterprises")
    public ResponseEntity<List<EnterpriseDTO>> getAllEnterprises() {
        log.info("REST request to get all contacts");
        return ResponseEntity.status(HttpStatus.OK).body(enterpriseService.findAll());
    }

    @PostMapping("/append")
    public ResponseEntity<Contact> addContactByEnterprise(@RequestBody ContactDTO body) {
        log.info("Create");
        return null;
    }



}
