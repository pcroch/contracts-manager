package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.errors.BadRequestException;
import api.contactManager.errors.ResourceNotFoundException;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.service.ContactService;
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

    @Override
    public ContactDTO save(ContactDTO contactDTO) {

        Contact contact = contactMapper.toMap(contactDTO);

        contact = contactRepository.save(contact);

        return contactMapper.toDomain(contact);
    }

    @Override
    public ContactDTO update(UUID id, ContactDTO contactDTO) {

        if (!id.equals(contactDTO.getId())) {
            throw new BadRequestException("Invalid Id, They should match");
        }

        return contactRepository
                .findById(contactDTO.getId())
                .map(contact -> {
                            contactMapper.update(contact, contactDTO);
                            return contact;
                        }
                )
                .map(contactRepository::save)
                .map(contactMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + id));
    }

    @Override
    public Optional<String> delete(UUID uuid) {
        return contactRepository.findById(uuid)
                .map(contact -> {
                    String name = contact.getName();
                    String lastname = contact.getLastName();
                    contactRepository.delete(contact);
                    return name + lastname + " has been successfully deleted!";
                });
    }
}
