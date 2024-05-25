package id.ac.ui.cs.advprog.sistemvoucher.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoucherModelTest {

    @Test
    void testCreateVoucherUnlimitedQuota() {
        VoucherModel voucher = new VoucherModel(1, "Discount 20%", 20, null);
        assertEquals(1, voucher.getVoucherId());
        assertEquals("Discount 20%", voucher.getVoucherName());
        assertEquals(20, voucher.getDiscountAmount());
        assertEquals(null, voucher.getMaxUsage());
    }

    @Test
    void testCreateVoucherLimitedQuota() {
        VoucherModel voucher = new VoucherModel(1, "Discount 20%", 20, 200L);
        assertEquals(1, voucher.getVoucherId());
        assertEquals("Discount 20%", voucher.getVoucherName());
        assertEquals(20, voucher.getDiscountAmount());
        assertEquals(200, voucher.getMaxUsage());
    }

    @Test
    void updateNoOfUsedVoucher() {
        VoucherModel voucher = new VoucherModel(1, "Discount 20%", 20, 200L);
        voucher.setNoOfUsed(voucher.getNoOfUsed() + 1);
        assertEquals(1, voucher.getNoOfUsed());
    }
}
