package id.ac.ui.cs.advprog.sistemvoucher.service.impl;

import id.ac.ui.cs.advprog.sistemvoucher.model.Voucher;
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
    public Voucher createVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    //R(Read)
    @Override
    public List<Voucher> findAllVoucher() {
        return voucherRepository.findAll();
    }

    @Override
    public Optional<Voucher> findVoucherById(Long voucherId) {
        return voucherRepository.findById(voucherId);
    }

    //U(pdate)
    @Override
    public Voucher updateVoucher(Voucher voucher) {
        return voucherRepository.save(voucher);
    }

    //D(elete)
    @Override
    public void deleteVoucherById(Long voucherId) {
        voucherRepository.deleteById(voucherId);
    }
}