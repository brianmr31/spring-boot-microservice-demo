package test.danamon.microservice.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.danamon.microservice.user.entities.BankEntity;

@Repository
public interface BankRepository extends JpaRepository<BankEntity, String> {
    
}
