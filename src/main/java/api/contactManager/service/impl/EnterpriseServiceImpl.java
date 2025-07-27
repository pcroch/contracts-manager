package api.contactManager.service.impl;//package api.contactManager.service.impl;

import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import api.contactManager.mapper.ContactMapper;
import api.contactManager.mapper.EnterpriseMapper;
import api.contactManager.repository.ContactRepository;
import api.contactManager.repository.EnterpriseRepository;
import api.contactManager.service.EnterpriseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
//@Transactional //todo
//@Validated
public class EnterpriseServiceImpl implements EnterpriseService {


    private final EnterpriseRepository enterpriseRepository;

    private final EnterpriseMapper enterpriseMapper;

    public EnterpriseServiceImpl(EnterpriseRepository enterpriseRepository, EnterpriseMapper enterpriseMapper) {
        this.enterpriseRepository = enterpriseRepository;
        this.enterpriseMapper = enterpriseMapper;
    }


    @Override
    public List<EnterpriseDTO> findAll() {
        return enterpriseRepository.findAll()
                .stream()
                .map(enterpriseMapper::toDomain)
                .collect(Collectors.toList());
    }

}
