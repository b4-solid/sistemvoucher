package id.ac.ui.cs.advprog.sistemvoucher.service;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;

import java.util.List;
import java.util.Optional;

public interface VoucherService {

    //C(reate)
    VoucherModel createVoucher(VoucherModel voucher);

    //R(Read)
    List<VoucherModel> findAllVoucher();
    Optional<VoucherModel> findVoucherById(Long voucherId);

    //U(pdate)
    VoucherModel updateVoucher(VoucherModel voucher);

    //D(elete)
    void deleteVoucherById(Long voucherId);
}