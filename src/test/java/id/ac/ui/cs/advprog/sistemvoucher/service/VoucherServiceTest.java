package id.ac.ui.cs.advprog.sistemvoucher.service;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;
import id.ac.ui.cs.advprog.sistemvoucher.repository.VoucherRepository;
import id.ac.ui.cs.advprog.sistemvoucher.service.impl.VoucherServiceImpl;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VoucherServiceTest {
    @Mock
    private VoucherRepository voucherRepository;

    @InjectMocks
    private VoucherServiceImpl voucherService;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateVoucher() {
        VoucherModel voucher = new VoucherModel(1L, "Discount 10%", 10, null);
        when(voucherRepository.save(voucher)).thenReturn(voucher);

        VoucherModel savedVoucher = voucherService.createVoucher(voucher);

        assertEquals(voucher.getVoucherId(), savedVoucher.getVoucherId());
        assertEquals(voucher.getVoucherName(), savedVoucher.getVoucherName());
        assertEquals(voucher.getDiscountAmount(), savedVoucher.getDiscountAmount());
    }

    @Test
    public void testCreateVoucherInvalidDiscountAmount() {
        VoucherModel voucher = new VoucherModel(1L, "Discount 10%", 150, null);
        assertThrows(IllegalArgumentException.class, () -> {
            voucherService.createVoucher(voucher);
        });
    }

    @Test
    public void testCreateVoucherInvalidDiscountAmount2() {
        VoucherModel voucher = new VoucherModel(1L, "Discount 10%", -1, null);
        assertThrows(IllegalArgumentException.class, () -> {
            voucherService.createVoucher(voucher);
        });
    }

    @Test
    public void testFindAllVoucher() {
        VoucherModel voucher1 = new VoucherModel(1, "Discount 10%", 10, null);
        VoucherModel voucher2 = new VoucherModel(2, "Discount 20%", 20, null);
        List<VoucherModel> vouchers = List.of(voucher1, voucher2);
        when(voucherRepository.findAll()).thenReturn(vouchers);

        List<VoucherModel> result = voucherService.findAllVoucher();

        assertEquals(vouchers.size(), result.size());
        assertTrue(result.contains(voucher1));
        assertTrue(result.contains(voucher2));
    }

    @Test
    public void testFindVoucherById() {
        long voucherId = 1L;
        VoucherModel voucher = new VoucherModel(voucherId, "Discount 10%", 10, null);
        when(voucherRepository.findById(voucherId)).thenReturn(Optional.of(voucher));

        Optional<VoucherModel> result = voucherService.findVoucherById(voucherId);

        assertTrue(result.isPresent());
        assertEquals(voucher, result.get());
    }

    @Test
    public void testUpdateVoucher() {
        VoucherModel voucher = new VoucherModel(1L, "Test Voucher", 10, null);
        when(voucherRepository.save(voucher)).thenReturn(voucher);

        VoucherModel updatedVoucher = voucherService.updateVoucher(voucher);

        assertEquals(voucher, updatedVoucher);
    }

    @Test
    public void testUpdateVoucherInvalidDiscountAmount() {
        VoucherModel voucher = new VoucherModel(1L, "Test Voucher", 10, null);
        voucher.setDiscountAmount(150);
        assertThrows(IllegalArgumentException.class, () -> {
            voucherService.updateVoucher(voucher);
        });
    }

    @Test
    public void testUpdateVoucherInvalidDiscountAmount2() {
        VoucherModel voucher = new VoucherModel(1L, "Test Voucher", 10, null);
        voucher.setDiscountAmount(-10);
        assertThrows(IllegalArgumentException.class, () -> {
            voucherService.updateVoucher(voucher);
        });
    }

    @Test
    public void testDeleteVoucherById() {
        long voucherId = 1L;

        voucherService.deleteVoucherById(voucherId);

        verify(voucherRepository, times(1)).deleteById(voucherId);
    }
}
