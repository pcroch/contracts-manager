package api.contactManager.service.common;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CrudService<T, ID> { //todo adding generics

    List<T> findAll(); //todo adding generics

    T save(@Valid T dto); //todo adding generics

    T update(UUID id, @Valid T dto); //todo adding generics
}