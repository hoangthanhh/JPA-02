package NhanVien.repository;

import NhanVien.Models.PhanCong;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPhanCongRepo extends JpaRepository<PhanCong,Integer> {
}
