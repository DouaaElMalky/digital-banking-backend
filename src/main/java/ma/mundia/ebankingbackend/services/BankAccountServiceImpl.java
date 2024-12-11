package ma.mundia.ebankingbackend.services;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.mundia.ebankingbackend.entities.BankAccount;
import ma.mundia.ebankingbackend.entities.CurrentAccount;
import ma.mundia.ebankingbackend.entities.Customer;
import ma.mundia.ebankingbackend.entities.SavingAccount;
import ma.mundia.ebankingbackend.exceptions.CustomerNotFoundException;
import ma.mundia.ebankingbackend.repositories.AccountOperationRepository;
import ma.mundia.ebankingbackend.repositories.BankAccountRepository;
import ma.mundia.ebankingbackend.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
@AllArgsConstructor
@Slf4j

public class BankAccountServiceImpl implements BankAccountService{
    private CustomerRepository customerRepository;
    private BankAccountRepository bankAccountRepository;
    private AccountOperationRepository accountOperationRepository;

    @Override
    public Customer saveCustomer(Customer customer) {
        log.info("Saving new Customer");
        Customer savedCustomer = customerRepository.save(customer);
        return savedCustomer;
    }

    @Override
    public BankAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public BankAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException {
        return null;
    }

    @Override
    public BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException {
        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null)
            throw new CustomerNotFoundException("Customer not founc");
        BankAccount bankAccount;
        if (type.equals("current")){
            bankAccount = new CurrentAccount();
        }else {
            bankAccount = new SavingAccount();
        }
        bankAccount.setId(UUID.randomUUID().toString());
        bankAccount.setCreatedAt(new Date());
        bankAccount.setBalance(initialBalance);
        bankAccount.setCustomer(customer);
        return null;
    }

    @Override
    public List<Customer> listCustomer() {
        return null;
    }

    @Override
    public BankAccount getBankAccount(String accountId) {
        return null;
    }

    @Override
    public void debit(String accountId, double amount, String description) {

    }

    @Override
    public void credit(String accountId, double amount, String description) {

    }

    @Override
    public void transfer(String accoundIdSource, String accountIdDestination, double amount) {

    }
}
