package test.danamon.microservice.transaction.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import test.danamon.microservice.transaction.entities.CategoryTransactionEntity;

@Repository
public interface CategoryTransactionRepository extends JpaRepository<CategoryTransactionEntity, String> {
    
}
