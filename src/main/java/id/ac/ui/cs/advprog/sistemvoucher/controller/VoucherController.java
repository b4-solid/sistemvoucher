package id.ac.ui.cs.advprog.sistemvoucher.controller;

import id.ac.ui.cs.advprog.sistemvoucher.model.Voucher;
import id.ac.ui.cs.advprog.sistemvoucher.service.VoucherService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/voucher")
public class VoucherController {
    @Autowired
    private VoucherService voucherService;

    @PostMapping
    public ResponseEntity<Object> createVoucher(@RequestBody Voucher voucher) {
        Voucher createdVoucher = voucherService.createVoucher(voucher);
        return new ResponseEntity<>(createdVoucher, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Object> getAllVoucher() {
        List<Voucher> vouchers = voucherService.findAllVoucher();
        return new ResponseEntity<>(vouchers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getVoucherById(@PathVariable("id") Long id) {
        Optional<Voucher> voucher = voucherService.findVoucherById(id);
        return new ResponseEntity<>(voucher, HttpStatus.OK);
    }

    @PutMapping()
    public ResponseEntity<Object> updateVoucher(@RequestBody Voucher voucher) {
        Voucher updatedVoucher = voucherService.updateVoucher(voucher);
        return new ResponseEntity<>(updatedVoucher, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteVoucherById(@PathVariable("id") Long id) {
        voucherService.deleteVoucherById(id);
        return ResponseEntity.ok().build();
    }
}