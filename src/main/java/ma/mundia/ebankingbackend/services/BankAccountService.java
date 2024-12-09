package ma.mundia.ebankingbackend.services;

import ma.mundia.ebankingbackend.entities.BankAccount;
import ma.mundia.ebankingbackend.entities.Customer;

import java.util.List;

public interface BankAccountService {
    Customer saveCustomer(Customer customer);
    BankAccount saveBankAccount(double initialBalance, String type, Long customerId);
    List<Customer> listCustomer();
    BankAccount getBankAccount(String accountId);
    void debit(String accountId, double amount, String description);
    void transfer(String accoundIdSource, String accountIdDestination, double amount);
}
