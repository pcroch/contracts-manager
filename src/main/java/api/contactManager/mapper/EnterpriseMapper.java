package api.contactManager.mapper;

import api.contactManager.domain.Enterprise;
import api.contactManager.dto.EnterpriseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EnterpriseMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "vatNumber", target = "vatNumber")
    @Mapping(source = "enterpriseAddress", target = "enterpriseAddress")
    @Mapping(source = "contacts", target = "contacts")
    EnterpriseDTO toDomain(Enterprise e);

    Enterprise toMap(EnterpriseDTO dto);
}

