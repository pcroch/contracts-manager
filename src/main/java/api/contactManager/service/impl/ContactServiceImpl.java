package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.service.ContactService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;



@Service
//@Transactional //todo
//@Validated
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    private final ContactMapper contactMapper;

    public ContactServiceImpl(ContactRepository contactRepository, ContactMapper contactMapper) {
        this.contactRepository = contactRepository;
        this.contactMapper = contactMapper;
    }


    @Override
    public List<ContactDTO> findAll() {
        return contactRepository.findAll()
                .stream()
                .map(contactMapper::toDomain)
                .collect(Collectors.toList());
    }
}
