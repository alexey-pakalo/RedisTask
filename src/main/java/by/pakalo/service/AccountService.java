package by.pakalo.service;

import by.pakalo.model.Account;

import java.util.List;
import java.util.Map;

public interface AccountService {
    void save (Account account);
    void update(Account account);
    void delete(Long id);
    Account findById(Long id);
    List<Account> getAllAccounts(String key);
    List<Account> findAccountById(List<Long> listId );
    Map<Long,Account> getAll();



}
