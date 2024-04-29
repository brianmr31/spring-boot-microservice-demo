package test.danamon.microservice.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.danamon.microservice.user.entities.CustomerBankEntity;

@Repository
public interface CustomerBankRepository extends JpaRepository<CustomerBankEntity, String> {
    
    @Query("Select a from CustomerBankEntity a where a.id = :id ")
    public CustomerBankEntity getById(@Param("id")String id);

    @Query("Select a from CustomerBankEntity a where a.noRekening = :rek ")
    public CustomerBankEntity getByNorek(@Param("rek")String rek);
}
