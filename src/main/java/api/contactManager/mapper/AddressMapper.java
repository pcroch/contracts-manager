package api.contactManager.mapper;

import api.contactManager.domain.Address;
import api.contactManager.dto.AddressDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AddressMapper extends EntityMapper<AddressDTO, Address> {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "streetNumber", target = "streetNumber")
    @Mapping(source = "boxNumber", target = "boxNumber")
    @Mapping(source = "streetName", target = "streetName")
    @Mapping(source = "zipcode", target = "zipcode")
    @Mapping(source = "locality", target = "locality")
    @Mapping(source = "country", target = "country")
    @Mapping(source = "contact", target = "contact")
    @Mapping(source = "enterprise", target = "enterprise")
    AddressDTO toDto(Address e);
    Address toEntity(AddressDTO dto);
}

