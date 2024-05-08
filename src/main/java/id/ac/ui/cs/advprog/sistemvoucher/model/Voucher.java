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
        this.voucherId = voucherId;
        this.voucherName = voucherName;
        setDiscountAmount(discountAmount);
        this.maxUsage = Integer.MAX_VALUE;
    }

    public Voucher(long voucherId, String voucherName, int discountAmount, long maxUsage) {
        this.voucherId = voucherId;
        this.voucherName = voucherName;
        setDiscountAmount(discountAmount);
        this.maxUsage = maxUsage;
    }

    public void setDiscountAmount(int discountAmount) {
        if (discountAmount < 0 || discountAmount > 100) {
            throw new IllegalArgumentException();
        } else {
            this.discountAmount = discountAmount;
        }
    }

    public void updateNoOfUsed() {
        if (this.maxUsage > this.noOfUsed) {
            this.noOfUsed++;
        }
    }
}