package ma.mundia.ebankingbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ma.mundia.ebankingbackend.enums.AccountStatus;

import java.util.Date;
import java.util.List;
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE", length = 4) //Dans la strategie TABLE_PER_CLASS ou JOINED, cette annotation n'a plus de sens
@Data @NoArgsConstructor @AllArgsConstructor
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;

    @Enumerated(EnumType.STRING) //stocker status en format string
    private AccountStatus status;

    @ManyToOne
    private Customer customer;

    //LAZY-> charger les donnes que en cas de demande
    //EAGER -> a chaque fois que je te demande de me charger un compte, charge automatiquement toutes les operations, c'est risque car il ramene toutes les donnees
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY)
    private List<AccountOperation> accountOperations;
}
