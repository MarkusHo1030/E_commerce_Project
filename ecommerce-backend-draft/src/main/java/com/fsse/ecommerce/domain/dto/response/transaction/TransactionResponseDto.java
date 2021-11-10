package com.fsse.ecommerce.domain.dto.response.transaction;

import com.fsse.ecommerce.domain.Transaction;
import com.fsse.ecommerce.domain.TransactionProduct;
import com.fsse.ecommerce.domain.enumeration.TransactionStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseDto {
    private Long tid;
    private Long buyerUid;
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    private List<TransactionItemResponseDto> items;

    public TransactionResponseDto(Transaction transaction) {
        this.tid = transaction.getTid();
        this.buyerUid = transaction.getBuyer().getUid();
        this.datetime = transaction.getDateTime();
        this.status = transaction.getTransactionStatus();
        this.total = transaction.getTotal();
        this.items = new ArrayList<>();
        for (TransactionProduct tp : transaction.getTransactionProducts()) {
            this.items.add(new TransactionItemResponseDto(tp));
        }
    }

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public Long getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Long buyerUid) {
        this.buyerUid = buyerUid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionItemResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionItemResponseDto> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "TransactionResponseDto{" +
                "tid=" + tid +
                ", buyerUid=" + buyerUid +
                ", datetime=" + datetime +
                ", status=" + status +
                ", total=" + total +
                ", items=" + items +
                '}';
    }
}
