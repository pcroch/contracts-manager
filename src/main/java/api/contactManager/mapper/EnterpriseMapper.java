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
    EnterpriseDTO toDomain(Enterprise e);

    Enterprise toMap(EnterpriseDTO dto);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "vatNumber")
    @Mapping(target = "enterpriseAddress", ignore = true)
    @Mapping(target = "contacts", ignore = true)
    void updateEnterprise(EnterpriseDTO dto, @MappingTarget Enterprise entity);
}

