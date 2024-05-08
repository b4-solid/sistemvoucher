package id.ac.ui.cs.advprog.sistemvoucher.service;

import id.ac.ui.cs.advprog.sistemvoucher.model.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherService {

    //C(reate)
    Voucher createVoucher(Voucher voucher);

    //R(Read)
    List<Voucher> findAllVoucher();
    Optional<Voucher> findVoucherById(Long voucherId);

    //U(pdate)
    Voucher updateVoucher(Voucher voucher);

    //D(elete)
    void deleteVoucherById(Long voucherId);
}