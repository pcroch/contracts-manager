package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.domain.Contact;
import api.contactManager.domain.Enterprise;
import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.errors.BadRequestException;
import api.contactManager.errors.ResourceNotFoundException;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.mapper.EnterpriseMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.repository.EnterpriseRepository;
import api.contactManager.service.EnterpriseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
//@Transactional //todo que faire avec
//@Validated
public class EnterpriseServiceImpl implements EnterpriseService {

    private final EnterpriseRepository enterpriseRepository;

    private final ContactRepository contactRepository;

    private final EnterpriseMapper enterpriseMapper;

    private final ContactMapper contactMapper;


    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, ContactRepository contactRepository, EnterpriseMapper enterpriseMapper, ContactMapper contactMapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.contactRepository = contactRepository;
        this.enterpriseMapper = enterpriseMapper;
        this.contactMapper = contactMapper;
    }


    @Override
    public List<EnterpriseDTO> findAll() {
        return enterpriseRepository.findAll()
                .stream()
                .map(enterpriseMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public EnterpriseDTO save(EnterpriseDTO enterpriseDTO) {
        Enterprise enterprise = enterpriseMapper.toMap(enterpriseDTO); //todo to refactor

        enterprise = enterpriseRepository.save(enterprise);

        return enterpriseMapper.toDomain(enterprise);
    }

    @Override
    public EnterpriseDTO update(UUID id, EnterpriseDTO enterpriseDTO) {

        if (!id.equals(enterpriseDTO.getId())) {
            throw new BadRequestException("Invalid Id, They should match");
        }

        return enterpriseRepository
                .findById(enterpriseDTO.getId())
                .map(enterprise -> {
                            enterpriseMapper.update(enterprise, enterpriseDTO);
                            return enterprise;
                        }
                )
                .map(enterpriseRepository::save)
                .map(enterpriseMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("No enterprise was found with this id :" + enterpriseDTO.getId()));
    }
//
    @Override
    public EnterpriseDTO findEnterpriseByVatNumber(String vatNumber) {
      Enterprise  enterprise =    enterpriseRepository
                .findByVatNumber(vatNumber.trim())
                 .orElseThrow(() -> new ResourceNotFoundException("No enterprise was found with this vat number :" + vatNumber));
        return enterpriseMapper.toDomain(enterprise);
    }

    @Override
    @Transactional
    public void addContactToEnterprise(UUID enterpriseId, UUID contactId) {

        Enterprise enterprise = enterpriseRepository.findById(enterpriseId)
                .orElseThrow(() -> new ResourceNotFoundException("No enterprise was found with this id: " + enterpriseId));

        Contact contact = contactRepository
                .findById(contactId)
                .orElseThrow(() -> new ResourceNotFoundException("No Contact was found with this id: " + contactId));
        contact.getEnterprises().add(enterprise);
        contactRepository.save(contact);
        log.info("the contact {} was added to the enterprise {}", contactId, enterpriseId);
    }
}
