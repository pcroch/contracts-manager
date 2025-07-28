package api.contactManager.repository;

import api.contactManager.domain.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, UUID> {
    Optional<Enterprise> findOneByVatNumber(String vatNumber);

}