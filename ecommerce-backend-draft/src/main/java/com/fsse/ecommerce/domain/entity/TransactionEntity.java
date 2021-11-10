package com.fsse.ecommerce.domain.entity;

import com.fsse.ecommerce.domain.enumeration.TransactionStatus;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tid", nullable = false, updatable = false, unique = true)
    private Long tid;

    @ManyToOne
    @JoinColumn(name = "buyer_uid", nullable = false)
    private UserEntity buyer;

    @Column(name = "datetime", nullable = false)
    private LocalDateTime dateTime;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @Column(name = "total", nullable = false)
    private BigDecimal total;

    public Long getTid() {
        return tid;
    }

    public void setTid(Long tid) {
        this.tid = tid;
    }

    public UserEntity getBuyer() {
        return buyer;
    }

    public void setBuyer(UserEntity buyerUid) {
        this.buyer = buyerUid;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
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

    @Override
    public String toString() {
        return "TransactionEntity{" +
                "tid=" + tid +
                ", buyerUid=" + buyer +
                ", dateTime=" + dateTime +
                ", status=" + status +
                ", total=" + total +
                '}';
    }
}
