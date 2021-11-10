package com.fsse.ecommerce.api;

import com.fsse.ecommerce.domain.Transaction;
import com.fsse.ecommerce.domain.User;
import com.fsse.ecommerce.domain.dto.response.transaction.TransactionResponseDto;
import com.fsse.ecommerce.service.TransactionService;
import com.fsse.ecommerce.util.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
    @Autowired
    private TransactionService transactionService;

    @PostMapping("/prepare")
    public TransactionResponseDto prepareTransaction(Principal principal) {
        User user = SecurityUtil.getUser(principal);

        Transaction transaction = transactionService.prepareTransaction(user.getUid());
        if (transaction != null) {
            return new TransactionResponseDto(transaction);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/tid/{tid}")
    public TransactionResponseDto getTransaction(Principal principal, @PathVariable("tid") Long tid) {
        User user = SecurityUtil.getUser(principal);
        Transaction transaction = transactionService.getTransactionByTid(user.getUid(), tid);
        if (transaction != null) {
            return new TransactionResponseDto(transaction);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/tid/{tid}/pay")
    public TransactionResponseDto payTransaction(Principal principal, @PathVariable("tid") Long tid) {
        User user = SecurityUtil.getUser(principal);
        Transaction transaction = transactionService.completeTransaction(user.getUid(), tid);
        if (transaction != null) {
            return new TransactionResponseDto(transaction);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
