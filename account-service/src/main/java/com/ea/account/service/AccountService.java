package com.ea.account.service;

import com.ea.account.entity.Account;
import com.ea.account.repository.AccountRepository;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account) throws Exception {
        if (account == null) {
            throw new Exception("Account is empty");
        }

        Account accountByEmail = getByEmail(account.getEmail());
        if (accountByEmail != null) {
            throw new Exception("Email is already registered");
        }

        return accountRepository.save(account);
    }

    public Account getByEmail(String email) {
        return accountRepository.findByEmail(email);
    }

    public Account getById(Long id) {
        return accountRepository.findById(id).get();
    }

    public Account updateAccount(Account postData, Long id) throws Exception {
        Account account = getById(id);

        if (account == null) {
            throw new Exception("account not found!");
        }

        account.setFirstName(postData.getFirstName());
        account.setLastName(postData.getLastName());

        return accountRepository.save(account);

    }

    public Account deleteAccount(Long id) throws Exception {
        Account account = getById(id);

        if (account == null) {
            throw new Exception("Account not found!");
        }

        accountRepository.delete(account);
        return account;
    }

    //create an authentication token
    public String createToken(Long id) {
        return Jwts
                .builder()
                .setSubject(id.toString())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "S@myG@utam123")
                .setExpiration(new Date(System.currentTimeMillis() + 86400000))
                .compact();
    }

    //JWt auth
    public String loginUser(Account account) throws Exception {
        Account user = getByEmail(account.getEmail());

        if (user == null) {
            throw new Exception("User not found!");
        }

        String token = createToken(user.getId());
        user.setToken(token);

        accountRepository.save(user);
        return token;
    }

    //verify token
    public String verifyToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey("S@myG@utam123")
                .parseClaimsJws(token).getBody();
        String userId = claims.getSubject();
        Long accountId = Long.valueOf(userId);

        Account user = getById(accountId);

        if (user == null) {
            return "no";
        }

        return "yes";
    }

}
