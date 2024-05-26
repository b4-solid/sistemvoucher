package id.ac.ui.cs.advprog.sistemvoucher.controller;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;
import id.ac.ui.cs.advprog.sistemvoucher.service.VoucherService;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class VoucherControllerTest {
    @Mock
    private VoucherService voucherService;

    @InjectMocks
    private VoucherController voucherController;

    @SuppressWarnings("deprecation")
    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateVoucher() {
        VoucherModel voucher = new VoucherModel(1L, "Discount 10%", 10, null);
        when(voucherService.createVoucher(voucher)).thenReturn(voucher);

        ResponseEntity<Object> responseEntity = voucherController.createVoucher(voucher);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(voucher, responseEntity.getBody());
    }

    @Test
    public void testFindAllVoucher() {
        VoucherModel voucher1 = new VoucherModel(1, "Discount 10%", 10, null);
        VoucherModel voucher2 = new VoucherModel(2, "Discount 20%", 20, null);
        List<VoucherModel> vouchers = List.of(voucher1, voucher2);
        when(voucherService.findAllVoucher()).thenReturn(vouchers);

        ResponseEntity<Object> responseEntity = voucherController.getAllVoucher();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(vouchers, responseEntity.getBody());
    }

    @Test
    public void testFindVoucherById() {
        long voucherId = 1L;
        VoucherModel voucher = new VoucherModel(voucherId, "Discount 10%", 10, null);
        when(voucherService.findVoucherById(voucherId)).thenReturn(Optional.of(voucher));

        ResponseEntity<Object> responseEntity = voucherController.getVoucherById(voucherId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(Optional.of(voucher), responseEntity.getBody());
    }

    @Test
    public void testUpdateVoucher() {
        VoucherModel voucher = new VoucherModel(1L, "Test Voucher", 10, null);
        when(voucherService.findVoucherById(1L)).thenReturn(Optional.of(voucher));
        when(voucherService.updateVoucher(voucher)).thenReturn(voucher);

        ResponseEntity<Object> responseEntity = voucherController.updateVoucher(1L, voucher);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(voucher, responseEntity.getBody());
    }

    @Test
    public void testDeleteVoucherById() {
        long voucherId = 1L;

        ResponseEntity<Object> responseEntity = voucherController.deleteVoucherById(voucherId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }
}
