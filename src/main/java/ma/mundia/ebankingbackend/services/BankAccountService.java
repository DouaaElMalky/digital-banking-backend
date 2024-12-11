package ma.mundia.ebankingbackend.services;

import ma.mundia.ebankingbackend.entities.BankAccount;
import ma.mundia.ebankingbackend.entities.Customer;
import ma.mundia.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    BankAccount saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;

    BankAccount saveBankAccount(double initialBalance, String type, Long customerId) throws CustomerNotFoundException;

    List<Customer> listCustomer();
    BankAccount getBankAccount(String accountId);
    void debit(String accountId, double amount, String description);
    void credit(String accountId, double amount, String description);
    void transfer(String accoundIdSource, String accountIdDestination, double amount);
}
