package ma.mundia.ebankingbackend.web;

import ma.mundia.ebankingbackend.dtos.*;
import ma.mundia.ebankingbackend.exceptions.BalanceNotSufficentException;
import ma.mundia.ebankingbackend.exceptions.BankAccountNotFoundException;
import ma.mundia.ebankingbackend.services.BankAccountService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class BankAccountRestAPI {
    private BankAccountService bankAccountService;

    public BankAccountRestAPI(BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    @GetMapping("/accounts/{accountId}")
    public BankAccountDTO getBankAccount(@PathVariable String accountId) throws BankAccountNotFoundException {
        return bankAccountService.getBankAccount(accountId);
    }

    @GetMapping("/accounts")
    public List<BankAccountDTO> listAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/accounts/{accountId}/operations")
    public List<AccountOperationDTO> getHistory(@PathVariable String accountId){
        return bankAccountService.accountHistory(accountId);
    }

    @GetMapping("/accounts/{accountId}/pageOperations")
    public AccountHistoryDTO getAccountHistory(
            @PathVariable String accountId,
            @RequestParam(name="page",defaultValue = "0") int page,
            @RequestParam(name="size",defaultValue = "5") int size) throws BankAccountNotFoundException {
        return bankAccountService.getAccountHistory(accountId, page, size);
    }

//    @PostMapping("/accounts/{accountId}/debit")
//    public void debit(
//            @PathVariable String accountId,
//            @RequestParam double amount,
//            @RequestParam String description) throws BankAccountNotFoundException, BalanceNotSufficentException {
//        bankAccountService.debit(accountId, amount, description);
//    }
//
//    @PostMapping("/accounts/{accountId}/credit")
//    public void credit(
//            @PathVariable String accountId,
//            @RequestParam double amount,
//            @RequestParam String description) throws BankAccountNotFoundException {
//        bankAccountService.credit(accountId, amount, description);
//    }
//
//    @PostMapping("/accounts/transfer")
//    public void transfer(
//            @RequestParam String accountIdSource,
//            @RequestParam String accountIdDestination,
//            @RequestParam double amount) throws BankAccountNotFoundException, BalanceNotSufficentException {
//        bankAccountService.transfer(accountIdSource, accountIdDestination, amount);
//    }

    @PostMapping("/accounts/debit")
    public DebitDTO debit(@RequestBody DebitDTO debitDTO) throws BankAccountNotFoundException, BalanceNotSufficentException {
        this.bankAccountService.debit(debitDTO.getAccountId(), debitDTO.getAmount(), debitDTO.getDescription());
        return debitDTO;
    }

    @PostMapping("/accounts/credit")
    public CreditDTO credit(@RequestBody CreditDTO creditDTO) throws BankAccountNotFoundException {
        this.bankAccountService.credit(creditDTO.getAccountId(), creditDTO.getAmount(), creditDTO.getDescription());
        return creditDTO;
    }

    @PostMapping("/accounts/transfer")
    public void transfer(@RequestBody TransferRequestDTO transferRequestDTO) throws BankAccountNotFoundException, BalanceNotSufficentException {
        this.bankAccountService.transfer(
                transferRequestDTO.getAccountSource(),
                transferRequestDTO.getAccountDestination(),
                transferRequestDTO.getAmount()
        );
    }

}
