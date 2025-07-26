package api.contactManager.repository;

import api.contactManager.domain.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository  extends JpaRepository<Address, UUID> {
}