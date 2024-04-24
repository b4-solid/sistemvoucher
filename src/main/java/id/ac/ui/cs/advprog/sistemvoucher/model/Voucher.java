package id.ac.ui.cs.advprog.sistemvoucher.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Voucher {
    private String voucherId;
    private String voucherName;
    private String discountType;
    private double discountAmount;
    private String usageType;
    private int maxUsage;
    private int totalUsed;
}