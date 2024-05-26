package id.ac.ui.cs.advprog.sistemvoucher.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name = "vouchers")
@Getter
@Setter
public class VoucherModel {
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
    private Integer discountAmount;

    @Column(name = "max_usage")
    private Long maxUsage;

    @Column(name = "noOfUsed")
    private long noOfUsed;

    public VoucherModel() {
    }

    public VoucherModel(long voucherId, String voucherName, Integer discountAmount, Long maxUsage) {
        this.voucherId = voucherId;
        this.voucherName = voucherName;
        this.discountAmount = discountAmount;
        this.maxUsage = maxUsage;
    }
}