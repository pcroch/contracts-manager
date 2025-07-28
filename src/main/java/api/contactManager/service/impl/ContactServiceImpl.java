package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import api.contactManager.errors.BadRequestException;
import api.contactManager.errors.ResourceNotFoundException;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.service.ContactService;
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
//@Transactional //todo que faire
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
                .map(contactMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public ContactDTO save(ContactDTO contactDTO) { //todo to refactor

        Contact contact = contactMapper.toEntity(contactDTO);

        contact = contactRepository.save(contact);

        return contactMapper.toDto(contact);
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
                .map(contactMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + id));
    }

    @Override
    public void delete(UUID uuid) {
        Contact contact = contactRepository
                .findById(uuid)
                .orElseThrow(() -> new ResourceNotFoundException("No contact was found with this id :" + uuid));
        contactRepository.delete(contact);
        log.info("the contact {} was deleted  permanently", uuid);
    }
}
