package id.ac.ui.cs.advprog.sistemvoucher.controller;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;
import id.ac.ui.cs.advprog.sistemvoucher.service.VoucherService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vouchers")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping
    public ResponseEntity<Object> createVoucher(@RequestBody VoucherModel voucher) {
        VoucherModel createdVoucher;

        try {
            createdVoucher = voucherService.createVoucher(voucher);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(createdVoucher, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllVoucher() {
        List<VoucherModel> vouchers = voucherService.findAllVoucher();
        return new ResponseEntity<>(vouchers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVoucherById(@PathVariable("id") Long id) {
        Optional<VoucherModel> voucher = voucherService.findVoucherById(id);
        return new ResponseEntity<>(voucher, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateVoucher(@PathVariable Long id, @RequestBody VoucherModel voucher) {
        VoucherModel updatedVoucher;

        try {
            voucher.setVoucherId(id);
            updatedVoucher = voucherService.updateVoucher(voucher);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(updatedVoucher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVoucherById(@PathVariable("id") Long id) {
        voucherService.deleteVoucherById(id);
        return ResponseEntity.ok().build();
    }
}