package api.contactManager.mapper;

import api.contactManager.domain.Contact;
import api.contactManager.dto.ContactDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContactMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "isEmployee", target = "isEmployee")
    @Mapping(source = "tvaNumber", target = "tvaNumber")
    @Mapping(source = "contactAddress", target = "contactAddress")
//    @Mapping(source = "enterpriseList", target = "enterpriseList")
    ContactDTO toDomain(Contact e);
    Contact toMap(ContactDTO dto);
}

