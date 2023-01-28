package by.pakalo.service;

import by.pakalo.model.Account;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
public class AccountServiceImpl implements AccountService  {

  private static final String ACCOUNT_KEY = "Account";

  private final RedisTemplate<String,Object> redisTemplate;
  private  HashOperations<String, Long, Account> hashOperations;

    public AccountServiceImpl(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @PostConstruct
    public void init(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(Account account) {
      hashOperations.put(ACCOUNT_KEY,account.getId(),account);
    }

    @Override
    public void update(Account account) {
      hashOperations.put(ACCOUNT_KEY,account.getId(),account);

    }

    @Override
    public void delete(Long id) {
      hashOperations.delete(ACCOUNT_KEY,id);
    }

    @Override
    public Account findById(Long id) {
        return hashOperations.get(ACCOUNT_KEY,id);
    }

    @Override
    public List<Account> getAllAccounts(String key) {
        return hashOperations.values(key) ;
    }

    @Override
    public List<Account> findAccountById(List<Long> listId) {
        return hashOperations.multiGet(ACCOUNT_KEY,listId);
    }

    @Override
    public Map<Long, Account> getAll() {
        return hashOperations.entries(ACCOUNT_KEY);
    }
}
