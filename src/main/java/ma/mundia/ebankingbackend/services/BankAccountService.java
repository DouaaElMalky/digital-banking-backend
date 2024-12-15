package ma.mundia.ebankingbackend.services;

import ma.mundia.ebankingbackend.dtos.*;
import ma.mundia.ebankingbackend.entities.BankAccount;
import ma.mundia.ebankingbackend.entities.CurrentAccount;
import ma.mundia.ebankingbackend.entities.Customer;
import ma.mundia.ebankingbackend.entities.SavingAccount;
import ma.mundia.ebankingbackend.exceptions.BalanceNotSufficentException;
import ma.mundia.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.mundia.ebankingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

public interface BankAccountService {
    CustomerDTO saveCustomer(CustomerDTO customerDTO);
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) throws CustomerNotFoundException;
    List<CustomerDTO> listCustomers();
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficentException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accoundIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficentException;

    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);

//    List<AccountOperationDTO> accountHistory(String accountId);
//    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;
}
