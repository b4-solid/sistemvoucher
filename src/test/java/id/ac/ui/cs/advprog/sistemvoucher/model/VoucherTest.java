package id.ac.ui.cs.advprog.sistemvoucher.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class VoucherTest {
    @Test
    void testCreateInvalidDiscountAmount() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Voucher(1, "Discount 20%", 500);
        });
    }

    @Test
    void testCreateVoucherUnlimitedQuota() {
        Voucher voucher = new Voucher(1, "Discount 20%", 20);
        assertEquals(1, voucher.getVoucherId());
        assertEquals("Discount 20%", voucher.getVoucherName());
        assertEquals(20, voucher.getDiscountAmount());
        assertEquals(Integer.MAX_VALUE, voucher.getMaxUsage());
    }

    @Test
    void testCreateVoucherLimitedQuota() {
        Voucher voucher = new Voucher(1, "Discount 20%", 20, 200);
        assertEquals(1, voucher.getVoucherId());
        assertEquals("Discount 20%", voucher.getVoucherName());
        assertEquals(20, voucher.getDiscountAmount());
        assertEquals(200, voucher.getMaxUsage());
    }

    @Test
    void updateNoOfUsedVoucher() {
        Voucher voucher = new Voucher(1, "Discount 20%", 20, 200);
        voucher.updateNoOfUsed();
        assertEquals(1, voucher.getNoOfUsed());
    }
}
