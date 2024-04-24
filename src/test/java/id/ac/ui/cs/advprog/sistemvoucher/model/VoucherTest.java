package id.ac.ui.cs.advprog.sistemvoucher.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoucherTest {
    Voucher voucher;

    @BeforeEach
    void setUp() {
        this.voucher = new Voucher();
        this.voucher.setVoucherId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        this.voucher.setVoucherName("Discount 20%");
        this.voucher.setDiscountAmount(0.2);
        this.voucher.setMaxUsage(100);
    }

    @Test
    void testGetVoucherId() {
        assertEquals("eb558e9f-1c39-460e-8860-71af6af63bd6", this.voucher.getVoucherId());
    }

    @Test
    void testGetVoucherName() {
        assertEquals("Discount 20%", this.voucher.getVoucherName());
    }

    @Test
    void testGetVoucherDiscountAmount() {
        assertEquals(0.2, this.voucher.getDiscountAmount());
    }

    @Test
    void testGetVoucherMaxUsage() {
        assertEquals(100, this.voucher.getMaxUsage());
    }
}
