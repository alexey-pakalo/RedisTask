package by.pakalo.controller;

import by.pakalo.model.Account;
import by.pakalo.model.AccountRec;
import by.pakalo.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/save")
    public ResponseEntity<Object> save(@RequestBody Account account){
        try{
            accountService.save(account);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Save failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Object> update(@PathVariable Long id, @RequestBody Account account){
        try{
            if(accountService.findById(id) != null) {
                account.setId(id);
                accountService.update(account);
                return new ResponseEntity<>(HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (Exception e){
            log.error("Update failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @DeleteMapping ("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id){
        try{
            accountService.delete(id);
                return new ResponseEntity<>(HttpStatus.OK);
        }catch (Exception e){
            log.error("Delete failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable Long id){
        try{
            return new ResponseEntity<>(accountService.findById(id),HttpStatus.OK);
        }catch (Exception e){
            log.error("Find by ID failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/list")
    public ResponseEntity<Object> getAllAccounts(){
        try{

            return new ResponseEntity<>( accountService.getAllAccounts("Account"),HttpStatus.OK);
        }catch (Exception e){
            log.error("Find list failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping()
    public ResponseEntity<Object> getAll(){
        try{
            return new ResponseEntity<>( accountService.getAll(),HttpStatus.OK);
        }catch (Exception e){
            log.error("Find all accounts failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @GetMapping("/listbyid")
    public ResponseEntity<Object> findAccountsByListId(@RequestBody AccountRec accountRec){
        try{
            List<Account> accountList = accountService.findAccountById(accountRec.getId());
            return new ResponseEntity<>( accountList,HttpStatus.OK);
        }catch (Exception e){
            log.error("Find list failed: " + e);
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
