package api.contactManager.service.common;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

public interface CrudService<T, ID> {

    List<T> findAll();

    T save(@Valid T dto);

    T update(UUID id, @Valid T dto);
}