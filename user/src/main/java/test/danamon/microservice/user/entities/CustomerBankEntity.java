package test.danamon.microservice.user.entities;

import java.io.Serializable;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class CustomerBankEntity implements Serializable {
    
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    private String id;

    @Column(unique=true)
    private String noRekening;

    private String namaCustomer;
    private double balance;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id")
    private BankEntity bank;
}
