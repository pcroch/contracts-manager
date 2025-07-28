package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.domain.Contact;
import api.contactManager.domain.Enterprise;
import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.mapper.EnterpriseMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.repository.EnterpriseRepository;
import api.contactManager.service.EnterpriseService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
//@Transactional
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
        Enterprise enterprise = enterpriseMapper.toMap(enterpriseDTO);

        enterprise = enterpriseRepository.save(enterprise);

        return enterpriseMapper.toDomain(enterprise);
    }

    @Override
    public Optional<EnterpriseDTO> update(EnterpriseDTO enterpriseDTO) {
        return enterpriseRepository
                .findById(enterpriseDTO.getId())
                .map(enterprise -> {
                            enterpriseMapper.update(enterprise,enterpriseDTO);
                            return enterprise;
                        }
                )
                .map(enterpriseRepository::save)
                .map(enterpriseMapper::toDomain);
    }

    @Override
    public Optional<EnterpriseDTO> findEnterpriseByVatNumber(String vatNumber) {

        if (vatNumber == null || vatNumber.trim().isEmpty()) {
            // Or throw an IllegalArgumentException
            return Optional.empty();
        }
        return enterpriseRepository
                .findByVatNumber(vatNumber)
                .map(enterpriseMapper::toDomain);
    }

    @Override
    @Transactional
    public ContactDTO addContactToEnterprise(UUID enterpriseId, UUID contactId) {

        Enterprise enterprise = enterpriseRepository.findById(enterpriseId)
                .orElseThrow(() -> new RuntimeException("No enterprise was found with this id: " + enterpriseId));

       Contact contact =  contactRepository
                .findById(contactId)
                .orElseThrow(() -> new RuntimeException("No Contact was found with this id: " + contactId));;

//        enterprise.addContact(contact);
//
//        enterpriseRepository.save(enterprise);
//        return enterpriseMapper.toDomain(enterprise);

        if (contact.getEnterprises().add(enterprise)) {
            enterprise.getContacts().add(contact);
            System.out.println("Enterprise " + enterprise.getVatNumber() + " added to Contact " + contact.getName());
        } else {
            System.out.println("Enterprise " + enterprise.getVatNumber() + " was already associated with Contact " + contact.getName());
        }

        // 4. Sauvegarder le Contact (car Contact est le côté propriét
        Contact updatedContact = contactRepository.save(contact);

        // 5. Mapper et retourner le DTO du contact mis à jour
        return contactMapper.toDomain(updatedContact);

    }

//enterprise.setContacts(Set.of(contactMapper.toMap(contactDTO)))
}
