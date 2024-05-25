package id.ac.ui.cs.advprog.sistemvoucher.repository;

import id.ac.ui.cs.advprog.sistemvoucher.model.VoucherModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoucherRepository extends JpaRepository<VoucherModel, Long> {

}