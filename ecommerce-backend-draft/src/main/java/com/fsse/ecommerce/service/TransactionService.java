package com.fsse.ecommerce.service;

import com.fsse.ecommerce.domain.Transaction;

public interface TransactionService {
    Transaction prepareTransaction(long uid);
    Transaction getTransactionByTid(long uid, long tid);
    Transaction completeTransaction(long uid, long tid);
}
