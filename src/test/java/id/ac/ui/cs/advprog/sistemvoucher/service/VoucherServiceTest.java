package id.ac.ui.cs.advprog.sistemvoucher.service;

import id.ac.ui.cs.advprog.sistemvoucher.model.Voucher;
import id.ac.ui.cs.advprog.sistemvoucher.repository.VoucherRepository;

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

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateVoucher() {
        Voucher voucher = new Voucher(1L, "Discount 10%", 10);
        when(voucherRepository.save(voucher)).thenReturn(voucher);

        Voucher savedVoucher = voucherService.createVoucher(voucher);

        assertEquals(voucher.getVoucherId(), savedVoucher.getVoucherId());
        assertEquals(voucher.getVoucherName(), savedVoucher.getVoucherName());
        assertEquals(voucher.getDiscountAmount(), savedVoucher.getDiscountAmount());
    }

    @Test
    public void testFindAllVoucher() {
        Voucher voucher1 = new Voucher(1, "Discount 10%", 10);
        Voucher voucher2 = new Voucher(2, "Discount 20%", 20);
        List<Voucher> vouchers = List.of(voucher1, voucher2);
        when(voucherRepository.findAll()).thenReturn(vouchers);

        List<Voucher> result = voucherService.findAllVoucher();

        assertEquals(vouchers.size(), result.size());
        assertTrue(result.contains(voucher1));
        assertTrue(result.contains(voucher2));
    }

    @Test
    public void testFindVoucherById() {
        long voucherId = 1L;
        Voucher voucher = new Voucher(voucherId, "Discount 10%", 10);
        when(voucherRepository.findById(voucherId)).thenReturn(Optional.of(voucher));

        Optional<Voucher> result = voucherService.findVoucherById(voucherId);

        assertTrue(result.isPresent());
        assertEquals(voucher, result.get());
    }

    @Test
    public void testUpdateVoucher() {
        Voucher voucher = new Voucher(1L, "Test Voucher", 10);
        when(voucherRepository.save(voucher)).thenReturn(voucher);

        Voucher updatedVoucher = voucherService.updateVoucher(voucher);

        assertEquals(voucher, updatedVoucher);
    }

    @Test
    public void testDeleteVoucherById() {
        long voucherId = 1L;

        voucherService.deleteVoucherById(voucherId);

        verify(voucherRepository, times(1)).deleteById(voucherId);
    }
}
