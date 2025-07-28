package api.contactManager.mapper;

import api.contactManager.domain.Contact;
import api.contactManager.domain.Enterprise;
import api.contactManager.dto.ContactDTO;
import api.contactManager.dto.EnterpriseDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ContactMapper extends EntityMapper<ContactDTO, Contact> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "isEmployee", target = "isEmployee")
    @Mapping(source = "vatNumber", target = "vatNumber")
    @Mapping(source = "contactAddress", target = "contactAddress")
    @Mapping(source = "enterprises", target = "enterprises")
    ContactDTO toDto(Contact e);

    Contact toEntity(ContactDTO dto);

    @Override
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "enterprises", ignore = true)
        // ignore = true then we can not update directly the entreprises
    void update(@MappingTarget Contact entity, ContactDTO dto);
}


