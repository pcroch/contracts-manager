package api.contactManager.mapper;

import api.contactManager.domain.Enterprise;
import api.contactManager.dto.EnterpriseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper extends EntityMapper<EnterpriseDTO, Enterprise> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "vatNumber", target = "vatNumber")
    @Mapping(source = "enterpriseAddress", target = "enterpriseAddress")
    @Mapping(source = "contacts", target = "contacts")
    EnterpriseDTO toDto(Enterprise e);

    Enterprise toEntity(EnterpriseDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enterpriseAddress") // ignore = false then we can update directly the address
    @Mapping(target = "contacts", ignore = true)
        // ignore = true then we can not update directly the contact
    void update(@MappingTarget Enterprise entity, EnterpriseDTO dto);
}

