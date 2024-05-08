package id.ac.ui.cs.advprog.sistemvoucher.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "vouchers")
@Getter
public class Voucher {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "voucher_id")
    @NotNull
    private long voucherId;

    @Column(name = "voucher_name")
    @NotNull
    private String voucherName;

    @NotNull
    @Column(name = "discount_amount")
    private int discountAmount;

    @Column(name = "max_usage")
    private long maxUsage;

    @Column(name = "noOfUsed")
    private long noOfUsed;

    public Voucher() {
    }

    public Voucher(long voucherId, String voucherName, int discountAmount) {
    }

    public Voucher(long voucherId, String voucherName, int discountAmount, long maxUsage) {
    }

    public void setDiscountAmount(int discountAmount) {
    }

    public void updateNoOfUsed() {
    }
}