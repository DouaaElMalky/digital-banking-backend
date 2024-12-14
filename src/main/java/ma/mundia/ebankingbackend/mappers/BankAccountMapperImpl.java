package ma.mundia.ebankingbackend.mappers;

import ma.mundia.ebankingbackend.dtos.CurrentBankAccountDTO;
import ma.mundia.ebankingbackend.dtos.CustomerDTO;
import ma.mundia.ebankingbackend.dtos.SavingBankAccountDTO;
import ma.mundia.ebankingbackend.entities.CurrentAccount;
import ma.mundia.ebankingbackend.entities.Customer;
import ma.mundia.ebankingbackend.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

// MapStruct : framework qui fait ca automatiquement, il genere le code
@Service
public class BankAccountMapperImpl {
    public CustomerDTO fromCustomer(Customer customer){
        CustomerDTO customerDTO = new CustomerDTO();
        // La maniere dynamique
        BeanUtils.copyProperties(customer, customerDTO);
        // La maniere statique
//        customerDTO.setId(customer.getId());
//        customerDTO.setName(customerDTO.getName());
//        customerDTO.setEmail(customerDTO.getEmail());
        return customerDTO;
    }
    public Customer fromCustomerDTO(CustomerDTO customerDTO){
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDTO, customer);
        return customer;
    }

    public SavingBankAccountDTO fromSavingBankAccount(SavingAccount savingAccount){

    }

    public SavingAccount fromSavingBankAccount(SavingBankAccountDTO savingBankAccountDTO){

    }

    public CurrentBankAccountDTO fromCurrentBankAccount(CurrentAccount currentAccount){

    }

    public CurrentAccount fromCurrentBankAccount(CurrentBankAccountDTO currentBankAccountDTO){

    }

}
