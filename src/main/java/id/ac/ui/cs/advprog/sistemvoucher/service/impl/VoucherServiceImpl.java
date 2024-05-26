package id.ac.ui.cs.advprog.sistemvoucher.service.impl;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;
import id.ac.ui.cs.advprog.sistemvoucher.repository.VoucherRepository;
import id.ac.ui.cs.advprog.sistemvoucher.service.VoucherService;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class VoucherServiceImpl implements VoucherService {
    private final VoucherRepository voucherRepository;

    public VoucherServiceImpl(VoucherRepository voucherRepository) {
        this.voucherRepository = voucherRepository;
    }

    //C(reate)
    @Override
    public VoucherModel createVoucher(VoucherModel voucher) {
        if (voucher.getDiscountAmount() > 100 || voucher.getDiscountAmount() < 0) {
            throw new IllegalArgumentException("Discount amount must be between 0 and 100");
        }

        return voucherRepository.save(voucher);
    }

    //R(Read)
    @Override
    public List<VoucherModel> findAllVoucher() {
        return voucherRepository.findAll();
    }

    @Override
    public Optional<VoucherModel> findVoucherById(Long voucherId) {
        return voucherRepository.findById(voucherId);
    }

    //U(pdate)
    @Override
    public VoucherModel updateVoucher(VoucherModel voucher) {

        if (voucher.getDiscountAmount() > 100 || voucher.getDiscountAmount() < 0) {
            throw new IllegalArgumentException("Discount amount must be between 0 and 100");
        }

        return voucherRepository.save(voucher);
    }

    //D(elete)
    @Override
    public void deleteVoucherById(Long voucherId) {
        voucherRepository.deleteById(voucherId);
    }
}